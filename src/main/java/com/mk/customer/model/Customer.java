package com.mk.customer.model;

import com.mk.customer.messaging.BaseEntityMessage;
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
public class Customer extends BaseEntity implements BaseEntityMessage {

    private String name;

    private Boolean active = Boolean.TRUE;

    @OneToOne(mappedBy = "customerConvertedInto")
    private Lead convertedFromLead;

    @Override
    public String getTopicName() {
        return "customer_customers";
    }

    @Override
    public String getVersion() {
        return "V1";
    }
}
