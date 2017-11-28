package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SellerSellsPropertyEntityPK implements Serializable {
    private int sellerSsn;
    private int propertyPropertyId;
    private int propertyTennantSsn;

    @Column(name = "Seller_ssn")
    @Id
    public int getSellerSsn() {
        return sellerSsn;
    }

    public void setSellerSsn(int sellerSsn) {
        this.sellerSsn = sellerSsn;
    }

    @Column(name = "Property_propertyID")
    @Id
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Column(name = "Property_Tennant_ssn")
    @Id
    public int getPropertyTennantSsn() {
        return propertyTennantSsn;
    }

    public void setPropertyTennantSsn(int propertyTennantSsn) {
        this.propertyTennantSsn = propertyTennantSsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerSellsPropertyEntityPK that = (SellerSellsPropertyEntityPK) o;

        if (sellerSsn != that.sellerSsn) return false;
        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (propertyTennantSsn != that.propertyTennantSsn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sellerSsn;
        result = 31 * result + propertyPropertyId;
        result = 31 * result + propertyTennantSsn;
        return result;
    }
}
