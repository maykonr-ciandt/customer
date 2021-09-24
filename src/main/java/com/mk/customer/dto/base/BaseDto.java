package com.mk.customer.dto.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class BaseDto implements Serializable {
    private UUID id;
}
