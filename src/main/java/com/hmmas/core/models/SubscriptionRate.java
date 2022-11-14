package com.hmmas.core.models;

import com.hmmas.core.utils.Status;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "subscriptionrate")
public class SubscriptionRate extends BaseEntity {

    @Column(name = "schemename", nullable = false)
    private String schemename;

    @Column(name = "principal", nullable = false)
    private int principal;

    @Column(name = "spouse", nullable = false)
    private int spouse;

    @Column(name = "adultdependent", nullable = false)
    private int adultdependent;

    @Column(name = "childlesseighteen", nullable = false)
    private int childlesseighteen;

    @Column(name = "exchangerate", nullable = false)
    private int exchangerate;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

}
