package com.mk.customer.dto;

import com.mk.customer.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto extends BaseDto {
    @NotNull
    private String name;
    @NotNull
    private String active;
    private CustomerDto customerConvertedInto;
}
