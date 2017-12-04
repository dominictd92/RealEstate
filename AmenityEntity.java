package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Amenity", schema = "RealEstate", catalog = "")
public class AmenityEntity {
    private int amenityid;
    private String amenity;
    private Collection<PropertyHasAmenityEntity> propertyHasAmenitiesByAmenityid;

    public AmenityEntity(int amenityid, String amenity) {
        this.amenityid = amenityid;
        this.amenity = amenity;
    }

    public AmenityEntity(int amenityid, String amenity, Collection<PropertyHasAmenityEntity> propertyHasAmenitiesByAmenityid) {

        this.amenityid = amenityid;
        this.amenity = amenity;
        this.propertyHasAmenitiesByAmenityid = propertyHasAmenitiesByAmenityid;
    }

    @Id
    @Column(name = "amenityid", nullable = false)
    public int getAmenityid() {
        return amenityid;
    }

    public void setAmenityid(int amenityid) {
        this.amenityid = amenityid;
    }

    @Basic
    @Column(name = "amenity", nullable = true, length = 45)
    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmenityEntity that = (AmenityEntity) o;

        if (amenityid != that.amenityid) return false;
        if (amenity != null ? !amenity.equals(that.amenity) : that.amenity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amenityid;
        result = 31 * result + (amenity != null ? amenity.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "amenityByAmenityAmenityid")
    public Collection<PropertyHasAmenityEntity> getPropertyHasAmenitiesByAmenityid() {
        return propertyHasAmenitiesByAmenityid;
    }

    public void setPropertyHasAmenitiesByAmenityid(Collection<PropertyHasAmenityEntity> propertyHasAmenitiesByAmenityid) {
        this.propertyHasAmenitiesByAmenityid = propertyHasAmenitiesByAmenityid;
    }
}
