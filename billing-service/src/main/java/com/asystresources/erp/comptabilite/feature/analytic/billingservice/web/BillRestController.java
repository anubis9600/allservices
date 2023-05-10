package com.asystresources.erp.comptabilite.feature.analytic.billingservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asystresources.erp.comptabilite.feature.analytic.billingservice.entity.Bill;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.repository.BillRepository;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.repository.ProductItemRepository;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.service.CustomerRestClient;
import com.asystresources.erp.comptabilite.feature.analytic.billingservice.service.ProductRestClient;

@RestController
public class BillRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;


    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi ->{
            pi.setProduct(productRestClient.finProductById(pi.getProductId()));
        });
        return bill;
    }

    
}
