package com.Test;

import org.springframework.boot.SpringApplication;

public class TestForTestApplication {

	public static void main(String[] args) {
		SpringApplication.from(ForTestApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
