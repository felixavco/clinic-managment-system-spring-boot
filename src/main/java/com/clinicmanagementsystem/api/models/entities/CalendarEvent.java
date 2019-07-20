/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicmanagementsystem.api.models.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "calendar_events", catalog = "clinic_management_system", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarEvent.findAll", query = "SELECT c FROM CalendarEvent c"),
    @NamedQuery(name = "CalendarEvent.findById", query = "SELECT c FROM CalendarEvent c WHERE c.id = :id"),
    @NamedQuery(name = "CalendarEvent.findByStartTime", query = "SELECT c FROM CalendarEvent c WHERE c.startTime = :startTime"),
    @NamedQuery(name = "CalendarEvent.findByEndTime", query = "SELECT c FROM CalendarEvent c WHERE c.endTime = :endTime"),
    @NamedQuery(name = "CalendarEvent.findByTitle", query = "SELECT c FROM CalendarEvent c WHERE c.title = :title"),
    @NamedQuery(name = "CalendarEvent.findByCreatedAt", query = "SELECT c FROM CalendarEvent c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CalendarEvent.findByUpdatedAt", query = "SELECT c FROM CalendarEvent c WHERE c.updatedAt = :updatedAt")})
public class CalendarEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 255)
    @Column(length = 255)
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "patient", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    @JoinColumn(name = "event_owner", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User eventOwner;

    public CalendarEvent() {
    }

    public CalendarEvent(Long id) {
        this.id = id;
    }

    public CalendarEvent(Long id, Date startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(User eventOwner) {
        this.eventOwner = eventOwner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarEvent)) {
            return false;
        }
        CalendarEvent other = (CalendarEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicmanagementsystem.api.models.entities.CalendarEvent[ id=" + id + " ]";
    }
    
}
