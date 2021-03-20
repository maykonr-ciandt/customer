package com.mk.customer.service;

import com.mk.customer.exception.RegisterNotFoundException;
import com.mk.customer.model.Customer;
import com.mk.customer.model.Lead;
import com.mk.customer.repository.LeadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class LeadService {

    private final LeadRepository repository;

    @Autowired
    public LeadService(final LeadRepository repository) {
        this.repository = repository;
    }

    public Lead insert(final Lead entity) {
        return this.repository.save(entity);
    }

    public Lead convertLead(final UUID leadId) {
        log.info("Converting lead {}.... Creating a new customer", leadId);
        return this.repository.findById(leadId)
                .map(Lead::doRunCustomerConversion)
                .map(this.repository::save)
                .orElseThrow(() -> new RegisterNotFoundException(Lead.class.getSimpleName(), leadId.toString()));
    }
}
