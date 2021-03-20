package com.mk.customer.model;

import com.mk.customer.messaging.BaseEntityMessage;
import com.mk.customer.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lead extends BaseEntity implements BaseEntityMessage {

    private String name;

    private Boolean active = Boolean.TRUE;

    private Boolean converted;

    private OffsetDateTime convertedIn;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customerConvertedInto;

    @PrePersist
    private void prePersist() {
        super.preUpdate();
        this.setConverted(Boolean.FALSE);
    }

    public Lead doRunCustomerConversion() {
        final Customer customer = new Customer();
        customer.setName(this.name);
        customer.setActive(Boolean.TRUE);
        this.setConvertedIn(OffsetDateTime.now());
        this.setCustomerConvertedInto(customer);
        this.setConverted(Boolean.TRUE);
        this.setActive(Boolean.FALSE);
        return this;
    }

    @Override
    public String getTopicName() {
        return "customer_leads";
    }

    @Override
    public String getVersion() {
        return "V1";
    }
}
