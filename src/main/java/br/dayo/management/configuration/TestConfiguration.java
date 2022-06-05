package br.dayo.management.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.dayo.management.services.DBService;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() {
		try {
			dbService.instantiateTestDatabase();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
}
