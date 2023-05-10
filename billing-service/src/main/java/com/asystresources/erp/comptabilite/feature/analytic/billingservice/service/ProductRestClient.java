package com.asystresources.erp.comptabilite.feature.analytic.billingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.asystresources.erp.comptabilite.feature.analytic.billingservice.model.Product;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {

    @GetMapping(path = "/products/{id}")
    Product finProductById(@PathVariable Long id);

    @GetMapping(path = "/products")
    PagedModel<Product> allProducts();
}
