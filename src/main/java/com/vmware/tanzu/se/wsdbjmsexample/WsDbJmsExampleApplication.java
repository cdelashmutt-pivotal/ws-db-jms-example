package com.vmware.tanzu.se.wsdbjmsexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WsDbJmsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsDbJmsExampleApplication.class, args);
	}

}
