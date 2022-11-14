package com.hmmas.core.models;

import com.hmmas.core.utils.Status;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "member_schemes")
public class MemberScheme extends BaseEntity {

    @Column(name = "schemename", nullable = false)
    private String schemename;

    @Column(name = "startdate", nullable = false)
    private Date startdate;

    @Column(name = "enddate")
    private Date enddate;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

}
