-- Not sure how these relationships got messed up... I'll fix them

ALTER TABLE `RealEstate`.`Property_has_Amenity` 
DROP FOREIGN KEY `fk_Amenity_has_Property_Property1`,
DROP FOREIGN KEY `fk_Amenity_has_Property_Amenity1`;
ALTER TABLE `RealEstate`.`Property_has_Amenity` 
CHANGE COLUMN `Amenity_amenityid` `Amenity_amenityid` INT(11) NOT NULL ,
CHANGE COLUMN `Property_Tennant_ssn` `Porporty_amenityid` INT(11) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`Porporty_amenityid`),
ADD INDEX `Property_Amenity_Has_Amenity_idx` (`Amenity_amenityid` ASC),
DROP INDEX `fk_Amenity_has_Property_Amenity1_idx` ;
ALTER TABLE `RealEstate`.`Property_has_Amenity` 
ADD CONSTRAINT `Property_Amenity_Has_Property`
  FOREIGN KEY (`Property_propertyID`)
  REFERENCES `RealEstate`.`Property` (`propertyID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `Property_Amenity_Has_Amenity`
  FOREIGN KEY (`Amenity_amenityid`)
  REFERENCES `RealEstate`.`Amenity` (`amenityid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
