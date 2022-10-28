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
@Table(name = "provider")
public class Provider extends BaseEntity {

    @Column(name = "ahfoz", nullable = false)
    private Long ahfoz;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

    @Column(name = "speciality")
    private String speciality;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

}
