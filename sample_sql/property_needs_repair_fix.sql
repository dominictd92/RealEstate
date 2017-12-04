-- Fixes run in order to fix the duplacte t in the Propertty_Needs_repair table
-- drop
drop table `RealEstate`.`Propertty_Needs_Repair`
-- recreate
CREATE TABLE IF NOT EXISTS `RealEstate`.`Property_Needs_Repair` (
  `Repair_repairId` INT(11) NULL DEFAULT NULL,
  `Property_propertyID` INT(11) NOT NULL,
  `Property_Tennant_ssn` INT(11) NOT NULL,
  PRIMARY KEY (`Property_propertyID`, `Property_Tennant_ssn`),
  INDEX `fk_Repair_has_Property_Property1_idx` (`Property_propertyID` ASC, `Property_Tennant_ssn` ASC),
  INDEX `fk_Repair_has_Property_Repair1_idx` (`Repair_repairId` ASC),
  CONSTRAINT `fk_Repair_has_Property_Repair1`
  FOREIGN KEY (`Repair_repairId`)
  REFERENCES `RealEstate`.`Repair` (`repairId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Repair_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID` , `Property_Tennant_ssn`)
  REFERENCES `RealEstate`.`Property` (`propertyID` , `Tennant_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

-- fix

ALTER TABLE `RealEstate`.`Propertty_Needs_Repair`
  CHANGE COLUMN `Property_Tennant_ssn` `Property_RepairID` INT(11) NOT NULL FIRST,
  CHANGE COLUMN `Repair_repairId` `Repair_repairId` INT(11) NOT NULL ,
  DROP PRIMARY KEY,
  ADD PRIMARY KEY (`Property_RepairID`);
ALTER TABLE `RealEstate`.`Propertty_Needs_Repair`
  ADD CONSTRAINT `fk_Repair_has_Property_Property1`
FOREIGN KEY (`Property_propertyID`)
REFERENCES `RealEstate`.`Property` (`propertyID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Repair_has_Repair_Repair1`
FOREIGN KEY (`Repair_repairId`)
REFERENCES `RealEstate`.`Repair` (`repairId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
