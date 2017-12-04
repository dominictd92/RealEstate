package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Employee", schema = "RealEstate", catalog = "")
public class EmployeeEntity {
    @Id
    @Column(name = "ssn")
    private int ssn;
    @Basic
    @Column(name = "f_name")
    private String fName;
    @Basic
    @Column(name = "m_name")
    private String mName;
    @Basic
    @Column(name = "l_name")
    private String lName;
    @Basic
    @Column(name = "pay")
    private BigDecimal pay;
    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @Transient
    private int propertyId;

    public EmployeeEntity() { 
        //null constructor
    }
    
    public EmployeeEntity(Integer ssn, String fName, String mName, String lName, BigDecimal pay, String phoneNumber) {
        this.ssn = ssn; 
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.pay = pay;
        this.phoneNumber = phoneNumber;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getPropertyId() {
        return propertyId;
    }
    
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
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
    
    public Object[] getColumnArray() {
        String[] columns = new String[] {
            "SSN", "First Name", "Middle Name", "Last Name", "Pay", "Phone Number", "PropertyID"
        };
        return columns; 
    }
    
    public Object[] getEmployeeArray() { 
        Object[] rows = new Object[] {
            this.ssn, this.fName, this.mName, this.lName, this.pay, this.phoneNumber, this.propertyId
        };
        return rows;
    }
}
