package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Applicant", schema = "RealEstate", catalog = "")
public class ApplicantEntity {
    private Integer ssn;
    private String lName;
    private String mName;
    private String creditScore;
    private String address;
    private String moveDate;
    private String phoneNumber;
    private String employer;
    private String jobTitle;
    private String salary;
    private String fName;
    private Collection<ApplicantAppliesForPropertyEntity> applicantAppliesForPropertiesBySsn;

    private String applicationStatus;
    private Integer propertyID;

    public ApplicantEntity() {
        //empty constructor
    }
    
    public ApplicantEntity(Integer ssn, String fName, String mName, String lName, String address, String phone, 
            String creditScore, String moveDate, String employer, String jobTitle, String salary) {
        this.ssn = ssn;
        this.fName = fName; 
        this.mName = mName; 
        this.lName = lName;
        this.address = address; 
        this.phoneNumber = phone;
        this.creditScore = creditScore; 
        this.moveDate = moveDate; 
        this.employer = employer; 
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
    
    @Id
    @Column(name = "ssn", nullable = false)
    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "l_name", nullable = true, length = 45)
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "m_name", nullable = true, length = 45)
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Basic
    @Column(name = "creditScore", nullable = true, length = 45)
    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "moveDate", nullable = true, length = 45)
    public String getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(String moveDate) {
        this.moveDate = moveDate;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "employer", nullable = true, length = 45)
    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    @Basic
    @Column(name = "jobTitle", nullable = true, length = 45)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "salary", nullable = true, length = 45)
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "f_name", nullable = true, length = 45)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
    @Transient
    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    
    @Transient
    public Integer getPropertyID() {
        return propertyID;
    }

    
    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicantEntity that = (ApplicantEntity) o;

        if (ssn != that.ssn) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (creditScore != null ? !creditScore.equals(that.creditScore) : that.creditScore != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (moveDate != null ? !moveDate.equals(that.moveDate) : that.moveDate != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (employer != null ? !employer.equals(that.employer) : that.employer != null) return false;
        if (jobTitle != null ? !jobTitle.equals(that.jobTitle) : that.jobTitle != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (creditScore != null ? creditScore.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (moveDate != null ? moveDate.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (employer != null ? employer.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "applicantByApplicantSsn")
    public Collection<ApplicantAppliesForPropertyEntity> getApplicantAppliesForPropertiesBySsn() {
        return applicantAppliesForPropertiesBySsn;
    }

    public void setApplicantAppliesForPropertiesBySsn(Collection<ApplicantAppliesForPropertyEntity> applicantAppliesForPropertiesBySsn) {
        this.applicantAppliesForPropertiesBySsn = applicantAppliesForPropertiesBySsn;
    }
    
       public Object[] getColumnArray() {
        String[] columns = new String[] {
            "SSN", "First Name", "Middle Name", "Last Name", "Address", "Phone Number",
            "Move Date", "Credit Score", "Employer", "Job Title", "Salary", "Application Status", 
            "PropertyID"
        };
        return columns; 
    }
    
    public Object[] getApplicantArray() { 
        Object[] rows = new Object[] {
            this.ssn, this.fName, this.mName, this.lName,
            this.address, this.phoneNumber, this.moveDate, this.creditScore,
            this.employer, this.jobTitle, this.salary, this.applicationStatus, 
            this.propertyID
        };
        return rows;
    }
}
