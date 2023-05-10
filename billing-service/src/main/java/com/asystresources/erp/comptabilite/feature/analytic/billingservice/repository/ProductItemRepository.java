package com.asystresources.erp.comptabilite.feature.analytic.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asystresources.erp.comptabilite.feature.analytic.billingservice.entity.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    
}
