package entities;

import javax.persistence.*;

@Entity
@Table(name = "Property", schema = "RealEstate", catalog = "")
@IdClass(PropertyEntityPK.class)
public class PropertyEntity {
    private Integer propertyID;
    private Integer deckOrPatio;
    private Integer washer;
    private Integer dryer;
    private Integer offStreetParking;
    private Integer numberOfBaths;
    private String buildingType;
    private String phoneNumber;
    private Integer basement;
    private String parkingType;
    private Integer numOfRooms;
    private Integer zipCode;
    private String streetAddress;
    private String city;
    private String state;
    private Integer numOfTennants;
    private Integer tennantSsn;
    private ProperttyNeedsRepairEntity properttyNeedsRepair;
    
    public PropertyEntity (Integer propertyID, String streetAddress, String city, String state, Integer zipCode, 
            String phoneNumber, Integer numOfRooms, Integer numberOfBaths, Integer tennant_ssn, Integer numOfTennants, 
            Integer washer, Integer dryer, Integer deckOrPatio, Integer basement) {
        this.propertyID = propertyID;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.numOfRooms = numOfRooms;
        this.numberOfBaths = numberOfBaths;
        this.washer = washer;
        this.dryer = dryer;
        this.deckOrPatio = deckOrPatio;
        this.basement = basement;
        this.tennantSsn = tennant_ssn;
        this.numOfTennants = numOfTennants;
    }
    
    public PropertyEntity() { 
        //null
    }
    
    @Id
    @Column(name = "propertyID")
    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    @Basic
    @Column(name = "deckOrPatio")
    public Integer getDeckOrPatio() {
        return deckOrPatio;
    }

    public void setDeckOrPatio(Integer deckOrPatio) {
        this.deckOrPatio = deckOrPatio;
    }

    @Basic
    @Column(name = "washer")
    public Integer getWasher() {
        return washer;
    }

    public void setWasher(Integer washer) {
        this.washer = washer;
    }

    @Basic
    @Column(name = "dryer")
    public Integer getDryer() {
        return dryer;
    }

    public void setDryer(Integer dryer) {
        this.dryer = dryer;
    }

    @Basic
    @Column(name = "offStreetParking")
    public Integer getOffStreetParking() {
        return offStreetParking;
    }

    public void setOffStreetParking(Integer offStreetParking) {
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
    public Integer getBasement() {
        return basement;
    }

    public void setBasement(Integer basement) {
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
    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
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
    public Integer getTennantSsn() {
        return tennantSsn;
    }

    public void setTennantSsn(Integer tennantSsn) {
        this.tennantSsn = tennantSsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyEntity that = (PropertyEntity) o;

        if (propertyID != that.propertyID) return false;
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
        int result = propertyID.intValue();
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
