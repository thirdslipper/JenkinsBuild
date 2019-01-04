drop user bear cascade;

create user bear
identified by p4ssw0rd
default tablespace users
temporary tablespace temp
quota 10m on users;

grant connect to bear;
-- The ability to create types
grant resource to bear;
grant create session to bear;
grant create table to bear;
grant create view to bear;