ALTER TABLE `RealEstate`.`Applicant_Applies_For_Property` 
DROP FOREIGN KEY `fk_Applicant_has_Property_Property1`;
ALTER TABLE `RealEstate`.`Applicant_Applies_For_Property` 
DROP COLUMN `Property_Tennant_ssn`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`Applicant_ssn`, `Property_propertyID`),
DROP INDEX `fk_Applicant_has_Property_Property1_idx` ,
ADD INDEX `fk_Applicant_has_Property_Property1_idx` (`Property_propertyID` ASC);
ALTER TABLE `RealEstate`.`Applicant_Applies_For_Property` 
ADD CONSTRAINT `fk_Applicant_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID`)
  REFERENCES `RealEstate`.`Property` (`propertyID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
