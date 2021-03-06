-- MySQL Workbench Synchronization
-- Generated: 2017-11-21 19:47
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Austin Dase

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `RealEstate`.`Applicant` (
  `ssn` INT(11) NOT NULL,
  `l_name` VARCHAR(45) NULL DEFAULT NULL,
  `m_name` VARCHAR(45) NULL DEFAULT NULL,
  `creditScore` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `moveDate` VARCHAR(45) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  `employer` VARCHAR(45) NULL DEFAULT NULL,
  `jobTitle` VARCHAR(45) NULL DEFAULT NULL,
  `salary` VARCHAR(45) NULL DEFAULT NULL,
  `f_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ssn`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Seller` (
  `ssn` INT(11) NOT NULL,
  `zipCode` INT(11) NULL DEFAULT NULL,
  `streetAddress` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `State` VARCHAR(45) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  `f_name` VARCHAR(45) NULL DEFAULT NULL,
  `m_name` VARCHAR(45) NULL DEFAULT NULL,
  `l_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ssn`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Property` (
  `propertyID` INT(11) NOT NULL,
  `deckOrPatio` VARCHAR(45) NULL DEFAULT NULL,
  `washer` VARCHAR(45) NULL DEFAULT NULL,
  `dryer` VARCHAR(45) NULL DEFAULT NULL,
  `offStreetParking` VARCHAR(45) NULL DEFAULT NULL,
  `numberOfBaths` INT(11) NULL DEFAULT NULL,
  `buildingType` VARCHAR(45) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  `basement` VARCHAR(45) NULL DEFAULT NULL,
  `parkingType` VARCHAR(45) NULL DEFAULT NULL,
  `numOfRooms` VARCHAR(45) NULL DEFAULT NULL,
  `zipCode` INT(11) NULL DEFAULT NULL,
  `streetAddress` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `numOfTennants` INT(11) NULL DEFAULT NULL,
  `Tennant_ssn` INT(11) NOT NULL,
  PRIMARY KEY (`propertyID`, `Tennant_ssn`),
  INDEX `fk_Property_Tennant_idx` (`Tennant_ssn` ASC),
  CONSTRAINT `fk_Property_Tennant`
  FOREIGN KEY (`Tennant_ssn`)
  REFERENCES `RealEstate`.`Tennant` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Employee` (
  `ssn` INT(11) NOT NULL,
  `f_name` VARCHAR(45) NULL DEFAULT NULL,
  `m_name` VARCHAR(45) NULL DEFAULT NULL,
  `l_name` VARCHAR(45) NULL DEFAULT NULL,
  `pay` DECIMAL(13,2) NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ssn`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Tennant` (
  `ssn` INT(11) NOT NULL,
  `f_name` VARCHAR(45) NULL DEFAULT NULL,
  `m_name` VARCHAR(45) NULL DEFAULT NULL,
  `l_name` VARCHAR(45) NULL DEFAULT NULL,
  `birthdate` DATETIME NULL DEFAULT NULL,
  `phoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  `car` VARCHAR(45) NULL DEFAULT NULL,
  `workStatus` VARCHAR(45) NULL DEFAULT NULL,
  `rentersInsurance` VARCHAR(45) NULL DEFAULT NULL,
  `rent` DECIMAL(13,2) NULL DEFAULT NULL,
  `leaseEndDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`ssn`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Dependent` (
  `depId` INT(11) NOT NULL,
  `f_name` VARCHAR(45) NULL DEFAULT NULL,
  `m_name` VARCHAR(45) NULL DEFAULT NULL,
  `l_name` VARCHAR(45) NULL DEFAULT NULL,
  `birthDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`depId`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Repair` (
  `repairId` INT(11) NOT NULL,
  `cost` DECIMAL(13,2) NULL DEFAULT NULL,
  `effectedArea` VARCHAR(45) NULL DEFAULT NULL,
  `vendor` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`repairId`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Expense` (
  `expenseId` INT(11) NOT NULL,
  `cost` DECIMAL(13,2) NULL DEFAULT NULL,
  `expense` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`expenseId`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Amenity` (
  `amenityid` INT(11) NOT NULL,
  `amenity` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`amenityid`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Seller_Sells_Property` (
  `Seller_ssn` INT(11) NOT NULL,
  `Property_propertyID` INT(11) NOT NULL,
  `Property_Tennant_ssn` INT(11) NOT NULL,
  `price` DECIMAL(13,2) NULL DEFAULT NULL,
  PRIMARY KEY (`Seller_ssn`, `Property_propertyID`, `Property_Tennant_ssn`),
  INDEX `fk_Seller_has_Property_Property1_idx` (`Property_propertyID` ASC, `Property_Tennant_ssn` ASC),
  INDEX `fk_Seller_has_Property_Seller1_idx` (`Seller_ssn` ASC),
  CONSTRAINT `fk_Seller_has_Property_Seller1`
  FOREIGN KEY (`Seller_ssn`)
  REFERENCES `RealEstate`.`Seller` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Seller_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID` , `Property_Tennant_ssn`)
  REFERENCES `RealEstate`.`Property` (`propertyID` , `Tennant_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Applicant_Applies_For_Property` (
  `Applicant_ssn` INT(11) NOT NULL,
  `Property_propertyID` INT(11) NOT NULL,
  `Property_Tennant_ssn` INT(11) NOT NULL,
  `applicationStatus` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Applicant_ssn`, `Property_propertyID`, `Property_Tennant_ssn`),
  INDEX `fk_Applicant_has_Property_Property1_idx` (`Property_propertyID` ASC, `Property_Tennant_ssn` ASC),
  INDEX `fk_Applicant_has_Property_Applicant1_idx` (`Applicant_ssn` ASC),
  CONSTRAINT `fk_Applicant_has_Property_Applicant1`
  FOREIGN KEY (`Applicant_ssn`)
  REFERENCES `RealEstate`.`Applicant` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Applicant_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID` , `Property_Tennant_ssn`)
  REFERENCES `RealEstate`.`Property` (`propertyID` , `Tennant_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Propertty_Needs_Repair` (
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

CREATE TABLE IF NOT EXISTS `RealEstate`.`Property_has_Expense` (
  `Expense_expenseId` INT(11) NOT NULL,
  `Property_propertyID` INT(11) NOT NULL,
  `Property_Tennant_ssn` INT(11) NOT NULL,
  PRIMARY KEY (`Expense_expenseId`, `Property_propertyID`, `Property_Tennant_ssn`),
  INDEX `fk_Expense_has_Property_Property1_idx` (`Property_propertyID` ASC, `Property_Tennant_ssn` ASC),
  INDEX `fk_Expense_has_Property_Expense1_idx` (`Expense_expenseId` ASC),
  CONSTRAINT `fk_Expense_has_Property_Expense1`
  FOREIGN KEY (`Expense_expenseId`)
  REFERENCES `RealEstate`.`Expense` (`expenseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Expense_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID` , `Property_Tennant_ssn`)
  REFERENCES `RealEstate`.`Property` (`propertyID` , `Tennant_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Property_has_Amenity` (
  `Amenity_amenityid` INT(11) NULL DEFAULT NULL,
  `Property_propertyID` INT(11) NOT NULL,
  `Property_Tennant_ssn` INT(11) NOT NULL,
  PRIMARY KEY (`Property_propertyID`, `Property_Tennant_ssn`),
  INDEX `fk_Amenity_has_Property_Property1_idx` (`Property_propertyID` ASC, `Property_Tennant_ssn` ASC),
  INDEX `fk_Amenity_has_Property_Amenity1_idx` (`Amenity_amenityid` ASC),
  CONSTRAINT `fk_Amenity_has_Property_Amenity1`
  FOREIGN KEY (`Amenity_amenityid`)
  REFERENCES `RealEstate`.`Amenity` (`amenityid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Amenity_has_Property_Property1`
  FOREIGN KEY (`Property_propertyID` , `Property_Tennant_ssn`)
  REFERENCES `RealEstate`.`Property` (`propertyID` , `Tennant_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Dependent_lives_with_Tennant` (
  `Dependent_depId` INT(11) NULL DEFAULT NULL,
  `Tennant_ssn` INT(11) NOT NULL,
  PRIMARY KEY (`Tennant_ssn`),
  INDEX `fk_Dependent_has_Tennant_Tennant1_idx` (`Tennant_ssn` ASC),
  INDEX `fk_Dependent_has_Tennant_Dependent1_idx` (`Dependent_depId` ASC),
  CONSTRAINT `fk_Dependent_has_Tennant_Dependent1`
  FOREIGN KEY (`Dependent_depId`)
  REFERENCES `RealEstate`.`Dependent` (`depId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dependent_has_Tennant_Tennant1`
  FOREIGN KEY (`Tennant_ssn`)
  REFERENCES `RealEstate`.`Tennant` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `RealEstate`.`Employee_Works_At_Property` (
  `Property_propertyID` INT(11) NOT NULL,
  `Property_Tennant_ssn` INT(11) NOT NULL,
  `Employee_ssn` INT(11) NOT NULL,
  PRIMARY KEY (`Property_propertyID`, `Property_Tennant_ssn`, `Employee_ssn`),
  INDEX `fk_Property_has_Employee_Employee1_idx` (`Employee_ssn` ASC),
  INDEX `fk_Property_has_Employee_Property1_idx` (`Property_propertyID` ASC, `Property_Tennant_ssn` ASC),
  CONSTRAINT `fk_Property_has_Employee_Property1`
  FOREIGN KEY (`Property_propertyID` , `Property_Tennant_ssn`)
  REFERENCES `RealEstate`.`Property` (`propertyID` , `Tennant_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Property_has_Employee_Employee1`
  FOREIGN KEY (`Employee_ssn`)
  REFERENCES `RealEstate`.`Employee` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;