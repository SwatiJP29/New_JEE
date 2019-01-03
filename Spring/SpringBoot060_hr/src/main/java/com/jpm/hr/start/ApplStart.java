package com.jpm.hr.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

//http:localhost:8082/home

@SpringBootApplication
@ComponentScan("com.jp.hr.controllers, com.jpm.hr.service, com.jpm.hr.daos")
@EntityScan("com.jp.hr.entities")
public class ApplStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplStart.class, args);

	}

}
