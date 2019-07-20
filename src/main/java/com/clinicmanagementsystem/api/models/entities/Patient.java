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
@Table(name = "patients", catalog = "clinic_management_system", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findById", query = "SELECT p FROM Patient p WHERE p.id = :id"),
    @NamedQuery(name = "Patient.findByFirstName", query = "SELECT p FROM Patient p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Patient.findByMiddleName", query = "SELECT p FROM Patient p WHERE p.middleName = :middleName"),
    @NamedQuery(name = "Patient.findByLastName", query = "SELECT p FROM Patient p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Patient.findByLastName2", query = "SELECT p FROM Patient p WHERE p.lastName2 = :lastName2"),
    @NamedQuery(name = "Patient.findByEmail", query = "SELECT p FROM Patient p WHERE p.email = :email"),
    @NamedQuery(name = "Patient.findByPrimaryPhone", query = "SELECT p FROM Patient p WHERE p.primaryPhone = :primaryPhone"),
    @NamedQuery(name = "Patient.findBySecondaryPhone", query = "SELECT p FROM Patient p WHERE p.secondaryPhone = :secondaryPhone"),
    @NamedQuery(name = "Patient.findByDob", query = "SELECT p FROM Patient p WHERE p.dob = :dob"),
    @NamedQuery(name = "Patient.findByBloodType", query = "SELECT p FROM Patient p WHERE p.bloodType = :bloodType"),
    @NamedQuery(name = "Patient.findByInsuranceNumber", query = "SELECT p FROM Patient p WHERE p.insuranceNumber = :insuranceNumber"),
    @NamedQuery(name = "Patient.findByInsuranceProvider", query = "SELECT p FROM Patient p WHERE p.insuranceProvider = :insuranceProvider"),
    @NamedQuery(name = "Patient.findByAddressLine", query = "SELECT p FROM Patient p WHERE p.addressLine = :addressLine"),
    @NamedQuery(name = "Patient.findByAddressLine2", query = "SELECT p FROM Patient p WHERE p.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Patient.findByState", query = "SELECT p FROM Patient p WHERE p.state = :state"),
    @NamedQuery(name = "Patient.findByCity", query = "SELECT p FROM Patient p WHERE p.city = :city"),
    @NamedQuery(name = "Patient.findByCreatedAt", query = "SELECT p FROM Patient p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Patient.findByUpdatedAt", query = "SELECT p FROM Patient p WHERE p.updatedAt = :updatedAt")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Size(max = 50)
    @Column(name = "middle_name", length = 50)
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Size(max = 50)
    @Column(name = "last_name2", length = 50)
    private String lastName2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(length = 255)
    private String email;
    @Size(max = 20)
    @Column(name = "primary_phone", length = 20)
    private String primaryPhone;
    @Size(max = 20)
    @Column(name = "secondary_phone", length = 20)
    private String secondaryPhone;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 10)
    @Column(name = "blood_type", length = 10)
    private String bloodType;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String alergies;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String notes;
    @Size(max = 255)
    @Column(name = "insurance_number", length = 255)
    private String insuranceNumber;
    @Size(max = 255)
    @Column(name = "insurance_provider", length = 255)
    private String insuranceProvider;
    @Size(max = 255)
    @Column(name = "address_line", length = 255)
    private String addressLine;
    @Size(max = 255)
    @Column(name = "address_line2", length = 255)
    private String addressLine2;
    @Size(max = 100)
    @Column(length = 100)
    private String state;
    @Size(max = 100)
    @Column(length = 100)
    private String city;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "clinic", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinic clinic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient", fetch = FetchType.LAZY)
    private List<MedicalVisit> medicalVisitList;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<CalendarEvent> calendarEventList;

    public Patient() {
    }

    public Patient(Long id) {
        this.id = id;
    }

    public Patient(Long id, String firstName, String lastName, Date dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @XmlTransient
    public List<MedicalVisit> getMedicalVisitList() {
        return medicalVisitList;
    }

    public void setMedicalVisitList(List<MedicalVisit> medicalVisitList) {
        this.medicalVisitList = medicalVisitList;
    }

    @XmlTransient
    public List<CalendarEvent> getCalendarEventList() {
        return calendarEventList;
    }

    public void setCalendarEventList(List<CalendarEvent> calendarEventList) {
        this.calendarEventList = calendarEventList;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicmanagementsystem.api.models.entities.Patient[ id=" + id + " ]";
    }
    
}
