CREATE TABLE Employee (
    ssn INT NOT NULL,
    f_name VARCHAR(45),
    m_name VARCHAR(45),
    l_name VARCHAR(45),
    pay DECIMAL(13,2),
    phoneNumber VARCHAR(45), 
    PRIMARY KEY (ssn)
)
GO
CREATE TABLE Applicant (
    ssn INT NOT NULL, 
    f_name VARCHAR(45),
    l_name VARCHAR(45),
    m_name VARCHAR(45),
    creditScore VARCHAR(45),
    address VARCHAR(45),
    moveDate VARCHAR(45),
    phoneNumber VARCHAR(45),
    employer VARCHAR(45),
    jobTitle VARCHAR(45),
    salary VARCHAR(45), 
    PRIMARY KEY (ssn)
)
GO
CREATE TABLE Tennant (
    ssn INT NOT NULL,
    f_name VARCHAR(45),
    m_name VARCHAR(45),
    l_name VARCHAR(45),
    birthdate DATETIME,
    phoneNumber VARCHAR(45),
    car VARCHAR(45),
    workStatus VARCHAR(45),
    rentersInsurance VARCHAR(45),
    rent DECIMAL(13,2),
    leaseEndDate DATETIME, 
    PRIMARY KEY (ssn)
)
GO
CREATE TABLE Dependent (
    depId INT NOT NULL, 
    f_name VARCHAR(45),
    m_name VARCHAR(45),
    l_name VARCHAR(45),
    birthDate DATETIME,
    PRIMARY KEY (depId)
)
GO
CREATE TABLE Seller (
    ssn INT NOT NULL,
    zipCode INT, 
    streetAddress VARCHAR(45),
    city VARCHAR(45), 
    state VARCHAR(45),
    phoneNumber VARCHAR(45),
    f_name VARCHAR(45),
    m_name VARCHAR(45),
    l_name VARCHAR(45),
    PRIMARY KEY (ssn)
)
GO
CREATE TABLE Repair (
    repairId INT NOT NULL,
    cost DECIMAL(13,2),
    effectedArea VARCHAR(45),
    vendor VARCHAR(45), 
    PRIMARY KEY (repairId)
)
GO
CREATE TABLE Expense (
    expenseId INT NOT NULL,
    cost DECIMAL(13,2),
    expense VARCHAR(45),
    PRIMARY KEY (expenseId)
)
GO
CREATE TABLE Amenity (
    amenityId INT NOT NULL,
    amenity VARCHAR(45), 
    PRIMARY KEY (amenityId)
)
GO
CREATE TABLE Property (
    propertyID INT NOT NULL,
    deckOrPatio VARCHAR(3),
    washer VARCHAR(3),
    dryer VARCHAR(3),
    offStreetParking INT, 
    numberOfBaths INT,
    buildingType VARCHAR(45),
    phoneNumber VARCHAR(45),
    basement VARCHAR(45),
    parkingType VARCHAR(45),
    numOfRooms VARCHAR(45),
    zipCode INT,
    streetAddress VARCHAR(45),
    city VARCHAR(45),
    state VARCHAR(45),
    numOfTennants INT,
    Tennant_ssn INT,
    PRIMARY KEY (propertyID),
    FOREIGN KEY (Tennant_ssn) REFERENCES Tennant(ssn)
)
GO
CREATE TABLE Employee_Works_At_Property ( 
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    Employee_ssn INT,
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyId),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn),
    FOREIGN KEY (Employee_ssn) REFERENCES Employee(ssn)
)
GO
CREATE TABLE Seller_Sells_Property (
    seller_ssn INT NOT NULL,
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    price DECIMAL(13,2), 
    FOREIGN KEY (seller_ssn) REFERENCES Seller(ssn),
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
)
GO
CREATE TABLE Applicant_Applies_For_Property (
    Applicant_ssn INT,
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    applicationStatus VARCHAR(45),
    FOREIGN KEY (Applicant_ssn) REFERENCES Applicant(ssn), 
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
)
GO
CREATE TABLE Property_Needs_Repair (
    repair_repairId INT,
    property_propertyID INT,
    property_Tennant_ssn INT, 
    FOREIGN KEY (repair_repairId) REFERENCES Repair(repairId),
    FOREIGN KEY (property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (property_Tennant_ssn) REFERENCES Tennant(ssn)
)
GO
CREATE TABLE Property_has_Expense (
    Expense_expenseId INT,
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    FOREIGN KEY (Expense_expenseId) REFERENCES Expense(expenseId),
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
)
GO
CREATE TABLE Property_has_Amenity (
    Amenity_amenityid INT,
    Property_propertyID INT,
    Property_Tennant_ssn INT, 
    FOREIGN KEY (Amenity_amenityid) REFERENCES Amenity(amenityId),
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
)
GO
CREATE TABLE Dependent_Lives_with_Tennant (
    Dependent_depId INT,
    Tennant_ssn INT,
    FOREIGN KEY (Dependent_depId) REFERENCES Dependent(depId),
    FOREIGN KEY (Tennant_ssn) REFERENCES Tennant(ssn)
)