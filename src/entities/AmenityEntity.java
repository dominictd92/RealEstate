package entities;

import javax.persistence.*;

@Entity
@Table(name = "Amenity", schema = "RealEstate", catalog = "")
public class AmenityEntity {
    private int amenityid;
    private String amenity;

    public AmenityEntity(int amenityid, String amenity) {
        this.amenityid = amenityid;
        this.amenity = amenity;
    }

    @Id
    @Column(name = "amenityid")
    public int getAmenityid() {
        return amenityid;
    }

    public void setAmenityid(int amenityid) {
        this.amenityid = amenityid;
    }

    @Basic
    @Column(name = "amenity")
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
}
