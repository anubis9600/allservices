package com.asystresources.erp.comptabilite.feature.analytic.billingservice;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.asystresources.erp.comptabilite.feature.analytic.billingservice.entity.Bill;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.entity.ProductItem;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.model.Customer;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.model.Product;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.repository.BillRepository;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.repository.ProductItemRepository;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.service.CustomerRestClient;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.service.ProductRestClient;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient){
		return args ->{
			Collection<Product> products = productRestClient.allProducts().getContent();
			Bill bill = new Bill();
			Long customerId = 1L;
			Customer customer = customerRestClient.findCustomerById(customerId);
			if (customer == null) throw new RuntimeException("Ce client est introuvable");
			bill.setBillDate(new Date());
			bill.setCustomerId(customerId);
			Bill savedBill = billRepository.save(bill);
			products.forEach(product->{
				ProductItem productItem = new ProductItem();
				productItem.setBill(savedBill);
				productItem.setQuantity(1+new Random().nextInt(10));
				productItem.setPrice(product.getPrice());
				productItem.setDiscount(Math.random());
				productItem.setProductId(product.getId());
				productItemRepository.save(productItem);
			});
			
		};							
	}

}
