package entities;

import javax.persistence.*;

@Entity
@Table(name = "Applicant", schema = "RealEstate", catalog = "")
public class ApplicantEntity {
    @Id
    @Column(name = "ssn")
    private int ssn;
    @Basic
    @Column(name = "l_name")
    private String lName;
    @Basic
    @Column(name = "m_name")
    private String mName;
    @Basic
    @Column(name = "creditScore")
    private String creditScore;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "moveDate")
    private String moveDate;
    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic
    @Column(name = "employer")
    private String employer;
    @Basic
    @Column(name = "jobTitle")
    private String jobTitle;
    @Basic
    @Column(name = "salary")
    private String salary;
    @Basic
    @Column(name = "f_name")
    private String fName;
    
    @Transient
    private String applicationStatus;
    
    @Transient
    private Integer propertyId;

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(String moveDate) {
        this.moveDate = moveDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
    public String getApplicationStatus() { 
        return applicationStatus;
    }
            
    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    
    public Integer getPropertyId() { 
        return propertyId;
    }
    
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }
    
    public ApplicantEntity() { 
        //null
    }
    
    public ApplicantEntity(Integer ssn, String fName, String mName, String lName, String address, String phoneNumber,
            String creditScore, String moveDate, String employer, String job, String salary) { 
        this.ssn = ssn;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creditScore = creditScore;
        this.moveDate = moveDate;
        this.employer = employer; 
        this.jobTitle = job;
        this.salary = salary;
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
    
    public Object[] getColumnArray() {
        String[] columns = new String[] {
            "SSN", "First Name", "Middle Name", "Last Name", "Address", "Phone Number",
            "Move Date", "Credit Score", "Employer", "Job Title", "Salary", "Application Status", "PropertyID"
        };
        return columns; 
    }
    
    public Object[] getApplicantArray() { 
        Object[] rows = new Object[] {
            this.ssn, this.fName, this.mName, this.lName,
            this.address, this.phoneNumber, this.moveDate, this.creditScore,
            this.employer, this.jobTitle, this.salary, this.applicationStatus, this.propertyId
        };
        return rows;
    }
}
