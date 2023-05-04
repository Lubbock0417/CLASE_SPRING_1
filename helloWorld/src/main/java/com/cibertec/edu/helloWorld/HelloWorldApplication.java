package com.cibertec.edu.helloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("EXECUTING : command line runner");
		
		for (int i = 0; i < args.length; ++i) {
			logger.info("args[{}]: {}", i, args[i]);
		}
		
	}
}
