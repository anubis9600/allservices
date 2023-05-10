package com.asystresources.erp.comptabilite.feature.analytic.billingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.asystresources.erp.comptabilite.feature.analytic.billingservice.model.Customer;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    
    @GetMapping(path = "/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
}
