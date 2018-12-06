/* I have three options for my DDL Scripts
    1. I can connect directly to my user and run the DDL.
    2. Connect to another user like SYSTEM, then use the connect
        command to connect to my user and run the DDL.
    3. I can connect to another user and explicitly run the commands
        for the user.
*/
-- 1. Direct Connection
--create table book(
--id number primary key
--);
-- 2. Connect ot system, connect to user, run
--connect bookapp/p4ssw0rd;
--create table book(
--id number primary key
--);
--exit;
-- 3. connection agnostic, explicit tables
--create table bookapp.book(
--id number primary key);
--select 'drop table ' || table_name || ' cascade constraints;' from user_tables;
drop table BOOK cascade constraints;
drop table GENRE cascade constraints;
drop table BOOK_GENRE cascade constraints;
drop table AUTHOR cascade constraints;
drop table BOOK_AUTHOR cascade constraints;
drop table LOGIN cascade constraints;
drop table EMP cascade constraints;
drop table CUSTOMER cascade constraints;
drop table ADDRESS cascade constraints;
drop table TAXRATE cascade constraints;
drop table PURCHASE cascade constraints;
drop table PURCHASE_BOOK cascade constraints;
drop table READING_LIST cascade constraints;
select 'drop sequence ' || sequence_name || ';' from user_sequences;
drop sequence ADDRESS_SEQ;
drop sequence AUTHOR_SEQ;
drop sequence BOOK_SEQ;
drop sequence GENRE_SEQ;
drop sequence LOGIN_SEQ;
drop sequence PURCHASE_SEQ;
-- building the schema
create table book (
    id number(20) primary key,
    isbn10 varchar2(10) unique not null,
    isbn13 varchar2(14) unique,
    title varchar2(256) not null,
    price number(5,2) not null check(price>=0),
    stock number(5) not null,
    cover varchar2(2000) -- url for a picture
);

create table genre (
    id number(10) primary key,
    genre varchar2(256) unique not null
);

create table book_genre (
    book_id number(20),
    genre_id number(10),
    constraint pk_bookgenre primary key (book_id, genre_id),
    constraint fk_bookgenre_book foreign key (book_id) references book(id),
    constraint fk_bookgenre_genre foreign key (genre_id) references genre(id)
);

create table author (
     id number(20) primary key,
     firstname varchar2(50) not null,
     lastname varchar2(50) not null,
     aboutblurb varchar2(1000)
);
create table book_author (
    book_id number(20),
    author_id number(20),
    constraint pk_bookauthor primary key (book_id, author_id),
    constraint fk_bookauthor_book foreign key (book_id) references book(id),
    constraint fk_bookauthor_author foreign key (author_id) references author(id)
);
create table login (
    id number(20) primary key,
    username varchar2(25) unique not null,
    pswd varchar2(25) not null,
    first_name varchar2(50) not null,
    last_name varchar2(50) not null
);
create table emp (
    id number(20) primary key,
    sup_id number(20),
    title varchar2(256),
    constraint fk_sup_emp foreign key (sup_id) references emp(id),
    constraint fk_emp_login foreign key (id) references login(id)
);
create table customer (
    id number(20) primary key,
    address_id number(10) not null,
    constraint fk_customer_login foreign key (id) references login(id)
);

create table address (
    id number(10) primary key,
    lineone varchar2(100) not null,
    linetwo varchar2(100),
    city varchar2(100) not null,
    state varchar2(3) not null,
    zip varchar2(10) not null
);

create table taxrate
(
    state varchar2(3) primary key,
    rate number(5,5) not null
);

create table purchase
(
    id number(20) primary key,
    customer_id number(20),
    total number(7,2) default 0 check (total >=0),
    status varchar2(10),
    constraint fk_purchase_customer foreign key (customer_id) references customer(id)
);

create table purchase_book (
    purchase_id number(20),
    book_id number(20),
    quantity number(10) check (quantity>=0),
    constraint pk_purchase_book primary key(book_id, purchase_id),
    constraint fk_purchasebook_purchase foreign key (purchase_id) references purchase(id),
    constraint fk_purchasebook_book foreign key (book_id) references book(id)
);

