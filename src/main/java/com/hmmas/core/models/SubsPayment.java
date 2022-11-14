package com.hmmas.core.models;

import com.hmmas.core.utils.Status;
import com.hmmas.core.utils.SubscriptionType;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "subspayment")
public class SubsPayment extends BaseEntity {

    @Column(name = "membershipno", nullable = false)
    private Long membershipno;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "schemename", nullable = false)
    private String schemename;

    @Column(name = "paymentdate", nullable = false)
    private Date paymentdate;

    @Column(name = "amountpaid", nullable = false)
    private double amountpaid;


    @Column(name = "schemetarrif", nullable = false)
    private double schemetarrif;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }
}
