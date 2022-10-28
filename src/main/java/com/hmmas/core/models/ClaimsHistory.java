package com.hmmas.core.models;

import com.hmmas.core.utils.Status;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "claimshistory")
public class ClaimsHistory extends BaseEntity {

    @Column(name = "membershipno", nullable = false)
    private Long membershipno;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "ahfox", nullable = false)
    private int ahfox;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "claimid", nullable = false)
    private Long claimid;

    @Column(name = "schemeid", nullable = false)
    private int schemeid;

    @Column(name = "treatmentdate", nullable = false)
    private Date treatmentdate;

    @Column(name = "amountclaimed", nullable = false)
    private double amountclaimed;

    @Column(name = "awarded", nullable = false)
    private double awarded;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

}
