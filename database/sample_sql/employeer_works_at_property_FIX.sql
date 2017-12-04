ALTER TABLE `RealEstate`.`Employee_Works_At_Property` 
DROP FOREIGN KEY `fk_Property_has_Employee_Property1`;
ALTER TABLE `RealEstate`.`Employee_Works_At_Property` 
DROP COLUMN `Property_Tennant_ssn`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`Property_propertyID`, `Employee_ssn`),
DROP INDEX `fk_Property_has_Employee_Property1_idx` ,
ADD INDEX `fk_Property_has_Employee_Property1_idx` (`Property_propertyID` ASC);
ALTER TABLE `RealEstate`.`Employee_Works_At_Property` 
ADD CONSTRAINT `fk_Property_has_Employee_Property1`
  FOREIGN KEY (`Property_propertyID`)
  REFERENCES `RealEstate`.`Property` (`propertyID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
