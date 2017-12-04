package RealEstate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "Employee", schema = "RealEstate", catalog = "")
public class EmployeeEntity {
    private int ssn;
    private String fName;
    private String mName;
    private String lName;
    private BigDecimal pay;
    private String phoneNumber;
    private Collection<EmployeeWorksAtPropertyEntity> employeeWorksAtPropertiesBySsn;

    @Id
    @Column(name = "ssn", nullable = false)
    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "f_name", nullable = true, length = 45)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
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
    @Column(name = "l_name", nullable = true, length = 45)
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "pay", nullable = true, precision = 2)
    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (ssn != that.ssn) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;
        if (pay != null ? !pay.equals(that.pay) : that.pay != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (pay != null ? pay.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeByEmployeeSsn")
    public Collection<EmployeeWorksAtPropertyEntity> getEmployeeWorksAtPropertiesBySsn() {
        return employeeWorksAtPropertiesBySsn;
    }

    public void setEmployeeWorksAtPropertiesBySsn(Collection<EmployeeWorksAtPropertyEntity> employeeWorksAtPropertiesBySsn) {
        this.employeeWorksAtPropertiesBySsn = employeeWorksAtPropertiesBySsn;
    }
}
