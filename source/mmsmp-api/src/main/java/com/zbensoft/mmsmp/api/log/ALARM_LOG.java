package com.zbensoft.mmsmp.api.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ALARM_LOG {

	private static Logger log = LoggerFactory.getLogger(ALARM_LOG.class);
	
	public static void DEBUG(String msg) {
		log.debug(msg);
	}
	
	public static void INFO(String msg) {
		log.info(msg);
	}
	
	public static void WARN(String msg) {
		log.warn(msg);
	}
	
	public static void ERROR(String msg) {
		log.error(msg);
	}
	
}
