package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Property_Needs_Repair", schema = "RealEstate", catalog = "")
public class PropertyNeedsRepairEntity {
    private Integer repairRepairId;
    private int propertyPropertyId;
    private int propertyRepairId;
    private RepairEntity repairByRepairRepairId;
    private Collection<PropertyEntity> propertyByPropertyId;

    @Basic
    @Column(name = "Repair_repairId", nullable = true)
    public Integer getRepairRepairId() {
        return repairRepairId;
    }

    public void setRepairRepairId(Integer repairRepairId) {
        this.repairRepairId = repairRepairId;
    }

    @Basic
    @Column(name = "Property_propertyID", nullable = false)
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Id
    @Column(name = "Property_RepairID", nullable = false)
    public int getPropertyRepairId() {
        return propertyRepairId;
    }

    public void setPropertyRepairId(int propertyRepairId) {
        this.propertyRepairId = propertyRepairId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyNeedsRepairEntity that = (PropertyNeedsRepairEntity) o;

        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (propertyRepairId != that.propertyRepairId) return false;
        if (repairRepairId != null ? !repairRepairId.equals(that.repairRepairId) : that.repairRepairId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = repairRepairId != null ? repairRepairId.hashCode() : 0;
        result = 31 * result + propertyPropertyId;
        result = 31 * result + propertyRepairId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Repair_repairId", referencedColumnName = "repairId")
    public RepairEntity getRepairByRepairRepairId() {
        return repairByRepairRepairId;
    }

    public void setRepairByRepairRepairId(RepairEntity repairByRepairRepairId) {
        this.repairByRepairRepairId = repairByRepairRepairId;
    }

    @OneToMany(mappedBy = "propertyNeedsRepairByPropertyId")
    public Collection<PropertyEntity> getPropertyByPropertyId() {
        return propertyByPropertyId;
    }

    public void setPropertyByPropertyId(Collection<PropertyEntity> propertyByPropertyId) {
        this.propertyByPropertyId = propertyByPropertyId;
    }
}
