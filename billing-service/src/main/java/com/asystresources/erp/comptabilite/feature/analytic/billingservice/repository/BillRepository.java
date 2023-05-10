package com.asystresources.erp.comptabilite.feature.analytic.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asystresources.erp.comptabilite.feature.analytic.billingservice.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    
}
