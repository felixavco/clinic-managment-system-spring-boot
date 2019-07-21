/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicmanagementsystem.api.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "clinics", catalog = "clinic_management_system", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"domain"}),
    @UniqueConstraint(columnNames = {"clinic_name"}),
    @UniqueConstraint(columnNames = {"clinic_url"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinic.findAll", query = "SELECT c FROM Clinic c"),
    @NamedQuery(name = "Clinic.findById", query = "SELECT c FROM Clinic c WHERE c.id = :id"),
    @NamedQuery(name = "Clinic.findByClinicName", query = "SELECT c FROM Clinic c WHERE c.clinicName = :clinicName"),
    @NamedQuery(name = "Clinic.findByDomain", query = "SELECT c FROM Clinic c WHERE c.domain = :domain"),
    @NamedQuery(name = "Clinic.findByClinicUrl", query = "SELECT c FROM Clinic c WHERE c.clinicUrl = :clinicUrl"),
    @NamedQuery(name = "Clinic.findBySpeciality", query = "SELECT c FROM Clinic c WHERE c.speciality = :speciality"),
    @NamedQuery(name = "Clinic.findByLogo", query = "SELECT c FROM Clinic c WHERE c.logo = :logo"),
    @NamedQuery(name = "Clinic.findByAddressLine", query = "SELECT c FROM Clinic c WHERE c.addressLine = :addressLine"),
    @NamedQuery(name = "Clinic.findByAddressLine2", query = "SELECT c FROM Clinic c WHERE c.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Clinic.findByState", query = "SELECT c FROM Clinic c WHERE c.state = :state"),
    @NamedQuery(name = "Clinic.findByCity", query = "SELECT c FROM Clinic c WHERE c.city = :city"),
    @NamedQuery(name = "Clinic.findByPrimaryPhone", query = "SELECT c FROM Clinic c WHERE c.primaryPhone = :primaryPhone"),
    @NamedQuery(name = "Clinic.findBySecondaryPhone", query = "SELECT c FROM Clinic c WHERE c.secondaryPhone = :secondaryPhone"),
    @NamedQuery(name = "Clinic.findByWhatsapp", query = "SELECT c FROM Clinic c WHERE c.whatsapp = :whatsapp"),
    @NamedQuery(name = "Clinic.findByEmail", query = "SELECT c FROM Clinic c WHERE c.email = :email"),
    @NamedQuery(name = "Clinic.findByFacebook", query = "SELECT c FROM Clinic c WHERE c.facebook = :facebook"),
    @NamedQuery(name = "Clinic.findByInstagram", query = "SELECT c FROM Clinic c WHERE c.instagram = :instagram"),
    @NamedQuery(name = "Clinic.findByTwitter", query = "SELECT c FROM Clinic c WHERE c.twitter = :twitter"),
    @NamedQuery(name = "Clinic.findByYoutube", query = "SELECT c FROM Clinic c WHERE c.youtube = :youtube"),
    @NamedQuery(name = "Clinic.findByLinkedin", query = "SELECT c FROM Clinic c WHERE c.linkedin = :linkedin"),
    @NamedQuery(name = "Clinic.findByIsVerified", query = "SELECT c FROM Clinic c WHERE c.isVerified = :isVerified"),
    @NamedQuery(name = "Clinic.findByIsActive", query = "SELECT c FROM Clinic c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "Clinic.findByIsTrial", query = "SELECT c FROM Clinic c WHERE c.isTrial = :isTrial"),
    @NamedQuery(name = "Clinic.findByVerificationToken", query = "SELECT c FROM Clinic c WHERE c.verificationToken = :verificationToken"),
    @NamedQuery(name = "Clinic.findByVerificationTokenExp", query = "SELECT c FROM Clinic c WHERE c.verificationTokenExp = :verificationTokenExp"),
    @NamedQuery(name = "Clinic.findByCreatedAt", query = "SELECT c FROM Clinic c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Clinic.findByUpdatedAt", query = "SELECT c FROM Clinic c WHERE c.updatedAt = :updatedAt")})
public class Clinic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "clinic_name", length = 255)
    private String clinicName;
    @Size(max = 100)
    @Column(length = 100)
    private String domain;
    @Size(max = 50)
    @Column(name = "clinic_url", length = 50)
    private String clinicUrl;
    @Size(max = 255)
    @Column(length = 255)
    private String speciality;
    @Size(max = 255)
    @Column(length = 255)
    private String logo;
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
    @Size(max = 50)
    @Column(name = "primary_phone", length = 50)
    private String primaryPhone;
    @Size(max = 50)
    @Column(name = "secondary_phone", length = 50)
    private String secondaryPhone;
    @Size(max = 50)
    @Column(length = 50)
    private String whatsapp;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(length = 255)
    private String email;
    @Size(max = 255)
    @Column(length = 255)
    private String facebook;
    @Size(max = 255)
    @Column(length = 255)
    private String instagram;
    @Size(max = 255)
    @Column(length = 255)
    private String twitter;
    @Size(max = 255)
    @Column(length = 255)
    private String youtube;
    @Size(max = 255)
    @Column(length = 255)
    private String linkedin;
    @Column(name = "is_verified")
    private Boolean isVerified;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_trial")
    private Boolean isTrial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "verification_token", nullable = false, length = 255)
    private String verificationToken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verification_token_exp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date verificationTokenExp;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic", fetch = FetchType.LAZY)
    private List<Patient> patientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic", fetch = FetchType.LAZY)
    private List<User> userList;

    //*********** Constructors **********************//
	public Clinic() {
		this.patientList = new ArrayList<Patient>();
		this.userList = new ArrayList<User>();
    }

    public Clinic(Long id) {
        this.id = id;
    }

    public Clinic(Long id, String verificationToken, Date verificationTokenExp) {
        this.id = id;
        this.verificationToken = verificationToken;
        this.verificationTokenExp = verificationTokenExp;
    }
    
    //*********** Getters and Setters **********************//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getClinicUrl() {
        return clinicUrl;
    }

    public void setClinicUrl(String clinicUrl) {
        this.clinicUrl = clinicUrl;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsTrial() {
        return isTrial;
    }

    public void setIsTrial(Boolean isTrial) {
        this.isTrial = isTrial;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public Date getVerificationTokenExp() {
        return verificationTokenExp;
    }

    public void setVerificationTokenExp(Date verificationTokenExp) {
        this.verificationTokenExp = verificationTokenExp;
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

    @XmlTransient
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
        if (!(object instanceof Clinic)) {
            return false;
        }
        Clinic other = (Clinic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clinicmanagementsystem.api.models.entities.Clinic[ id=" + id + " ]";
    }
    
}
