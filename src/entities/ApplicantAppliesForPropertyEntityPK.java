package RealEstate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ApplicantAppliesForPropertyEntityPK implements Serializable {
    private int applicantSsn;
    private int propertyPropertyId;

    @Column(name = "Applicant_ssn", nullable = false)
    @Id
    public int getApplicantSsn() {
        return applicantSsn;
    }

    public void setApplicantSsn(int applicantSsn) {
        this.applicantSsn = applicantSsn;
    }

    @Column(name = "Property_propertyID", nullable = false)
    @Id
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicantAppliesForPropertyEntityPK that = (ApplicantAppliesForPropertyEntityPK) o;

        if (applicantSsn != that.applicantSsn) return false;
        if (propertyPropertyId != that.propertyPropertyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicantSsn;
        result = 31 * result + propertyPropertyId;
        return result;
    }
}
