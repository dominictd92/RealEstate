package RealEstate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Seller", schema = "RealEstate", catalog = "")
public class SellerEntity {
    private int ssn;
    private Integer zipCode;
    private String streetAddress;
    private String city;
    private String state;
    private String phoneNumber;
    private String fName;
    private String mName;
    private String lName;
    private Collection<SellerSellsPropertyEntity> sellerSellsPropertiesBySsn;

    @Id
    @Column(name = "ssn", nullable = false)
    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "zipCode", nullable = true)
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "streetAddress", nullable = true, length = 45)
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "State", nullable = true, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    @OneToMany(mappedBy = "sellerBySellerSsn")
    public Collection<SellerSellsPropertyEntity> getSellerSellsPropertiesBySsn() {
        return sellerSellsPropertiesBySsn;
    }

    public void setSellerSellsPropertiesBySsn(Collection<SellerSellsPropertyEntity> sellerSellsPropertiesBySsn) {
        this.sellerSellsPropertiesBySsn = sellerSellsPropertiesBySsn;
    }
}
