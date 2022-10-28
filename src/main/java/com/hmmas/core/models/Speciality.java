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
@Table(name = "speciality")
public class Speciality extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

}
