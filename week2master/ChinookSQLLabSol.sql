-- SQL Queries
-- 2.1 SELECT
SELECT * from Employee;
SELECT * from Employee where LASTNAME = 'King';
SELECT * from Employee where FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
SELECT * from Album ORDER BY Title;
SELECT FIRSTNAME from Customer ORDER BY CITY ASC;

-- 2.3 INSERT INTO
INSERT INTO Genre VALUES ('26', 'Utaite');
INSERT INTO Genre VALUES ('27', 'Anime');
INSERT INTO Employee VALUES ('9', 'Koo', 'Colin', 'Food Stocker', NULL, '14-JUN-95', '27-Nov-18', '1111 Allgeyer Ave', 'El Monte', 'California', 'United States', '11111', '+1 (626) 111-1111', '+1 (626) 111-1111', 'colin@mail.com');
INSERT INTO Employee VALUES ('10', 'Tty', 'Jinny', 'Food Eater', NULL, '14-JUN-95', '27-Nov-18', '1111 Allgeyer Ave', 'El Monte', 'California', 'United States', '11111', '+1 (626) 111-1111', '+1 (626) 111-1111', 'jinny@mail.com');
INSERT INTO Customer VALUES ('60', 'Haiji', 'Maho', 'Clerical', '1111 Allgeyer Ave', 'El Monte', 'California', 'United States', '11111', '+1 (626) 111-1111', '+1 (626) 111-1111', 'maho@mail.com', 1);
INSERT INTO Customer VALUES ('61', 'Nanashi', 'Minami', 'Photographer', '1111 Allgeyer Ave', 'El Monte', 'California', 'United States', '11111', '+1 (626) 111-1111', '+1 (626) 111-1111', 'minami@mail.com', 1);

-- 2.4 UPDATE
UPDATE Customer SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
UPDATE Artist SET Artist.name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
SELECT * FROM INVOICE WHERE Invoice.billingaddress LIKE 'T%';

