package entities;

import javax.persistence.*;

@Entity
@Table(name = "Applicant_Applies_For_Property", schema = "RealEstate", catalog = "")
@IdClass(ApplicantAppliesForPropertyEntityPK.class)
public class ApplicantAppliesForPropertyEntity {
    private int applicantSsn;
    private int propertyPropertyId;
    private int propertyTennantSsn;
    private String applicationStatus;
    private ApplicantEntity applicantByApplicantSsn;

    @Id
    @Column(name = "Applicant_ssn")
    public int getApplicantSsn() {
        return applicantSsn;
    }

    public void setApplicantSsn(int applicantSsn) {
        this.applicantSsn = applicantSsn;
    }

    @Id
    @Column(name = "Property_propertyID")
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Id
    @Column(name = "Property_Tennant_ssn")
    public int getPropertyTennantSsn() {
        return propertyTennantSsn;
    }

    public void setPropertyTennantSsn(int propertyTennantSsn) {
        this.propertyTennantSsn = propertyTennantSsn;
    }

    @Basic
    @Column(name = "applicationStatus")
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
        if (propertyTennantSsn != that.propertyTennantSsn) return false;
        if (applicationStatus != null ? !applicationStatus.equals(that.applicationStatus) : that.applicationStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicantSsn;
        result = 31 * result + propertyPropertyId;
        result = 31 * result + propertyTennantSsn;
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
}
