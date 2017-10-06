/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.entities;

import java.time.Period;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.txbiomed.converters.PeriodStringConverter;


/**
 *
 * @author lkacimi
 */
@Entity(name = "DateEvent")
public class DateEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "`timestamp`")
    @Temporal(TemporalType.DATE)
    private Date timestamp;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @Convert(converter=PeriodStringConverter.class)
    private Period span;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Period getSpan() {
        return span;
    }

    public void setSpan(Period span) {
        this.span = span;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
    
    
    
    
    
    
}
