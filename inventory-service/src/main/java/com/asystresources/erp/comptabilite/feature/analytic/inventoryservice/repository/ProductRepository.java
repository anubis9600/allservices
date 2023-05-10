package com.asystresources.erp.comptabilite.feature.analytic.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.asystresources.erp.comptabilite.feature.analytic.inventoryservice.entity.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
