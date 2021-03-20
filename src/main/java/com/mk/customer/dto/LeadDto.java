package com.mk.customer.dto;

import com.mk.customer.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LeadDto extends BaseDto {
    @NotNull
    private String name;
    @NotNull
    private Boolean active;
    private Boolean converted;
    private OffsetDateTime convertedIn;
    private CustomerDto customerConvertedInto;
}
