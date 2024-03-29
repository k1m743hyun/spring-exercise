package com.k1m743hyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SimplePropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.k1m743hyun.SimpleConfigPropertiesApplication.class, args);
	}
}
