package com.asystresources.erp.comptabilite.feature.analytic.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asystresources.erp.comptabilite.feature.analytic.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
