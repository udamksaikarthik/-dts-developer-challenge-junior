package com.karthik.developerchallengejr;

import org.springframework.boot.SpringApplication;

public class TestDeveloperchallengejrApplication {

	public static void main(String[] args) {
		SpringApplication.from(DeveloperchallengejrApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
