package com.mk.customer.dto.mapper;


import com.mk.customer.dto.CustomerDto;
import com.mk.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(final CustomerDto dto);

    CustomerDto toDto(final Customer entity);
}
