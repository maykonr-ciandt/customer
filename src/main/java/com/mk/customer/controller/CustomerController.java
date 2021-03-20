package com.mk.customer.controller;

import com.mk.customer.dto.CustomerDto;
import com.mk.customer.dto.mapper.CustomerMapper;
import com.mk.customer.model.Customer;
import com.mk.customer.model.base.BaseEntity;
import com.mk.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(final CustomerService service) {
        this.service = service;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseEntity> insert(@RequestBody final CustomerDto dto) {
        final Customer entity = CustomerMapper.INSTANCE.toEntity(dto);
        final Customer insertedEntity = this.service.insert(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new BaseEntity(insertedEntity.getId()));
    }
}
