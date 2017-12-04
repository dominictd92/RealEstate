-- Fixes run in order to fix the duplacte t in the Propertty_Needs_repair table
-- drop
drop table `RealEstate`.`Propertty_Needs_Repair`;

-- fix with a new create

CREATE TABLE IF NOT EXISTS `RealEstate`.`Property_Needs_Repair` (
  `Repair_repairId` INT(11) NULL DEFAULT NULL,
  `Property_propertyID` INT(11) NOT NULL,
  `Property_RepairID` INT(11) NOT NULL,
  PRIMARY KEY (`Property_RepairID`),
  CONSTRAINT `fk_Repair_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID`)
  REFERENCES `RealEstate`.`Property` (`propertyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Repair_has_Repair_Repair1`
  FOREIGN KEY (`Repair_repairId` )
  REFERENCES `RealEstate`.`Repair` (`repairId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

