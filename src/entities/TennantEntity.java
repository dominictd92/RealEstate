package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Tennant", schema = "RealEstate", catalog = "")
public class TennantEntity {
    private int ssn;
    private String fName;
    private String mName;
    private String lName;
    private Timestamp birthdate;
    private String phoneNumber;
    private String car;
    private String workStatus;
    private String rentersInsurance;
    private BigDecimal rent;
    private Timestamp leaseEndDate;
    private DependentLivesWithTennantEntity dependentLivesWithTennantBySsn;

    @Id
    @Column(name = "ssn")
    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "f_name")
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "m_name")
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Basic
    @Column(name = "l_name")
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "birthdate")
    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "car")
    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Basic
    @Column(name = "workStatus")
    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    @Basic
    @Column(name = "rentersInsurance")
    public String getRentersInsurance() {
        return rentersInsurance;
    }

    public void setRentersInsurance(String rentersInsurance) {
        this.rentersInsurance = rentersInsurance;
    }

    @Basic
    @Column(name = "rent")
    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    @Basic
    @Column(name = "leaseEndDate")
    public Timestamp getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Timestamp leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TennantEntity that = (TennantEntity) o;

        if (ssn != that.ssn) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (car != null ? !car.equals(that.car) : that.car != null) return false;
        if (workStatus != null ? !workStatus.equals(that.workStatus) : that.workStatus != null) return false;
        if (rentersInsurance != null ? !rentersInsurance.equals(that.rentersInsurance) : that.rentersInsurance != null)
            return false;
        if (rent != null ? !rent.equals(that.rent) : that.rent != null) return false;
        if (leaseEndDate != null ? !leaseEndDate.equals(that.leaseEndDate) : that.leaseEndDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        result = 31 * result + (workStatus != null ? workStatus.hashCode() : 0);
        result = 31 * result + (rentersInsurance != null ? rentersInsurance.hashCode() : 0);
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        result = 31 * result + (leaseEndDate != null ? leaseEndDate.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "tennantByTennantSsn")
    public DependentLivesWithTennantEntity getDependentLivesWithTennantBySsn() {
        return dependentLivesWithTennantBySsn;
    }

    public void setDependentLivesWithTennantBySsn(DependentLivesWithTennantEntity dependentLivesWithTennantBySsn) {
        this.dependentLivesWithTennantBySsn = dependentLivesWithTennantBySsn;
    }
}
