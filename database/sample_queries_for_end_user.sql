SELECT * FROM RealEstate.Property;
/*
--1) Find details of each property located in Baltimore.
*/
Select * from Property where city = 'Baltimore';


/*
--2) Find the list of tenants employed fulltime.
*/
select * from
Tennant
where workStatus = 'Yes';
/*
--3) Find the list of properties that have a PMC.
*/
select * from
Property p, Seller_Sells_Property ssp
where p.propertyID = ssp.Property_propertyID;
/*
--4) Find the number of properties with off street parking.
*/
select count(*)
from Property
where offStreetParking = 'Yes';

/*

--5) Find the list of tenants that do not own a car.
*/
Select * from
Tennant 
where
car = 'No';

/*
--6) Find the properties that have more than one occupant.
*/
select * from 
Property p 
where numOfTennants > 1;


/*
--7) Find the properties that do not have a dish washer.
-- Amenity 1 is dish washer
*/
select p.propertyID from
Property p, Property_has_Amenity pha
where p.propertyID = pha.Property_propertyID
and
pha.Amenity_amenityid = '1';


/*
--8) Find list of tenants that have extended their lease. Beyond one year from now

*/
select * from 
Tennant 
where leaseEndDate > DATE_ADD(SYSDATE(), INTERVAL 1 YEAR)  ;


/*
--9) Find list of applicants that have been approved to rent a property.
*/

select * from Applicant_Applies_For_Property
where applicationStatus = 'Approved';


/*
2) Allow user to generate list of properties, tenants, applicants, expenses, income, etc.
*/
select * from Property;
select * from Tennant;
select * from Applicant;
select * from  Expense;

/*
Find the current monthly expenses
*/
select sum(cost) from Expense e
where e.expenseId in (select Expense_expenseId from Property_has_Expense phe );


/*

3) Generate current income information
*/
Select sum(price) from Seller_Sells_Property;
/*
4) Allow user to generate a list of occupied properties.
*/

select * from Property
where Tennant_ssn IS NOT NULL;

/*
5) Allow user to produce list of applicants with their credit scores whose appliaction is pending
*/
select a.f_name, a.l_name, a.creditScore  from
Applicant a, Applicant_Applies_For_Property aap
where
a.ssn = aap.Applicant_ssn
and aap.applicationStatus = 'Pending';


/*
5) Allow user to produce list of applicants for a particular time period.

using sysdate as sample criteria
*/

select * from
Applicant a, Applicant_Applies_For_Property aap
where
a.ssn = aap.Applicant_ssn
and a.moveDate < SYSDATE();

/* All properties where the tennant also has a dependent */

select p.propertyId 
from Property p
where p.Tennant_ssn in (
select Tennant_ssn from Dependent_lives_with_Tennant
);

/* All employees that work at property and their salary 1 */

select e.f_name, e.l_name, e.pay
from Employee e,
Employee_Works_At_Property ewp
where e.ssn = ewp.Employee_ssn;

/* select the average salary for an employee at eacah property */

select ewp.Property_propertyID, avg(e.pay)
from Employee e,
Employee_Works_At_Property ewp
where e.ssn = ewp.Employee_ssn
group by ewp.Property_propertyID;


/* Calculate operating expanse for all prop  by prop */
select sum(e.cost), phe.Property_propertyID
from Expense e, Property_has_Expense phe
where e.expenseId = phe.Expense_expenseId
group by phe.Property_propertyID;


