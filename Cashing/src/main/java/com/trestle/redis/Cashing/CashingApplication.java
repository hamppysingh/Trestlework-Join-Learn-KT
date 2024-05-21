package com.trestle.redis.Cashing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.trestle.redis.Caching")
@EnableCaching
public class CashingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashingApplication.class, args);
	}

}
