package entities;

import javax.persistence.*;

@Entity
@Table(name = "Property_has_Amenity", schema = "RealEstate", catalog = "")
@IdClass(PropertyHasAmenityEntityPK.class)
public class PropertyHasAmenityEntity {
    private int propertyPropertyId;
    private int propertyTennantSsn;
    private AmenityEntity amenityByAmenityAmenityid;
    private PropertyEntity property;

    @Id
    @Column(name = "Property_propertyID")
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Id
    @Column(name = "Property_Tennant_ssn")
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

        PropertyHasAmenityEntity that = (PropertyHasAmenityEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "Amenity_amenityid", referencedColumnName = "amenityid")
    public AmenityEntity getAmenityByAmenityAmenityid() {
        return amenityByAmenityAmenityid;
    }

    public void setAmenityByAmenityAmenityid(AmenityEntity amenityByAmenityAmenityid) {
        this.amenityByAmenityAmenityid = amenityByAmenityAmenityid;
    }

    @OneToOne
    @JoinColumns({@JoinColumn(name = "Property_propertyID", referencedColumnName = "propertyID", nullable = false), @JoinColumn(name = "Property_Tennant_ssn", referencedColumnName = "Tennant_ssn", nullable = false)})
    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }
}
