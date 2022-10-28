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
@Table(name = "member")
public class Member extends BaseEntity {

    @Column(name = "membershipno", nullable = false)
    private Long membershipno;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "suffix", nullable = false)
    private int suffix;

    @Column(name = "membertype", nullable = false)
    private String membertype;

    @Column(name = "dateofbirth", nullable = false)
    private Date dateofbirth;

    @Column(name = "nationalid", nullable = false)
    private String nationalid;

    @Column(name = "schemeid", nullable = false)
    private int schemeid;

    @Column(name = "schemename", nullable = false)
    private String schemename;

    @Basic(optional = false)
    @Column(name = "subscriptiontype", nullable = false)
    private SubscriptionType subscriptiontype;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

}
