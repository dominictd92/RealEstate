package RealEstate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Seller_Sells_Property", schema = "RealEstate", catalog = "")
@IdClass(SellerSellsPropertyEntityPK.class)
public class SellerSellsPropertyEntity {
    private int sellerSsn;
    private int propertyPropertyId;
    private BigDecimal price;
    private SellerEntity sellerBySellerSsn;

    @Id
    @Column(name = "Seller_ssn", nullable = false)
    public int getSellerSsn() {
        return sellerSsn;
    }

    public void setSellerSsn(int sellerSsn) {
        this.sellerSsn = sellerSsn;
    }

    @Id
    @Column(name = "Property_propertyID", nullable = false)
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerSellsPropertyEntity that = (SellerSellsPropertyEntity) o;

        if (sellerSsn != that.sellerSsn) return false;
        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sellerSsn;
        result = 31 * result + propertyPropertyId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Seller_ssn", referencedColumnName = "ssn", nullable = false)
    public SellerEntity getSellerBySellerSsn() {
        return sellerBySellerSsn;
    }

    public void setSellerBySellerSsn(SellerEntity sellerBySellerSsn) {
        this.sellerBySellerSsn = sellerBySellerSsn;
    }
}
