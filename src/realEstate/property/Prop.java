package realEstate.property;

/**
 *
 * @author bchar
 */
public class Prop {
    private int propertyID;
    private String streetAddress, city, state, zipCode, phoneNumber, numOfRooms, numberOfBaths, tennant_ssn, noOfTennants;
    private Boolean washer, dryer, deckOrPatio, basement;
    
    public int getpropertyID() {
        return propertyID ;
    }
    
    public String getstreetAddress() {
        return streetAddress;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getNumOfRooms() {
        return numOfRooms;
    }
    
    public String getNumberOfBaths() {
        return numberOfBaths;
    }
    
    public String getTennant_ssn() {
        return tennant_ssn;
    }  
    
    public String getNoOfTennants() {
        return noOfTennants;
    }
    
    public boolean getWasher() {
        return washer ;
    }
    
    public boolean getDryer() {
        return dryer;
    }
    
    public boolean getDeckOrPatio() {
        return deckOrPatio;
    }
        
    public boolean getBasement() {
        return basement;
    }
}
