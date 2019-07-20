/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicmanagementsystem.api.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "medical_visits", catalog = "clinic_management_system", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicalVisit.findAll", query = "SELECT m FROM MedicalVisit m"),
    @NamedQuery(name = "MedicalVisit.findById", query = "SELECT m FROM MedicalVisit m WHERE m.id = :id"),
    @NamedQuery(name = "MedicalVisit.findByTemperature", query = "SELECT m FROM MedicalVisit m WHERE m.temperature = :temperature"),
    @NamedQuery(name = "MedicalVisit.findByBloodPresure", query = "SELECT m FROM MedicalVisit m WHERE m.bloodPresure = :bloodPresure"),
    @NamedQuery(name = "MedicalVisit.findByHeight", query = "SELECT m FROM MedicalVisit m WHERE m.height = :height"),
    @NamedQuery(name = "MedicalVisit.findByWeight", query = "SELECT m FROM MedicalVisit m WHERE m.weight = :weight"),
    @NamedQuery(name = "MedicalVisit.findByDiagnose", query = "SELECT m FROM MedicalVisit m WHERE m.diagnose = :diagnose"),
    @NamedQuery(name = "MedicalVisit.findByPatientRecord", query = "SELECT m FROM MedicalVisit m WHERE m.patientRecord = :patientRecord"),
    @NamedQuery(name = "MedicalVisit.findByCreatedAt", query = "SELECT m FROM MedicalVisit m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MedicalVisit.findByUpdatedAt", query = "SELECT m FROM MedicalVisit m WHERE m.updatedAt = :updatedAt")})
public class MedicalVisit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float temperature;
    @Size(max = 10)
    @Column(name = "blood_presure", length = 10)
    private String bloodPresure;
    @Column(precision = 12)
    private Float height;
    @Column(precision = 12)
    private Float weight;
    @Size(max = 255)
    @Column(length = 255)
    private String diagnose;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String notes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_record", nullable = false)
    private long patientRecord;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "patient", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Patient patient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalVisit", fetch = FetchType.LAZY)
    private List<Prescription> prescriptionList;

    public MedicalVisit() {
    }

    public MedicalVisit(Long id) {
        this.id = id;
    }

    public MedicalVisit(Long id, long patientRecord) {
        this.id = id;
        this.patientRecord = patientRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public String getBloodPresure() {
        return bloodPresure;
    }

    public void setBloodPresure(String bloodPresure) {
        this.bloodPresure = bloodPresure;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getPatientRecord() {
        return patientRecord;
    }

    public void setPatientRecord(long patientRecord) {
        this.patientRecord = patientRecord;
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

    @XmlTransient
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
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
        if (!(object instanceof MedicalVisit)) {
            return false;
        }
        MedicalVisit other = (MedicalVisit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicmanagementsystem.api.models.entities.MedicalVisit[ id=" + id + " ]";
    }
    
}
