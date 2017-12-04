package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Property_has_Amenity", schema = "RealEstate", catalog = "")
public class PropertyHasAmenityEntity {
    private int amenityAmenityid;
    private int propertyPropertyId;
    private int porportyAmenityid;
    private AmenityEntity amenityByAmenityAmenityid;
    private Collection<PropertyEntity> propertyByPropertyId;

    @Basic
    @Column(name = "Amenity_amenityid", nullable = false)
    public int getAmenityAmenityid() {
        return amenityAmenityid;
    }

    public void setAmenityAmenityid(int amenityAmenityid) {
        this.amenityAmenityid = amenityAmenityid;
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
    @Column(name = "Porporty_amenityid", nullable = false)
    public int getPorportyAmenityid() {
        return porportyAmenityid;
    }

    public void setPorportyAmenityid(int porportyAmenityid) {
        this.porportyAmenityid = porportyAmenityid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyHasAmenityEntity that = (PropertyHasAmenityEntity) o;

        if (amenityAmenityid != that.amenityAmenityid) return false;
        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (porportyAmenityid != that.porportyAmenityid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amenityAmenityid;
        result = 31 * result + propertyPropertyId;
        result = 31 * result + porportyAmenityid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Amenity_amenityid", referencedColumnName = "amenityid", nullable = false)
    public AmenityEntity getAmenityByAmenityAmenityid() {
        return amenityByAmenityAmenityid;
    }

    public void setAmenityByAmenityAmenityid(AmenityEntity amenityByAmenityAmenityid) {
        this.amenityByAmenityAmenityid = amenityByAmenityAmenityid;
    }

    @OneToMany(mappedBy = "propertyHasAmenityByPropertyId")
    public Collection<PropertyEntity> getPropertyByPropertyId() {
        return propertyByPropertyId;
    }

    public void setPropertyByPropertyId(Collection<PropertyEntity> propertyByPropertyId) {
        this.propertyByPropertyId = propertyByPropertyId;
    }
}
