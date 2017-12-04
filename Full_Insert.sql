SET FOREIGN_KEY_CHECKS = 0;

/* Amenity */
INSERT INTO `adase1db`.`Amenity` (`amenityid`, `amenity`) VALUES ('1', 'amenity1');
INSERT INTO `adase1db`.`Amenity` (`amenityid`, `amenity`) VALUES ('2', 'amenity2');
INSERT INTO `adase1db`.`Amenity` (`amenityid`, `amenity`) VALUES ('3', 'amenity3');
INSERT INTO `adase1db`.`Amenity` (`amenityid`, `amenity`) VALUES ('4', 'amenity4');



INSERT INTO `adase1db`.`Applicant_Applies_For_Property` (`Applicant_ssn`, `Property_propertyID`,  `applicationStatus`) VALUES ('334567891', '1', 'pending');
INSERT INTO `adase1db`.`Applicant_Applies_For_Property` (`Applicant_ssn`, `Property_propertyID`,  `applicationStatus`) VALUES ('334567892', '2', 'pending');
INSERT INTO `adase1db`.`Applicant_Applies_For_Property` (`Applicant_ssn`, `Property_propertyID`,  `applicationStatus`) VALUES ('334567893', '3', 'pending');
INSERT INTO `adase1db`.`Applicant_Applies_For_Property` (`Applicant_ssn`, `Property_propertyID`,  `applicationStatus`) VALUES ('334567894', '4', 'pending');
INSERT INTO `adase1db`.`Applicant_Applies_For_Property` (`Applicant_ssn`, `Property_propertyID`,  `applicationStatus`) VALUES ('334567895', '5', 'pending');


INSERT INTO `adase1db`.`Applicant` (`ssn`, `l_name`, `m_name`, `creditScore`, `address`, `moveDate`, `phoneNumber`, `employer`, `jobTitle`, `salary`, `f_name`) VALUES ('334567891', 'Davis', 'A', '650', '10 app rd', '01/01/2000', '55555555', 'Target', 'Manager', '75000', 'Jef');
INSERT INTO `adase1db`.`Applicant` (`ssn`, `l_name`, `m_name`, `creditScore`, `address`, `moveDate`, `phoneNumber`, `employer`, `jobTitle`, `salary`, `f_name`) VALUES ('334567892', 'Smith', 'A', '700', '9 app rd', '01/01/2001', '55555551', 'Wallmart', 'Manager', '75000', 'Jane');
INSERT INTO `adase1db`.`Applicant` (`ssn`, `l_name`, `m_name`, `creditScore`, `address`, `moveDate`, `phoneNumber`, `employer`, `jobTitle`, `salary`, `f_name`) VALUES ('334567893', 'Doe', 'A', '720', '8 app rd', '01/01/2002', '55555552', 'Sears', 'Manager', '75000', 'Tom');
INSERT INTO `adase1db`.`Applicant` (`ssn`, `l_name`, `m_name`, `creditScore`, `address`, `moveDate`, `phoneNumber`, `employer`, `jobTitle`, `salary`, `f_name`) VALUES ('334567894', 'Booth', 'A', '740', '7 app rd', '01/01/2003', '55555553', 'Giant', 'CEO', '10000', 'Tina');
INSERT INTO `adase1db`.`Applicant` (`ssn`, `l_name`, `m_name`, `creditScore`, `address`, `moveDate`, `phoneNumber`, `employer`, `jobTitle`, `salary`, `f_name`) VALUES ('334567895', 'David', 'A', '650', '12 app rd', '01/01/2004', '55555554', 'Target', 'Manager', '75000', 'Alex');


INSERT INTO `adase1db`.`Dependent` (`depId`, `f_name`, `m_name`, `l_name`, `birthDate`) VALUES ('1', 'Alex', 'D', 'Smith', '2000-01-01 00:00:00');
INSERT INTO `adase1db`.`Dependent` (`depId`, `f_name`, `m_name`, `l_name`, `birthDate`) VALUES ('2', 'Jane', 'D', 'Routh', '2001-01-01 00:00:00');
INSERT INTO `adase1db`.`Dependent` (`depId`, `f_name`, `m_name`, `l_name`, `birthDate`) VALUES ('3', 'John', 'D', 'Davis', '2002-01-01 00:00:00');
INSERT INTO `adase1db`.`Dependent` (`depId`, `f_name`, `m_name`, `l_name`, `birthDate`) VALUES ('4', 'Ruth', 'D', 'Doe', '2003-01-01 00:00:00');


