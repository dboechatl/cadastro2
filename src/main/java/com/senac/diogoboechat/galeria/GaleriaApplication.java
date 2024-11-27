package com.senac.diogoboechat.galeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class GaleriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaleriaApplication.class, args);
	}

}
