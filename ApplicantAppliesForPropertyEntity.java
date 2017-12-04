package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Applicant_Applies_For_Property", schema = "RealEstate", catalog = "")
@IdClass(ApplicantAppliesForPropertyEntityPK.class)
public class ApplicantAppliesForPropertyEntity {
    private int applicantSsn;
    private int propertyPropertyId;
    private String applicationStatus;
    private ApplicantEntity applicantByApplicantSsn;
    private Collection<PropertyEntity> applicantByAppliacntId;

    public ApplicantAppliesForPropertyEntity(int applicantSsn, int propertyPropertyId, String applicationStatus, ApplicantEntity applicantByApplicantSsn, Collection<PropertyEntity> applicantByAppliacntId) {
        this.applicantSsn = applicantSsn;
        this.propertyPropertyId = propertyPropertyId;
        this.applicationStatus = applicationStatus;
        this.applicantByApplicantSsn = applicantByApplicantSsn;
        this.applicantByAppliacntId = applicantByAppliacntId;
    }

    public ApplicantAppliesForPropertyEntity(int applicantSsn, int propertyPropertyId, String applicationStatus) {
        this.applicantSsn = applicantSsn;
        this.propertyPropertyId = propertyPropertyId;
        this.applicationStatus = applicationStatus;
    }

    public ApplicantAppliesForPropertyEntity(int applicantSsn, int propertyPropertyId) {

        this.applicantSsn = applicantSsn;
        this.propertyPropertyId = propertyPropertyId;
    }

    @Id
    @Column(name = "Applicant_ssn", nullable = false)
    public int getApplicantSsn() {
        return applicantSsn;
    }

    public void setApplicantSsn(int applicantSsn) {
        this.applicantSsn = applicantSsn;
    }

    @Id
    @Column(name = "Property_propertyID", nullable = false)
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Basic
    @Column(name = "applicationStatus", nullable = true, length = 45)
    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicantAppliesForPropertyEntity that = (ApplicantAppliesForPropertyEntity) o;

        if (applicantSsn != that.applicantSsn) return false;
        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (applicationStatus != null ? !applicationStatus.equals(that.applicationStatus) : that.applicationStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicantSsn;
        result = 31 * result + propertyPropertyId;
        result = 31 * result + (applicationStatus != null ? applicationStatus.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Applicant_ssn", referencedColumnName = "ssn", nullable = false)
    public ApplicantEntity getApplicantByApplicantSsn() {
        return applicantByApplicantSsn;
    }

    public void setApplicantByApplicantSsn(ApplicantEntity applicantByApplicantSsn) {
        this.applicantByApplicantSsn = applicantByApplicantSsn;
    }

    @OneToMany(mappedBy = "applicantAppliesForPropertyByPropertyId")
    public Collection<PropertyEntity> getApplicantByAppliacntId() {
        return applicantByAppliacntId;
    }

    public void setApplicantByAppliacntId(Collection<PropertyEntity> applicantByAppliacntId) {
        this.applicantByAppliacntId = applicantByAppliacntId;
    }
}
