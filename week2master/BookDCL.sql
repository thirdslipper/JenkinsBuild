-- User creation scrip for the BookApp Database
/*
    I like to separate my scripts by use case.
    It lets me run my scripts separately from each other so they can't interfere
    with one another and I can check that each stage has completed correctly.
    I'm just creating the user for my application here.
    Running this script creates a user and grants it priveleges.
*/

-- We want a fresh start. Drop the user.
drop user bookapp cascade;

/* Drop can remove the user "object" from the system.
    We want to run this on the dba user, so SYSTEM Will work
    for this. We don't want to build our schema on our adminstrator.
    */
--create a user in the database
create user bookapp
-- with a password
identified by p4ssw0rd
-- on a tablespace
default tablespace users
-- add a temporary space
temporary tablespace temp
-- with this size
quota 10m on users;

-- We need to be able to connect to another user
grant connect to bookapp;
-- the ability to create types
grant resource to bookapp;
-- the ability to alter and destroy types
-- grant dba to bookapp;
--the ability to create a session for transactions
grant create session to bookapp;
grant create table to bookapp;
grant create view to bookapp;

-- older version of oracle sql required this grant
--grant select, insert, update, delete to bookapp;