-- 2.6 BETWEEN
SELECT * FROM INVOICE WHERE total BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE EMPLOYEE.HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
DELETE FROM INVOICELINE WHERE INVOICELINE.INVOICEID IN 
    (SELECT INVOICEID FROM INVOICE WHERE INVOICE.CUSTOMERID = 
        (SELECT CUSTOMER.CUSTOMERID FROM CUSTOMER 
            WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
DELETE FROM INVOICE WHERE INVOICE.CUSTOMERID = 
    (SELECT CUSTOMER.CUSTOMERID FROM CUSTOMER 
        WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');   
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- SQL Functions
-- 3.1 System Defined Functions
SELECT systimestamp from dual;
SELECT length(name) from MEDIATYPE WHERE MEDIATYPEID = 1;

-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
SELECT AVG(TOTAL) FROM INVOICE;
SELECT MAX(UNITPRICE) FROM TRACK;

-- 3.3 USER DEFINED SCALAR FUNCTIONS
    --Function returns a table with the same size as INVOICELINE
    --and populated with the average value.
create or replace function averagePrice 
(average in number)
return number
is
price number(6,2);
itemCount number(5,0);
somenum number(6,2);
begin
    SELECT SUM(UNITPRICE) INTO price FROM INVOICELINE;
    SELECT COUNT(TRACKID) INTO itemCount FROM INVOICELINE;
    return round(price/itemCount, 2);
end averagePrice;
/
select averagePrice(0) AS "Invoiceline Item Average Price" from dual;

-- 3.4 User Defined Table Value Functions
-- Task – Create a function that returns all employees who are born after 1968.
create or replace function post1968
(x in number)
return date
is
after1968 date;
resolveDate date;
begin
    for c in (SELECT BIRTHDATE INTO after1968 FROM EMPLOYEE 
        WHERE BIRTHDATE > to_date('01-Jan-68'))
        loop
            after1968 := c.birthdate;
        end loop;
--    SELECT BIRTHDATE INTO after1968 FROM EMPLOYEE 
--        WHERE BIRTHDATE > to_date('01-Jan-68');
    return after1968;
end;
/
Select post1968(0) from dual;
SELECT BIRTHDATE FROM EMPLOYEE 
    WHERE BIRTHDATE > to_date('01-Jan-68');
    

--CREATE OR REPLACE FUNCTION after1968(registry in number)
--RETURN CURSOR
--IS
--    CURSOR birthTable is SELECT BIRTHDATE FROM EMPLOYEE 
--        WHERE BIRTHDATE > to_date('01-Jan-68');
--BEGIN
--    open birthTable;
--        return birthTable;
--    close birthTable;
--END;
--/
CREATE OR REPLACE type t_birthdates as object(
    i number
);
/
CREATE OR REPLACE type t_table as table of t_birthdates;
/
CREATE OR REPLACE FUNCTION return_birthdates
RETURN t_birthdates 
AS v_ret t_table;
BEGIN
    v_ret := t_table();
    for c in (SELECT BIRTHDATE INTO after1968 FROM EMPLOYEE 
        WHERE BIRTHDATE > to_date('01-Jan-68'))
    loop
        v_ret.extend;
        v_ret(v_ret.count) := t_birthdates(c.birthdate);
    end loop;
    return v_ret;
END;
/

-- working  use BULK COLLECTION INSTEAD?
-- https://stackoverflow.com/questions/4749650/function-that-would-return-the-data-retrieved-from-a-select-query-oracle
CREATE OR REPLACE FUNCTION get_after1968(x in number)
RETURN sys_refcursor 
AS 
ret_cur sys_refcursor;
BEGIN
    open ret_cur for SELECT BIRTHDATE FROM EMPLOYEE 
        WHERE BIRTHDATE > to_date('01-Jan-68');
    return ret_cur;
END;
/
select get_after1968(0) from dual;


-- 4.0 Stored Procedures
-- 4.1 Basic Stored Procedure
--???
CREATE OR REPLACE PROCEDURE emp_names
AS
    c1 SYS_REFCURSOR;
BEGIN
    OPEN c1 for
    SELECT firstname, lastname FROM employee;
END;
/
EXECUTE emp_names;

--working 4.1
--https://dba.stackexchange.com/questions/182233/writing-a-simple-select-stored-procedure-in-oracle-pl-sql
CREATE OR REPLACE PROCEDURE emp_names(names out SYS_REFCURSOR)
AS
BEGIN
    OPEN names FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END emp_names;
/
variable mycursor refcursor;
exec emp_names(:mycursor);
print mycursor;

-- 4.2 Stored Procedure Input Paramters
CREATE OR REPLACE PROCEDURE update_emp(emp_id in number, first in varchar2, last in varchar2)
AS
BEGIN
    UPDATE EMPLOYEE SET FIRSTNAME = first, LASTNAME = last 
        WHERE employeeid = emp_id;
    commit;    
END;
/
select * from employee;
EXECUTE update_emp(1, 'NotAdam', 'NotAndrew');

CREATE OR REPLACE PROCEDURE get_managers(emp_id in number, manager out SYS_REFCURSOR)
AS
BEGIN
    open manager for 
        SELECT emp.firstname AS "Employee", man.firstname AS "Manager" from EMPLOYEE emp join EMPLOYEE man on
            emp.reportsto = man.employeeid where emp.employeeid = emp_id;
END get_managers;
/
variable man_cursor refcursor;
exec get_managers(2, :man_cursor);
print man_cursor;

SELECT emp.firstname, man.firstname, emp.employeeid from EMPLOYEE emp join EMPLOYEE man on
    emp.reportsto = man.employeeid where emp.employeeid = 2;

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE name_company(cust in number, name_company out sys_refcursor)
AS
BEGIN
    OPEN name_company FOR SELECT customer.firstname, customer.lastname, customer.company FROM CUSTOMER 
        WHERE customer.customerid = cust;
END name_company;
/
select * from customer;
variable name_companycursor refcursor;
exec name_company(1, :name_companycursor);
print name_companycursor;

-- 5.0 Transactions
-- Task – Create a transaction that given a invoiceId will delete that invoice 
-- (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice(inv_Id in number)
AS
invoice_id number(4);
BEGIN
    SELECT invoiceid INTO invoice_id FROM INVOICE WHERE inv_Id = invoiceId;
    if SQL%FOUND THEN
        DELETE FROM INVOICELINE WHERE INVOICELINE.INVOICEID = inv_Id;
        DELETE FROM INVOICE WHERE invoiceid = inv_Id;
        commit;
    ELSIF SQL%NOTFOUND THEN    
        dbms_output.put_line('No data found.');
    END IF;
END deleteInvoice;
/
--2240
select invoice.invoiceid, invoicelineid from invoiceline join invoice on invoiceline.invoiceid = invoice.invoiceid ORDER BY invoiceid DESC;
select count(invoicelineid) from invoiceline;
--2226 after
exec deleteInvoice(411);

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--to test
CREATE OR REPLACE PROCEDURE insertToCustomer(fname in varchar2, lname in varchar2, mail in varchar2)
AS
id number(3);
BEGIN
    set transaction name 'insertCustomer';
        SELECT COUNT(customerid)+1 INTO id FROM CUSTOMER;
        INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (id, fname, lname, mail);
    commit;
END insertToCustomer;
/
exec insertToCustomer('Colin', 'Koo', 'chkoo@cpp.edu');
select * from customer;

-- 6.0 Triggers
-- 6.1 Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER emp_insert_trig
after insert on EMPLOYEE
begin
    dbms_output.put_line('Fired');
end;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER emp_update_trig
after update OR insert on ALBUM
begin
    dbms_output.put_line('Fired2');
end;
/

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER emp_delete_trig
after delete on CUSTOMER
begin
    dbms_output.put_line('Fired3');
end;
/

-- 7.0 Joins
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM CUSTOMER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CustomerId, firstname, lastname, invoice.invoiceId, total FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE FROM ALBUM RIGHT JOIN ARTIST ON ALBUM.Artistid = ARTIST.ArtistID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select artist.name AS "Artist" from album, artist order by artist.name asc;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select emp.FIRSTNAME, man.FIRSTNAME from employee emp join employee man on emp.reportsto = man.employeeid;
