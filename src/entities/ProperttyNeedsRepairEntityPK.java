package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProperttyNeedsRepairEntityPK implements Serializable {
    private int propertyPropertyId;
    private int propertyTennantSsn;

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

        ProperttyNeedsRepairEntityPK that = (ProperttyNeedsRepairEntityPK) o;

        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (propertyTennantSsn != that.propertyTennantSsn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propertyPropertyId;
        result = 31 * result + propertyTennantSsn;
        return result;
    }
}
