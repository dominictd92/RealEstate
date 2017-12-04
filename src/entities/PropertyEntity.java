package entities;

import javax.persistence.*;

@Entity
@Table(name = "Property", schema = "RealEstate", catalog = "")
@IdClass(PropertyEntityPK.class)
public class PropertyEntity {
    private Integer propertyId;
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
    private ApplicantAppliesForPropertyEntity applicantAppliesForPropertyByPropertyId;
    private EmployeeWorksAtPropertyEntity employeeWorksAtPropertyByPropertyId;
    private TennantEntity tennantByTennantSsn;
    private PropertyNeedsRepairEntity propertyNeedsRepairByPropertyId;
    private PropertyHasAmenityEntity propertyHasAmenityByPropertyId;
    private PropertyHasExpenseEntity propertyHasExpenseByPropertyId;
    private SellerSellsPropertyEntity sellerSellsPropertyByPropertyId;

    public PropertyEntity() { 
        //empty constructor
    }
    
    public PropertyEntity(int propertyID, String streetAddress, String city, String state, int zipCode, 
            String phoneNumber, Integer numOfRooms, int numOfBaths, int tennant_ssn, int numOfTennants, 
            int washer, int dryer, int deckOrPatio, int basement) {
        this.propertyId = propertyID;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state; 
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber; 
        this.numOfRooms = numOfRooms;
        this.numberOfBaths = numOfBaths;
        this.tennantSsn = tennant_ssn;
        this.numOfTennants = numOfTennants;
        this.washer = washer;
        this.dryer = dryer;
        this.deckOrPatio = deckOrPatio; 
        this.basement = basement;
    }

    @Id
    @Column(name = "propertyID", nullable = false)
    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Basic
    @Column(name = "deckOrPatio", nullable = true)
    public Integer getDeckOrPatio() {
        return deckOrPatio;
    }

    public void setDeckOrPatio(Integer deckOrPatio) {
        this.deckOrPatio = deckOrPatio;
    }

    @Basic
    @Column(name = "washer", nullable = true)
    public Integer getWasher() {
        return washer;
    }

    public void setWasher(Integer washer) {
        this.washer = washer;
    }

    @Basic
    @Column(name = "dryer", nullable = true)
    public Integer getDryer() {
        return dryer;
    }

    public void setDryer(Integer dryer) {
        this.dryer = dryer;
    }

    @Basic
    @Column(name = "offStreetParking", nullable = true)
    public Integer getOffStreetParking() {
        return offStreetParking;
    }

    public void setOffStreetParking(Integer offStreetParking) {
        this.offStreetParking = offStreetParking;
    }

    @Basic
    @Column(name = "numberOfBaths", nullable = true)
    public Integer getNumberOfBaths() {
        return numberOfBaths;
    }

    public void setNumberOfBaths(Integer numberOfBaths) {
        this.numberOfBaths = numberOfBaths;
    }

    @Basic
    @Column(name = "buildingType", nullable = true, length = 45)
    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "basement", nullable = true)
    public Integer getBasement() {
        return basement;
    }

    public void setBasement(Integer basement) {
        this.basement = basement;
    }

    @Basic
    @Column(name = "parkingType", nullable = true, length = 45)
    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    @Basic
    @Column(name = "numOfRooms", nullable = true)
    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Basic
    @Column(name = "zipCode", nullable = true)
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "streetAddress", nullable = true, length = 45)
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "numOfTennants", nullable = true)
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

    @ManyToOne
    @JoinColumn(name = "propertyID", referencedColumnName = "Property_propertyID", nullable = false)
    public ApplicantAppliesForPropertyEntity getApplicantAppliesForPropertyByPropertyId() {
        return applicantAppliesForPropertyByPropertyId;
    }

    public void setApplicantAppliesForPropertyByPropertyId(ApplicantAppliesForPropertyEntity applicantAppliesForPropertyByPropertyId) {
        this.applicantAppliesForPropertyByPropertyId = applicantAppliesForPropertyByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyID", referencedColumnName = "Property_propertyID", nullable = false)
    public EmployeeWorksAtPropertyEntity getEmployeeWorksAtPropertyByPropertyId() {
        return employeeWorksAtPropertyByPropertyId;
    }

    public void setEmployeeWorksAtPropertyByPropertyId(EmployeeWorksAtPropertyEntity employeeWorksAtPropertyByPropertyId) {
        this.employeeWorksAtPropertyByPropertyId = employeeWorksAtPropertyByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "Tennant_ssn", referencedColumnName = "ssn", nullable = false)
    public TennantEntity getTennantByTennantSsn() {
        return tennantByTennantSsn;
    }

    public void setTennantByTennantSsn(TennantEntity tennantByTennantSsn) {
        this.tennantByTennantSsn = tennantByTennantSsn;
    }

    @ManyToOne
    @JoinColumn(name = "propertyID", referencedColumnName = "Property_propertyID", nullable = false)
    public PropertyNeedsRepairEntity getPropertyNeedsRepairByPropertyId() {
        return propertyNeedsRepairByPropertyId;
    }

    public void setPropertyNeedsRepairByPropertyId(PropertyNeedsRepairEntity propertyNeedsRepairByPropertyId) {
        this.propertyNeedsRepairByPropertyId = propertyNeedsRepairByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyID", referencedColumnName = "Property_propertyID", nullable = false)
    public PropertyHasAmenityEntity getPropertyHasAmenityByPropertyId() {
        return propertyHasAmenityByPropertyId;
    }

    public void setPropertyHasAmenityByPropertyId(PropertyHasAmenityEntity propertyHasAmenityByPropertyId) {
        this.propertyHasAmenityByPropertyId = propertyHasAmenityByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyID", referencedColumnName = "Property_propertyID", nullable = false)
    public PropertyHasExpenseEntity getPropertyHasExpenseByPropertyId() {
        return propertyHasExpenseByPropertyId;
    }

    public void setPropertyHasExpenseByPropertyId(PropertyHasExpenseEntity propertyHasExpenseByPropertyId) {
        this.propertyHasExpenseByPropertyId = propertyHasExpenseByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyID", referencedColumnName = "Property_propertyID", nullable = false)
    public SellerSellsPropertyEntity getSellerSellsPropertyByPropertyId() {
        return sellerSellsPropertyByPropertyId;
    }

    public void setSellerSellsPropertyByPropertyId(SellerSellsPropertyEntity sellerSellsPropertyByPropertyId) {
        this.sellerSellsPropertyByPropertyId = sellerSellsPropertyByPropertyId;
    }
}
