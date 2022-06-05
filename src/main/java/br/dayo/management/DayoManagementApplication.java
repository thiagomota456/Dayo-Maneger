package br.dayo.management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DayoManagementApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(DayoManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
