ALTER TABLE `RealEstate`.`Property_has_Expense` 
DROP FOREIGN KEY `fk_Expense_has_Property_Property1`,
DROP FOREIGN KEY `fk_Expense_has_Property_Expense1`;
ALTER TABLE `RealEstate`.`Property_has_Expense` 
CHANGE COLUMN `Expense_expenseId` `Expense_expenseId` INT(11) NULL ,
CHANGE COLUMN `Property_propertyID` `Property_propertyID` INT(11) NULL ,
CHANGE COLUMN `Property_Tennant_ssn` `Property_ExpenseID` INT(11) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`Property_ExpenseID`),
ADD INDEX `Property_Expense_Has_Property_idx` (`Property_propertyID` ASC),
DROP INDEX `fk_Expense_has_Property_Property1_idx` ;
ALTER TABLE `RealEstate`.`Property_has_Expense` 
ADD CONSTRAINT `Property_Expense_Has_Property`
  FOREIGN KEY (`Property_propertyID`)
  REFERENCES `RealEstate`.`Property` (`propertyID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `Property_Expense_Has_Expense`
  FOREIGN KEY (`Expense_expenseId`)
  REFERENCES `RealEstate`.`Expense` (`expenseId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


-- or you can drop and recreate with this:
Drop TABLE 'Property_has_Expense';
CREATE TABLE `Property_has_Expense` (
  `Expense_expenseId` int(11) DEFAULT NULL,
  `Property_propertyID` int(11) DEFAULT NULL,
  `Property_ExpenseID` int(11) NOT NULL,
  PRIMARY KEY (`Property_ExpenseID`),
  KEY `fk_Expense_has_Property_Expense1_idx` (`Expense_expenseId`),
  KEY `Property_Expense_Has_Property_idx` (`Property_propertyID`),
  CONSTRAINT `Property_Expense_Has_Expense` FOREIGN KEY (`Expense_expenseId`) REFERENCES `Expense` (`expenseId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Property_Expense_Has_Property` FOREIGN KEY (`Property_propertyID`) REFERENCES `Property` (`propertyID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SELECT * FROM RealEstate.Propertty_Needs_Repair;
