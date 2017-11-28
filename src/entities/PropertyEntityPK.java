package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PropertyEntityPK implements Serializable {
    private int propertyId;
    private int tennantSsn;

    @Column(name = "propertyID")
    @Id
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Column(name = "Tennant_ssn")
    @Id
    public int getTennantSsn() {
        return tennantSsn;
    }

    public void setTennantSsn(int tennantSsn) {
        this.tennantSsn = tennantSsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyEntityPK that = (PropertyEntityPK) o;

        if (propertyId != that.propertyId) return false;
        if (tennantSsn != that.tennantSsn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propertyId;
        result = 31 * result + tennantSsn;
        return result;
    }
}
