package com.mk.customer.model;

import com.mk.customer.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

    private String name;

    private Boolean active = Boolean.TRUE;

    @OneToOne(mappedBy = "customerConvertedInto")
    private Lead convertedFromLead;
}
