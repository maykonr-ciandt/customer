package com.mk.customer.dto.mapper;

import com.mk.customer.dto.CustomerDto;
import com.mk.customer.dto.LeadDto;
import com.mk.customer.model.Customer;
import com.mk.customer.model.Lead;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-20T18:23:29-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.3.jar, environment: Java 1.8.0_282 (Private Build)"
)
@Component
public class LeadMapperImpl implements LeadMapper {

    @Override
    public Lead toEntity(LeadDto dto) {
        if ( dto == null ) {
            return null;
        }

        Lead lead = new Lead();

        lead.setId( dto.getId() );
        lead.setName( dto.getName() );
        lead.setActive( dto.getActive() );
        lead.setConverted( dto.getConverted() );
        lead.setConvertedIn( dto.getConvertedIn() );
        lead.setCustomerConvertedInto( customerDtoToCustomer( dto.getCustomerConvertedInto() ) );

        return lead;
    }

    @Override
    public LeadDto toDto(Lead entity) {
        if ( entity == null ) {
            return null;
        }

        LeadDto leadDto = new LeadDto();

        leadDto.setId( entity.getId() );
        leadDto.setName( entity.getName() );
        leadDto.setActive( entity.getActive() );
        leadDto.setConverted( entity.getConverted() );
        leadDto.setConvertedIn( entity.getConvertedIn() );
        leadDto.setCustomerConvertedInto( customerToCustomerDto( entity.getCustomerConvertedInto() ) );

        return leadDto;
    }

    protected Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setName( customerDto.getName() );
        if ( customerDto.getActive() != null ) {
            customer.setActive( Boolean.parseBoolean( customerDto.getActive() ) );
        }

        return customer;
    }

    protected CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setName( customer.getName() );
        if ( customer.getActive() != null ) {
            customerDto.setActive( String.valueOf( customer.getActive() ) );
        }

        return customerDto;
    }
}
