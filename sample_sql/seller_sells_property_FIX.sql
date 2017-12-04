ALTER TABLE `RealEstate`.`Seller_Sells_Property` 
DROP FOREIGN KEY `fk_Seller_has_Property_Property1`;
ALTER TABLE `RealEstate`.`Seller_Sells_Property` 
DROP COLUMN `Property_Tennant_ssn`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`Seller_ssn`, `Property_propertyID`),
DROP INDEX `fk_Seller_has_Property_Property1_idx` ,
ADD INDEX `fk_Seller_has_Property_Property1_idx` (`Property_propertyID` ASC);
ALTER TABLE `RealEstate`.`Seller_Sells_Property` 
ADD CONSTRAINT `fk_Seller_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID`)
  REFERENCES `RealEstate`.`Property` (`propertyID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
