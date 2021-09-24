package com.mk.customer.controller;

import com.mk.customer.dto.IdDto;
import com.mk.customer.dto.LeadDto;
import com.mk.customer.dto.mapper.LeadMapper;
import com.mk.customer.model.Lead;
import com.mk.customer.model.base.BaseEntity;
import com.mk.customer.service.LeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("leads")
public class LeadController {

    private final LeadService service;

    @Autowired
    public LeadController(final LeadService service) {
        this.service = service;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<IdDto> insert(@RequestBody final LeadDto dto) {
        final Lead entity = LeadMapper.INSTANCE.toEntity(dto);
        final Lead insertedEntity = this.service.insert(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new IdDto(insertedEntity.getId()));
    }

    @PostMapping(
            path = "{entityId}/convert-to-customer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LeadDto> convertToCustomer(@PathVariable("entityId") final UUID entityId) {
        final Lead entity = this.service.convertLead(entityId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LeadMapper.INSTANCE.toDto(entity));
    }
}