create table reading_list
(
  book_id number(13),
  cust_id number(13),
  constraint pk_readinglist primary key(book_id, cust_id),
  constraint fk_readinglist_cust foreign key(cust_id) references customer(id),
  constraint fk_readinglist_book foreign key(book_id) references book(id)
);

-- Add constraints with alter
alter table customer add constraint fk_addressid
    foreign key (address_id) references address(id);


-- Sequences
create sequence book_seq;
create sequence address_seq;
create sequence author_seq;
create sequence login_seq;
create sequence purchase_seq;
create sequence genre_seq;

-- Trigger
-- PLSQL code block that executes when something happens. (before or after)
create or replace trigger author_pk_trig
before insert or update on author
for each row
begin
    if INSERTING then
        select author_seq.nextVal into :new.id from dual;
    elsif UPDATING then
        select :old.id into :new.id from dual;
    end if;
end;
/
create or replace trigger book_pk_trig
before insert or update on book
for each row
begin
    if INSERTING then
        select book_seq.nextVal into :new.id from dual;
    elsif UPDATING then
        select :old.id into :new.id from dual;
    end if;
end;
/
create or replace trigger genre_pk_trig
before insert or update on genre
for each row
begin
    if INSERTING then
        select genre_seq.nextVal into :new.id from dual;
    elsif UPDATING then
        select :old.id into :new.id from dual;
    end if;
end;
/
create or replace trigger login_pk_trig
before insert or update on login
for each row
begin
    if INSERTING then
        select login_seq.nextVal into :new.id from dual;
    elsif UPDATING then
        select :old.id into :new.id from dual;
    end if;
end;
/
create or replace trigger address_pk_trig
before insert or update on address
for each row
begin
    if INSERTING then
        select address_seq.nextVal into :new.id from dual;
    elsif UPDATING then
        select :old.id into :new.id from dual;
    end if;
end;
/
create or replace trigger purchase_pk_trig
before insert or update on purchase
for each row
begin
    if INSERTING then
        select purchase_seq.nextVal into :new.id from dual;
    elsif UPDATING then
        select :old.id into :new.id from dual;
    end if;
end;
/
drop table auditbook cascade constraints;
drop sequence audit_book_seq;
create table auditbook
(
  auditid number(20) primary key,
  audit_time timestamp,
  oldid number(20),
  newid number(20),
  oldisbn10 varchar2(10),
  newisbn10 varchar2(10),
  oldisbn13 varchar2(14),
  newisbn13 varchar2(14),
  oldTitle varchar2(256),
  newtitle varchar2(256),
  oldprice number(5,2),
  newprice number(5,2),
  oldstock number(5),
  newstock number(5),
  oldcover varchar2(2000),
  newcover varchar2(2000)
);
create sequence audit_book_seq;

create or replace trigger audit_book_trig
after update or insert or delete on book
for each row
begin
  insert into auditbook(auditid, oldid, newid, oldisbn10, newisbn10, oldisbn13, newisbn13,
  oldtitle, newtitle, oldprice, newprice, oldstock, newstock, oldcover, newcover,
  audit_time)
  values(audit_book_seq.nextval, :old.id, :new.id, :old.isbn10, :new.isbn10,
  :old.isbn13, :new.isbn13, :old.title, :new.title, :old.price, :new.price,
  :old.stock, :new.stock, :old.cover, :new.cover, systimestamp );
end;
/

-- Custom function
/* Function is a reusable PL/SQL block.
    It takes in parameters (in, out, or inout) (using out or inout inside a function
        is considered bad practice)
    Functions have a return, and therefore can be used inside other statements.
        (select, insert, update, delete)
    Functions can use DQL and call other functions.
*/
create or replace function calculateTax
(book_id in number, cust_id in number)
return number
is --as
-- declare variables for use in the code block
book_price number(10,2);
home_state varchar2(3);
tax_rate number(5,5);
begin
    -- I can run DQL statements in sequence and then return a value.
    select state into home_state from customer join address
        on customer.address_id=address.id where customer.id = cust_id;
    select rate into tax_rate from taxrate where state=home_state;
    select price into book_price from book where id =book_id;
    return book_price * (1+tax_rate);
end;
/