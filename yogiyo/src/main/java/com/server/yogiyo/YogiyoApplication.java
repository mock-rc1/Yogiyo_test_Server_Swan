package com.server.yogiyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YogiyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogiyoApplication.class, args);
	}

}
