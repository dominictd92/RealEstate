package entities;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "Seller", schema = "RealEstate", catalog = "")
public class SellerEntity {
    @Id
    @Column(name = "ssn")
    private int ssn;
    @Basic
    @Column(name = "zipCode")
    private Integer zipCode;
    @Basic
    @Column(name = "streetAddress")
    private String streetAddress;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "State")
    private String state;
    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic
    @Column(name = "f_name")
    private String fName;
    @Basic
    @Column(name = "m_name")
    private String mName;
    @Basic
    @Column(name = "l_name")
    private String lName;
    
    @Transient
    private BigDecimal price; 

    @Transient 
    private Integer propertyID;

    public SellerEntity(Integer ssn, Integer zipCode, String streetAddress, String city, String state, String phoneNumber, String fName, String mName, String lName) {
        this.ssn = ssn;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }

    public SellerEntity() {
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

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

        SellerEntity that = (SellerEntity) o;

        if (ssn != that.ssn) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (streetAddress != null ? !streetAddress.equals(that.streetAddress) : that.streetAddress != null)
            return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn;
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        return result;
    }
    
    public Object[] getColumnArray() {
        String[] columns = new String[] {
            "SSN", "First Name", "Middle Name", "Last Name", "Address", "Zip Code",
            "City", "State", "Phone Number", "PropertyID", "Price"
        };
        return columns; 
    }
    
    public Object[] getSellerArray() { 
        Object[] rows = new Object[] {
            this.ssn, this.fName, this.mName, this.lName, this.streetAddress, this.zipCode,
             this.city, this.state, this.phoneNumber, this.propertyID, this.price
        };
        return rows;
    }
}
