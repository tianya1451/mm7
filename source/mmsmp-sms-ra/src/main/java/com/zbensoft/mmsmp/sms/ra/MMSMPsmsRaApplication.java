package com.zbensoft.mmsmp.sms.ra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class MMSMPsmsRaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MMSMPsmsRaApplication.class, args);
	}
}
