package com.ominext.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by DUCTOI on 6/9/2017.
 */
@SpringBootApplication(scanBasePackages = { "com.ominext.hrm" })
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

}
