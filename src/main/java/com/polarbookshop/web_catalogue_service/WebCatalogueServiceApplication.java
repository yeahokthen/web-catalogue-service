package com.polarbookshop.web_catalogue_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class WebCatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCatalogueServiceApplication.class, args);
	}

}
