package com.mk.customer.dto.mapper;

import com.mk.customer.dto.CustomerDto;
import com.mk.customer.model.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-20T18:23:29-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.3.jar, environment: Java 1.8.0_282 (Private Build)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setName( dto.getName() );
        if ( dto.getActive() != null ) {
            customer.setActive( Boolean.parseBoolean( dto.getActive() ) );
        }

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( entity.getId() );
        customerDto.setName( entity.getName() );
        if ( entity.getActive() != null ) {
            customerDto.setActive( String.valueOf( entity.getActive() ) );
        }

        return customerDto;
    }
}
