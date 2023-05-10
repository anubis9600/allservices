package com.asystresources.erp.comptabilite.feature.analytic.inventoryservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.asystresources.erp.comptabilite.feature.analytic.inventoryservice.entity.Product;
import com.asystresources.erp.comptabilite.feature.analytic.inventoryservice.repository.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository,
												RepositoryRestConfiguration restConfiguration){
		return args->{
			restConfiguration.exposeIdsFor(Product.class);
			productRepository.saveAll(
				List.of(
					Product.builder().name("Computer").price(200).quanity(200).build(),
					Product.builder().name("Mouse").price(1200).quanity(12).build(),
					Product.builder().name("Printer").price(800000).quanity(6).build()
				)	
			);
			productRepository.findAll().forEach(p->{
				System.out.println(p);
			});
		};
	}

}
