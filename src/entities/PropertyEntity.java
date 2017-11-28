package entities;

import javax.persistence.*;

@Entity
@Table(name = "Property", schema = "RealEstate", catalog = "")
@IdClass(PropertyEntityPK.class)
public class PropertyEntity {
    private int propertyId;
    private String deckOrPatio;
    private String washer;
    private String dryer;
    private String offStreetParking;
    private Integer numberOfBaths;
    private String buildingType;
    private String phoneNumber;
    private String basement;
    private String parkingType;
    private String numOfRooms;
    private Integer zipCode;
    private String streetAddress;
    private String city;
    private String state;
    private Integer numOfTennants;
    private int tennantSsn;
    private ProperttyNeedsRepairEntity properttyNeedsRepair;

    @Id
    @Column(name = "propertyID")
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Basic
    @Column(name = "deckOrPatio")
    public String getDeckOrPatio() {
        return deckOrPatio;
    }

    public void setDeckOrPatio(String deckOrPatio) {
        this.deckOrPatio = deckOrPatio;
    }

    @Basic
    @Column(name = "washer")
    public String getWasher() {
        return washer;
    }

    public void setWasher(String washer) {
        this.washer = washer;
    }

    @Basic
    @Column(name = "dryer")
    public String getDryer() {
        return dryer;
    }

    public void setDryer(String dryer) {
        this.dryer = dryer;
    }

    @Basic
    @Column(name = "offStreetParking")
    public String getOffStreetParking() {
        return offStreetParking;
    }

    public void setOffStreetParking(String offStreetParking) {
        this.offStreetParking = offStreetParking;
    }

    @Basic
    @Column(name = "numberOfBaths")
    public Integer getNumberOfBaths() {
        return numberOfBaths;
    }

    public void setNumberOfBaths(Integer numberOfBaths) {
        this.numberOfBaths = numberOfBaths;
    }

    @Basic
    @Column(name = "buildingType")
    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "basement")
    public String getBasement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    @Basic
    @Column(name = "parkingType")
    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    @Basic
    @Column(name = "numOfRooms")
    public String getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(String numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Basic
    @Column(name = "zipCode")
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "numOfTennants")
    public Integer getNumOfTennants() {
        return numOfTennants;
    }

    public void setNumOfTennants(Integer numOfTennants) {
        this.numOfTennants = numOfTennants;
    }

    @Id
    @Column(name = "Tennant_ssn")
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

        PropertyEntity that = (PropertyEntity) o;

        if (propertyId != that.propertyId) return false;
        if (tennantSsn != that.tennantSsn) return false;
        if (deckOrPatio != null ? !deckOrPatio.equals(that.deckOrPatio) : that.deckOrPatio != null) return false;
        if (washer != null ? !washer.equals(that.washer) : that.washer != null) return false;
        if (dryer != null ? !dryer.equals(that.dryer) : that.dryer != null) return false;
        if (offStreetParking != null ? !offStreetParking.equals(that.offStreetParking) : that.offStreetParking != null)
            return false;
        if (numberOfBaths != null ? !numberOfBaths.equals(that.numberOfBaths) : that.numberOfBaths != null)
            return false;
        if (buildingType != null ? !buildingType.equals(that.buildingType) : that.buildingType != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (basement != null ? !basement.equals(that.basement) : that.basement != null) return false;
        if (parkingType != null ? !parkingType.equals(that.parkingType) : that.parkingType != null) return false;
        if (numOfRooms != null ? !numOfRooms.equals(that.numOfRooms) : that.numOfRooms != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (streetAddress != null ? !streetAddress.equals(that.streetAddress) : that.streetAddress != null)
            return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (numOfTennants != null ? !numOfTennants.equals(that.numOfTennants) : that.numOfTennants != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propertyId;
        result = 31 * result + (deckOrPatio != null ? deckOrPatio.hashCode() : 0);
        result = 31 * result + (washer != null ? washer.hashCode() : 0);
        result = 31 * result + (dryer != null ? dryer.hashCode() : 0);
        result = 31 * result + (offStreetParking != null ? offStreetParking.hashCode() : 0);
        result = 31 * result + (numberOfBaths != null ? numberOfBaths.hashCode() : 0);
        result = 31 * result + (buildingType != null ? buildingType.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (basement != null ? basement.hashCode() : 0);
        result = 31 * result + (parkingType != null ? parkingType.hashCode() : 0);
        result = 31 * result + (numOfRooms != null ? numOfRooms.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (numOfTennants != null ? numOfTennants.hashCode() : 0);
        result = 31 * result + tennantSsn;
        return result;
    }

    @OneToOne(mappedBy = "property")
    public ProperttyNeedsRepairEntity getProperttyNeedsRepair() {
        return properttyNeedsRepair;
    }

    public void setProperttyNeedsRepair(ProperttyNeedsRepairEntity properttyNeedsRepair) {
        this.properttyNeedsRepair = properttyNeedsRepair;
    }
}
