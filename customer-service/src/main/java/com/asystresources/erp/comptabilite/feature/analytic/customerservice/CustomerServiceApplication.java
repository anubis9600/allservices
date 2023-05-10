package com.asystresources.erp.comptabilite.feature.analytic.customerservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.asystresources.erp.comptabilite.feature.analytic.customerservice.entity.Customer;
import com.asystresources.erp.comptabilite.feature.analytic.customerservice.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
												RepositoryRestConfiguration restConfiguration){
		return args ->{
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.saveAll(
				List.of(
					Customer.builder().name("Bonheur").email("bonheur@gmail.com").build(),
					Customer.builder().name("Julienne").email("jull@gmail.com").build(),
					Customer.builder().name("Divine").email("divin@gmail.com").build()
				)
			);
			customerRepository.findAll().forEach(c -> {
				System.out.println(c);
			});
		};
	}
}
