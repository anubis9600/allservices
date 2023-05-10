package com.asystresources.erp.comptabilite.feature.analytic.customerservice.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer", types = Customer.class)
public interface CustomerProjection {
    
    public int getId();
    public String getName();
}