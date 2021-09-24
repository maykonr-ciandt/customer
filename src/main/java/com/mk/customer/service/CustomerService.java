package com.mk.customer.service;

import com.mk.customer.model.Customer;
import com.mk.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(final CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer insert(final Customer entity) {
        return this.repository.save(entity);
    }
}
