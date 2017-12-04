package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SellerSellsPropertyEntityPK implements Serializable {
    private int sellerSsn;
    private int propertyPropertyId;

    @Column(name = "Seller_ssn", nullable = false)
    @Id
    public int getSellerSsn() {
        return sellerSsn;
    }

    public void setSellerSsn(int sellerSsn) {
        this.sellerSsn = sellerSsn;
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

        SellerSellsPropertyEntityPK that = (SellerSellsPropertyEntityPK) o;

        if (sellerSsn != that.sellerSsn) return false;
        if (propertyPropertyId != that.propertyPropertyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sellerSsn;
        result = 31 * result + propertyPropertyId;
        return result;
    }
}