INSERT INTO `adase1db`.`Dependent_lives_with_Tennant` (`Dependent_depId`, `Tennant_ssn`) VALUES ('1', '423456789');
INSERT INTO `adase1db`.`Dependent_lives_with_Tennant` (`Dependent_depId`, `Tennant_ssn`) VALUES ('2', '423456788');
INSERT INTO `adase1db`.`Dependent_lives_with_Tennant` (`Dependent_depId`, `Tennant_ssn`) VALUES ('3', '423456787');
INSERT INTO `adase1db`.`Dependent_lives_with_Tennant` (`Dependent_depId`, `Tennant_ssn`) VALUES ('4', '423456786');


INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("161111140","Lamar","Ryder","Roy",96563,"8957490427"),("161801230","Indigo","Drew","Maynard",52989,"0952318608"),("168812129","Kato","Deacon","Moore",39467,"7404142168"),("167403046","Quyn","Kennedy","Padilla",28448,"0118751107"),("165006013","Casey","Quintessa","Howe",25592,"7690587746"),("163004242","Abel","Zephania","Pratt",43603,"5801643747"),("169903069","Drake","Jael","Ellis",25759,"0212626603"),("166310209","Todd","Maggy","Branch",45646,"6222832745"),("168507293","Sonya","Timothy","Kirk",72529,"0883020368"),("166310155","Stella","Zia","Fulton",93819,"7343365530");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("163809119","Bruce","Dorothy","Miles",81221,"5404544633"),("163304062","Mohammad","Uriah","Estrada",43835,"4552971757"),("165009041","Lester","Astra","Lindsey",32929,"8353076077"),("166402016","Acton","Amelia","Marshall",33065,"3154599989"),("163809176","Lars","Warren","Hunt",60081,"6241126984"),("169809155","Gemma","Lavinia","Baxter",90720,"5142707829"),("164111274","Illana","Mark","Duncan",59236,"6306153295"),("166012252","Vielka","Jerome","West",77838,"7003039915"),("167811033","Clare","Elliott","Dodson",46803,"8567354097"),("168307239","Burke","Ashton","Jennings",85169,"1770609269");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("168907023","Melanie","Ryan","Sexton",62485,"2256427845"),("164702040","Tatiana","Jayme","Britt",28277,"4064220640"),("165004303","Lani","Abel","Shaffer",77381,"8935404085"),("165702204","Kevin","Eliana","Roy",27374,"8918729131"),("164903187","Leroy","Aspen","Bates",68580,"6195608164"),("160709308","Kamal","Odessa","Charles",59252,"8850712152"),("161109280","Stacey","Noelani","Woodard",92700,"4925494231"),("163209279","Armando","Dalton","Albert",21382,"7617545535"),("162708106","Boris","Kirsten","Mosley",37238,"5891997810"),("161302254","Xerxes","Quail","Adams",78530,"2124776778");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("165904082","Madeline","Giacomo","Bird",46998,"1951168910"),("164706154","Xavier","Orla","Swanson",69303,"9203670406"),("162101110","Willow","Martha","Klein",56949,"3970747580"),("161805224","Uma","Summer","Booker",28855,"7582451605"),("164009305","Channing","Adara","Bates",64358,"1682341845"),("169012220","Jacob","Cassidy","Petty",49776,"4284331960"),("169202057","Courtney","Ivory","Stephens",63457,"7257251660"),("165611166","Jerome","Odysseus","Kinney",33307,"6382789930"),("168509165","Aaron","Tobias","Bradford",70292,"1894856429"),("161201261","Rhiannon","Jonah","Lara",48095,"5069538986");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("161509192","Sybill","Dylan","Ewing",37417,"0971700497"),("168103256","Solomon","Marshall","Rojas",28823,"7353822381"),("162710270","Aurora","Ainsley","Delacruz",97900,"4321903894"),("167303049","Wylie","Elvis","Camacho",28430,"8683057138"),("164602018","Hedda","Aristotle","Jimenez",74293,"3978593480"),("167610291","Melanie","Justin","Franco",68801,"9181292488"),("168704286","Xanthus","Ava","Donaldson",45529,"9866700288"),("165205277","Nathaniel","Iola","Fitzpatrick",76316,"0474614633"),("163802148","Clayton","Harlan","Baxter",50694,"6764369450"),("168406243","Ashely","Xyla","Riddle",87440,"7587258256");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("168403244","Brett","Fredericka","Oneil",24818,"7793236027"),("165612083","Sharon","Macy","Berg",36556,"4155791015"),("165001150","Sydnee","Illana","Velez",61315,"4948616306"),("164202186","Kalia","Diana","Bentley",77603,"4861383082"),("166809177","Charissa","Walker","Dyer",89621,"6522891519"),("168404277","Damian","Malachi","Brady",68208,"9162504432"),("169211288","Evelyn","Davis","Moran",98700,"6016200410"),("166910108","Gwendolyn","Aline","Harmon",62426,"7748928869"),("168003221","Duncan","Eaton","Tate",65308,"8758486825"),("165603077","Dominique","Vivian","Molina",98834,"1096139701");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("165711084","Daryl","Kiona","Mcgee",58163,"2696557788"),("167202245","Boris","Keegan","Dixon",83356,"3223819293"),("164409213","Cynthia","Wyatt","Valentine",51384,"3411740637"),("161303278","Gavin","Madison","Mays",61793,"9991442972"),("163101210","Ignatius","Jelani","Bell",40051,"0901932004"),("164002205","Meredith","Murphy","Velez",79404,"8283395758"),("169409172","Joshua","Pandora","Graham",98100,"5842905359"),("169807251","Quamar","Selma","Lyons",31367,"8189444707"),("164504022","Mira","Faith","Orr",96248,"7572890272"),("165106151","Neil","Matthew","Cunningham",73507,"6958219116");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("164306125","Kelsey","Rose","Howard",77611,"3819267968"),("162306191","Cooper","John","Joyce",26388,"3163516780"),("168906011","Drew","Marah","Mcclain",20210,"3950004019"),("161412167","Summer","Mason","Shields",84016,"2256178623"),("166312289","Ciaran","Halla","Pearson",91487,"8670667399"),("160106109","Cameron","Lev","Foreman",84420,"7381282892"),("166612263","Helen","Yvette","Cruz",30426,"7917219146"),("165404259","Dana","Zena","Mcdowell",45029,"2792755747"),("164801281","Zachary","Eve","Leblanc",83745,"4112181554"),("162903296","Amir","Xavier","Grant",43307,"5892905449");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("167107212","Deirdre","Florence","Mcneil",71940,"6099922991"),("161204191","Dexter","Raja","Johnston",60219,"2241661554"),("169210120","Fletcher","Burton","Sandoval",35058,"5748502191"),("160602265","Ronan","Leila","Davidson",40259,"7224066129"),("160605019","Doris","Igor","Gross",72583,"3988810214"),("169807238","Hayfa","Katell","Levine",60804,"4968214493"),("161907264","Asher","Ian","Wilson",71648,"0000462047"),("163903070","Carissa","Leo","Moran",51024,"0779112642"),("163707186","Travis","Alan","Mcdonald",77452,"2472457329"),("166101303","Todd","Patience","Rocha",21240,"7151770317");
INSERT INTO `adase1db`.`Employee` (`ssn`,`f_name`,`m_name`,`l_name`,`pay`,`phoneNumber`) VALUES ("164602152","Ima","Wyatt","Whitley",95898,"6756685150"),("161703103","Kaseem","Daniel","Harmon",40975,"4276330592"),("169406099","Blossom","Jolene","Wise",27633,"2091089452"),("160911069","Berk","Vernon","Curry",62920,"7668671364"),("169603279","Dai","Colin","Shepherd",21422,"9756807662"),("169308189","Xenos","Hector","Ruiz",22558,"6220299480"),("165008089","Raja","Teagan","Le",62007,"4082159084"),("168406045","Nolan","Wynter","Alvarez",64887,"8142508742"),("163909117","Bell","Stella","Savage",61962,"5155799142"),("161902130","Hope","Jonah","Shields",63310,"9432429811");



INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('1', '161111140');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('2', '163809119');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('3', '168907023');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('4', '165904082');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('5', '161509192');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('6', '168403244');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('7', '165711084');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('8', '164306125');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('9', '167107212');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('1', '164602152');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('2', '161801230');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('3', '163304062');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('4', '164702040');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('5', '164706154');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('6', '168103256');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('7', '165612083');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('8', '167202245');
INSERT INTO `adase1db`.`Employee_Works_At_Property` (`Property_propertyID`,  `Employee_ssn`) VALUES ('9', '162306191');




INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('1', '1', 'Property Managment Fee');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('2', '1', 'Gas & Electric');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('3', '1', 'Water');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('4', '1', 'Landscaping');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('5', '1', 'Property Taxes');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('6', '1', 'Insurance');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('7', '1', 'Rental License');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('8', '1', 'P.O. Box');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('9', '2', 'Contractor');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('10', '2', 'Plumber');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('11', '2', 'Electrician');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('12', '2', 'Painter');
INSERT INTO `adase1db`.`Expense` (`expenseId`, `cost`, `expense`) VALUES ('13', '2', 'Handyman');

-- NOTE ** THe Cost column is really a 'factor constant' to be used in calculation
-- For example: all fixed costs factor's are 1 so they do not change

INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('1', '1', '1');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('2', '2', '2');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('3', '3', '3');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('4', '4', '4');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('2', '5', '5');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('3', '6', '6');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('4', '7', '7');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('3', '8', '8');
INSERT INTO `adase1db`.`Property_has_Amenity` (`Amenity_amenityid`, `Property_propertyID`, `Porporty_amenityid`) VALUES ('4', '9', '9');


INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('1', '1', '1');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('2', '2', '2');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('3', '3', '3');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('4', '4', '4');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('1', '5', '5');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('2', '6', '6');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('3', '7', '7');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('4', '8', '8');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('1', '9', '9');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('2', '1', '10');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('3', '2', '11');
INSERT INTO `adase1db`.`Property_has_Expense` (`Expense_expenseId`, `Property_propertyID`, `Property_ExpenseID`) VALUES ('4', '3', '12');



INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('1', 'Yes', 'Yes', 'Yes', 'Yes', '3', 'townhome', '123456789', 'Yes', 'free', '8', '12345', '1 Circle Rd', 'Towson', 'MD', '1', '123456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('2', 'Yes', 'Yes', 'No', 'Yes', '2', 'semi-detached', '223456789', 'No', 'free', '7', '22345', '2 Square Dr', 'Baltimore', 'MD', '1', '223456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('3', 'Yes', 'No', 'No', 'Yes', '1', 'single family', '323456789', 'No', 'paid', '4', '32345', '1 Triangle ln', 'Towson', 'MD', '1', '323456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('4', 'Yes', 'No', 'Yes', 'Yes', '5', 'single family', '423456789', 'Yes', 'paid', '10', '52345', '3 Circle Rd', 'Baltimore', 'MD', '1', '423456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('5', 'Yes', 'Yes', 'Yes', 'Yes', '5', 'semi-detached', '533456789', 'Yes', 'free', '9', '42345', '4 Square Dr', 'College Park', 'MD', '1', '523456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('6', 'No', 'Yes', 'Yes', 'Yes', '3', 'townhome', '633456789', 'Yes', 'free', '6', '62345', '5 Circle Rd', 'Baltimore', 'MD', '1', '623456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('7', 'No', 'No', 'No', 'Yes', '3', 'townhome', '733456789', 'Yes', 'free', '7', '72345', '6 Square Dr', 'Baltimore', 'MD', '1', '723456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('8', 'No', 'No', 'No', 'No', '3', 'semi-detached', '833456789', 'No', 'free', '8', '82345', '9 Triangle ln', 'Baltimore', 'MD', '1', '823456789');
INSERT INTO `adase1db`.`Property` (`propertyID`, `deckOrPatio`, `washer`, `dryer`, `offStreetParking`, `numberOfBaths`, `buildingType`, `phoneNumber`, `basement`, `parkingType`, `numOfRooms`, `zipCode`, `streetAddress`, `city`, `state`, `numOfTennants`, `Tennant_ssn`) VALUES ('9', 'No', 'Yes', 'Yes', 'Yes', '3', 'single family', '933456789', 'Yes', 'free', '7', '92345', '10 Hex St', 'Baltimore', 'MD', '1', '923456789');



INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('1', '1', '1');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('2', '2', '2');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('3', '3', '3');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('4', '4', '4');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('5', '1', '4');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('6', '2', '5');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('7', '3', '6');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('8', '1', '7');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('9', '2', '8');
INSERT INTO `adase1db`.`Property_Needs_Repair` (`Property_RepairID`, `Repair_repairId`, `Property_propertyID`) VALUES ('10', '1', '2');



INSERT INTO `adase1db`.`Repair` (`repairId`, `cost`, `effectedArea`, `vendor`) VALUES ('1', '7000', 'yard', 'county');
INSERT INTO `adase1db`.`Repair` (`repairId`, `cost`, `effectedArea`, `vendor`) VALUES ('2', '10', 'mailbox', 'lowes');
INSERT INTO `adase1db`.`Repair` (`repairId`, `cost`, `effectedArea`, `vendor`) VALUES ('3', '100', 'garage-door', 'lowes');
INSERT INTO `adase1db`.`Repair` (`repairId`, `cost`, `effectedArea`, `vendor`) VALUES ('4', '5000', 'concrete', 'BIG');



INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('123456789', '12345', '1 test rd', 'Towson', 'MD', '123456789', 'Alex', 'A', 'Smith');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('223456789', '22345', '3 test rd', 'Towson', 'MD', '123456781', 'Jeff', 'B', 'Smithers');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('323456789', '32345', '4 test rd', 'Towson', 'MD', '123456782', 'Ruth', 'C', 'Smithy');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('423456789', '42345', '5 test rd', 'Towson', 'MD', '123456783', 'John', 'D', 'Smiths');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('523456789', '52345', '1 circle rd', 'Towson', 'MD', '123456784', 'Beth', 'E', 'Smmither');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('623456789', '62345', '2 circle rd', 'Towson', 'MD', '123456785', 'Alice', 'F', 'Doe');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('723456789', '72345', '3 circle rd', 'Towson', 'MD', '123456786', 'Janice', 'G', 'Doese');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('823456789', '82345', '4 circle rd', 'Towson', 'MD', '123456787', 'Tom', 'H', 'Dough');
INSERT INTO `adase1db`.`Seller` (`ssn`, `zipCode`, `streetAddress`, `city`, `State`, `phoneNumber`, `f_name`, `m_name`, `l_name`) VALUES ('923456789', '92345', '5 circle rd', 'Towson', 'MD', '123456788', 'Adam', 'I', 'Don');




INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('123456789', '1',  '500000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('223456789', '2',  '600000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('323456789', '3',  '700000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('423456789', '4',  '800000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('523456789', '5',  '900000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('623456789', '6',  '1000000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('723456789', '7',  '900000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('823456789', '8',  '800000');
INSERT INTO `adase1db`.`Seller_Sells_Property` (`Seller_ssn`, `Property_propertyID`,  `price`) VALUES ('923456789', '9',  '700000');



INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456789', 'Tom', 'T', 'Smith', '1990-01-01 00:00:00', '55555522', 'Yes', 'Yes', 'Yes', '700', '2018-01-01 00:00:00');
INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456788', 'Jeff', 'T', 'Doe', '1990-01-01 00:00:00', '55555533', 'Yes', 'Yes', 'Yes', '750', '2018-01-02 00:00:00');
INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456787', 'Alex', 'T', 'Smith', '1990-01-01 00:00:00', '55555544', 'Yes', 'Yes', 'Yes', '800', '2018-01-03 00:00:00');
INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456786', 'John', 'T', 'Doe', '1990-01-01 00:00:00', '55555555', 'Yes', 'Yes', 'Yes', '850', '2018-02-01 00:00:00');
INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456785', 'Jane', 'T', 'Davis', '1990-01-01 00:00:00', '55555566', 'No', 'Yes', 'Yes', '900', '2018-02-01 00:00:00');
INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456784', 'Julie', 'T', 'Doe', '1990-01-01 00:00:00', '55555577', 'Yes', 'Yes', 'Yes', '1000', '2018-03-01 00:00:00');
INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456783', 'Tina', 'T', 'Smithers', '1990-01-01 00:00:00', '55555588', 'No', 'Yes', 'Yes', '1100', '2018-04-01 00:00:00');
INSERT INTO `adase1db`.`Tennant` (`ssn`, `f_name`, `m_name`, `l_name`, `birthdate`, `phoneNumber`, `car`, `workStatus`, `rentersInsurance`, `rent`, `leaseEndDate`) VALUES ('423456782', 'Sam', 'T', 'Smithy', '1990-01-01 00:00:00', '55555599', 'No', 'No', 'Yes', '1200', '2018-05-01 00:00:00');
