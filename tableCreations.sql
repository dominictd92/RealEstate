CREATE TABLE IF NOT EXISTS Employee (
    ssn INT NOT NULL,
    f_name VARCHAR(45),
    m_name VARCHAR(45),
    l_name VARCHAR(45),
    pay DECIMAL(13,2),
    phoneNumber VARCHAR(45), 
    PRIMARY KEY (ssn)
);
CREATE TABLE IF NOT EXISTS Applicant (
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
);
CREATE TABLE IF NOT EXISTS Tennant (
    ssn INT NOT NULL,
    f_name VARCHAR(45),
    m_name VARCHAR(45),
    l_name VARCHAR(45),
    birthdate VARCHAR(45),
    phoneNumber VARCHAR(45),
    car VARCHAR(45),
    workStatus VARCHAR(45),
    rentersInsurance VARCHAR(45),
    rent DECIMAL(13,2),
    leaseEndDate DATETIME, 
    PRIMARY KEY (ssn)
);
CREATE TABLE IF NOT EXISTS Dependent (
    depId INT NOT NULL AUTO_INCREMENT, 
    f_name VARCHAR(45),
    m_name VARCHAR(45),
    l_name VARCHAR(45),
    birthDate DATETIME,
    PRIMARY KEY (depId)
);
CREATE TABLE IF NOT EXISTS Seller (
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
);
CREATE TABLE IF NOT EXISTS Repair (
    repairId INT NOT NULL AUTO_INCREMENT,
    cost DECIMAL(13,2),
    effectedArea VARCHAR(45),
    vendor VARCHAR(45), 
    PRIMARY KEY (repairId)
);
CREATE TABLE IF NOT EXISTS Expense (
    expenseId INT NOT NULL AUTO_INCREMENT,
    cost DECIMAL(13,2),
    expense VARCHAR(45),
    PRIMARY KEY (expenseId)
);
CREATE TABLE IF NOT EXISTS Amenity (
    amenityId INT NOT NULL AUTO_INCREMENT,
    amenity VARCHAR(45), 
    PRIMARY KEY (amenityId)
);
CREATE TABLE IF NOT EXISTS Property (
    propertyID INT NOT NULL AUTO_INCREMENT,
    deckOrPatio INT,
    washer INT,
    dryer INT,
    offStreetParking INT, 
    numberOfBaths INT,
    buildingType VARCHAR(45),
    phoneNumber VARCHAR(45),
    basement INT,
    parkingType VARCHAR(45),
    numOfRooms INT,
    zipCode INT,
    streetAddress VARCHAR(45),
    city VARCHAR(45),
    state VARCHAR(2),
    numOfTennants INT,
    Tennant_ssn INT,
    PRIMARY KEY (propertyID),
    FOREIGN KEY (Tennant_ssn) REFERENCES Tennant(ssn)
);

CREATE TABLE IF NOT EXISTS Tennant_Lives_In_Property (
    Tennant_tennantSsn INT(11) NOT NULL,
    Property_propertyID INT NOT NULL, 
    PRIMARY KEY (Tennant_tennantSsn, Property_propertyID),
    FOREIGN KEY (Tennant_tennantSsn) REFERENCES Tennant(ssn),
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID)
);

CREATE TABLE IF NOT EXISTS Employee_Works_At_Property ( 
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    Employee_ssn INT,
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyId),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn),
    FOREIGN KEY (Employee_ssn) REFERENCES Employee(ssn)
);
CREATE TABLE IF NOT EXISTS Seller_Sells_Property (
    seller_ssn INT NOT NULL,
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    price DECIMAL(13,2), 
    FOREIGN KEY (seller_ssn) REFERENCES Seller(ssn),
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
);
CREATE TABLE IF NOT EXISTS Applicant_Applies_For_Property (
    Applicant_ssn INT,
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    applicationStatus VARCHAR(45),
    FOREIGN KEY (Applicant_ssn) REFERENCES Applicant(ssn), 
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
);
CREATE TABLE IF NOT EXISTS Property_Needs_Repair (
    repair_repairId INT,
    property_propertyID INT,
    property_Tennant_ssn INT, 
    FOREIGN KEY (repair_repairId) REFERENCES Repair(repairId),
    FOREIGN KEY (property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (property_Tennant_ssn) REFERENCES Tennant(ssn)
);
CREATE TABLE IF NOT EXISTS Property_has_Expense (
    Expense_expenseId INT,
    Property_propertyID INT,
    Property_Tennant_ssn INT,
    FOREIGN KEY (Expense_expenseId) REFERENCES Expense(expenseId),
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
);
CREATE TABLE IF NOT EXISTS Property_has_Amenity (
    Amenity_amenityid INT,
    Property_propertyID INT,
    Property_Tennant_ssn INT, 
    FOREIGN KEY (Amenity_amenityid) REFERENCES Amenity(amenityId),
    FOREIGN KEY (Property_propertyID) REFERENCES Property(propertyID),
    FOREIGN KEY (Property_Tennant_ssn) REFERENCES Tennant(ssn)
);
CREATE TABLE IF NOT EXISTS Dependent_Lives_with_Tennant (
    Dependent_depId INT,
    Tennant_ssn INT,
    FOREIGN KEY (Dependent_depId) REFERENCES Dependent(depId),
    FOREIGN KEY (Tennant_ssn) REFERENCES Tennant(ssn)
);
CREATE TABLE IF NOT EXISTS State (
state_id   smallint  unsigned not null auto_increment,
state_abbr varchar(8),
PRIMARY KEY (state_id)
);
INSERT INTO State
values
(NULL, '--'),
(NULL, 'AL'),
(NULL, 'AK'),
(NULL, 'AZ'),
(NULL, 'AR'),
(NULL, 'CA'),
(NULL, 'CO'),
(NULL, 'CT'),
(NULL, 'DE'),
(NULL, 'DC'),
(NULL, 'FL'),
(NULL, 'GA'),
(NULL, 'HI'),
(NULL, 'ID'),
(NULL, 'IL'),
(NULL, 'IN'),
(NULL, 'IA'),
(NULL, 'KS'),
(NULL, 'KY'),
(NULL, 'LA'),
(NULL, 'ME'),
(NULL,'MD'),
(NULL,'MA'),
(NULL, 'MI'),
(NULL,'MN'),
(NULL,'MS'),
(NULL,'MO'),
(NULL,'MT'),
(NULL,'NE'),
(NULL,'NV'),
(NULL,'NH'),
(NULL,'NJ'),
(NULL,'NM'),
(NULL,'NY'),
(NULL,'NC'),
(NULL,'ND'),
(NULL,'OH'),
(NULL,'OK'),
(NULL,'OR'),
(NULL,'PA'),
(NULL,'RI'),
(NULL,'SC'),
(NULL,'SD'),
(NULL,'TN'),
(NULL,'TX'),
(NULL,'UT'),
(NULL,'VT'),
(NULL,'VA'),
(NULL,'WA'),
(NULL,'WV'),
(NULL,'WI'),
(NULL,'WY');
