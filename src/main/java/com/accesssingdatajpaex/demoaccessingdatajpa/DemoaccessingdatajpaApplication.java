package com.accesssingdatajpaex.demoaccessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DemoaccessingdatajpaApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoaccessingdatajpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoaccessingdatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			//save a few customers
			repository.save(new Customer("Maluum", "Ashe" ));
			repository.save(new Customer("Aza", "Ashe"));
			repository.save(new Customer("Ekevu", "Ashe"));
			repository.save(new Customer("Xolani", "Ashe"));
			repository.save(new Customer("Makota", "Ashe"));
			repository.save(new Customer("Kamau", "Rikondja"));
			repository.save(new Customer("Osahar", "Rikondja"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Ashe'):");
			log.info("Customer found with findByLastName('Rikondja'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Ashe").forEach(ashe -> {
				log.info(ashe.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");



		};
	}


}
