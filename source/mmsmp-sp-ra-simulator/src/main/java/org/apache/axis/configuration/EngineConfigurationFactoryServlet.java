package org.apache.axis.configuration;

import org.apache.axis.AxisProperties;
import org.apache.axis.ConfigurationException;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.EngineConfigurationFactory;
import org.apache.axis.components.logger.LogFactory;
import org.apache.axis.server.AxisServer;
import org.apache.axis.utils.ClassUtils;
import org.apache.axis.utils.Messages;
import org.apache.commons.logging.Log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.InputStream;


//如果通过springboot的内部tomcat。则需要用到该类。如果通过外部tomcat启动。则不需要该类。去掉该类即可。
public class EngineConfigurationFactoryServlet extends EngineConfigurationFactoryDefault {

	protected static Log log = LogFactory.getLog(EngineConfigurationFactoryServlet.class.getName());

	private ServletConfig cfg;

	/**
	 * Creates and returns a new EngineConfigurationFactory. If a factory cannot
	 * be created, return 'null'.
	 * 
	 * The factory may return non-NULL only if: - it knows what to do with the
	 * param (param instanceof ServletContext) - it can find it's configuration
	 * information
	 * 
	 * @see org.apache.axis.configuration.EngineConfigurationFactoryFinder
	 */
	public static EngineConfigurationFactory newFactory(Object param) {
		/**
		 * Default, let this one go through if we find a ServletContext.
		 * 
		 * The REAL reason we are not trying to make any decision here is
		 * because it's impossible (without refactoring FileProvider) to
		 * determine if a *.wsdd file is present or not until the configuration
		 * is bound to an engine.
		 * 
		 * FileProvider/EngineConfiguration pretend to be independent, but they
		 * are tightly bound to an engine instance...
		 */
		return (param instanceof ServletConfig) ? new EngineConfigurationFactoryServlet((ServletConfig) param) : null;
	}

	/**
	 * Create the default engine configuration and detect whether the user has
	 * overridden this with their own.
	 */
	protected EngineConfigurationFactoryServlet(ServletConfig conf) {
		super();
		this.cfg = conf;
	}

	/**
	 * Get a default server engine configuration.
	 *
	 * @return a server EngineConfiguration
	 */
	public EngineConfiguration getServerEngineConfig() {
		return getServerEngineConfig(cfg);
	}

	/**
	 * Get a default server engine configuration in a servlet environment.
	 *
	 * @param ctx
	 *            a ServletContext
	 * @return a server EngineConfiguration
	 */
	private static EngineConfiguration getServerEngineConfig(ServletConfig cfg) {

		ServletContext ctx = cfg.getServletContext();

		// Respect the system property setting for a different config file
		String configFile = cfg.getInitParameter(OPTION_SERVER_CONFIG_FILE);
		if (configFile == null)
			configFile = AxisProperties.getProperty(OPTION_SERVER_CONFIG_FILE);
		if (configFile == null) {
			configFile = SERVER_CONFIG_FILE;
		}

		/**
		 * Flow can be confusing. Here is the logic: 1) Make all attempts to
		 * open resource IF it exists - If it exists as a file, open as file
		 * (r/w) - If not a file, it may still be accessable as a stream (r)
		 * (env will handle security checks). 2) If it doesn't exist, allow it
		 * to be opened/created
		 * 
		 * Now, the way this is done below is: a) If the file does NOT exist,
		 * attempt to open as a stream (r) b) Open named file (opens existing
		 * file, creates if not avail).
		 */

		/*
		 * Use the WEB-INF directory (so the config files can't get snooped by a
		 * browser)
		 */
		String appWebInfPath = "/WEB-INF";

		FileProvider config = null;

		String realWebInfPath = ctx.getRealPath(appWebInfPath);

		/**
		 * If path/file doesn't exist, it may still be accessible as a
		 * resource-stream (i.e. it may be packaged in a JAR or WAR file).
		 */
		if (realWebInfPath == null || !(new File(realWebInfPath, configFile)).exists()) {
			String name = appWebInfPath + "/" + configFile;
			InputStream is = ctx.getResourceAsStream(name);
			if (is != null) {
				// FileProvider assumes responsibility for 'is':
				// do NOT call is.close().
				config = new FileProvider(is);
			}

			if (config == null) {
				log.error(Messages.getMessage("servletEngineWebInfError03", name));
			}
		}

		/**
		 * Couldn't get data OR file does exist. If we have a path, then attempt
		 * to either open the existing file, or create an (empty) file.
		 */
		if (config == null && realWebInfPath != null) {
			try {
				config = new FileProvider(realWebInfPath, configFile);
			} catch (ConfigurationException e) {
				log.error(Messages.getMessage("servletEngineWebInfError00"), e);
			}
		}

		/**
		 * Fall back to config file packaged with AxisEngine
		 */
		if (config == null) {
			log.warn(Messages.getMessage("servletEngineWebInfWarn00"));
			try {
				InputStream is = ClassUtils.getResourceAsStream(AxisServer.class, SERVER_CONFIG_FILE);
				config = new FileProvider(is);
			} catch (Exception e) {
				log.error(Messages.getMessage("servletEngineWebInfError02"), e);
			}
		}

		return config;
	}
}
