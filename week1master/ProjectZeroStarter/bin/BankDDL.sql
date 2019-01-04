drop table accounts cascade constraints;
drop table address cascade constraints;
drop table employees cascade constraints;
drop table customer cascade constraints;
drop table emp_acc_bridge cascade constraints;
drop table pending_accounts cascade constraints;
drop table joint_accounts cascade constraints;

select * from customer;
select * from address;
drop sequence customer_seq;
drop sequence accounts_seq;
drop sequence address_seq;
CREATE SEQUENCE customer_seq;
CREATE SEQUENCE accounts_seq;
CREATE SEQUENCE address_seq;

create table address (
    id number(10) primary key,
    lineone varchar2(100) not null,
    linetwo varchar2(100),
    city varchar2(100) not null,
    state varchar2(3) not null,
    zip varchar2(10) not null
);
create table customer (
    id number(10) primary key,
    first_name varchar2(15),
    last_name varchar2(15),
    email varchar2(30),
    phone varchar2(12),
    address_id number(10),
    username varchar2(15) not null,
    pswd varchar2(15) not null,
    constraint fk_add_id foreign key (address_id) references address(id)
);

--employee, admin
create table employees (
    id number(10),
    role varchar2(10) not null,
    constraint fk_emp_id foreign key (id) references customer(id)
);

create table accounts (
    id number(10) primary key, 
    balance number(12, 2), 
    type varchar2(8)
);

create table pending_accounts (
    acc_id number(10) primary key,
    constraint fk_acc_id foreign key (acc_id) references accounts(id)
);

create table emp_acc_bridge (
    user_id number(10),
    acc_id number(10),
    constraint pk_user_acc primary key (user_id, acc_id),
    constraint fk_user_id foreign key (user_id) references customer(id),
    constraint fk_acc_id2 foreign key (acc_id) references accounts(id)
);
    select * from joint_accounts;-- where acc_id = 1;
select * from joint_accounts;

create table joint_accounts (
    acc_id number(10),
    user_id number(10),
    other_user_id number(10),
    constraint fk_joint_acc foreign key (acc_id) references accounts(id),
    constraint fk_user_id foreign key (user_id) references customer(id),
    constraint fk_other_user_id foreign key (other_user_id) references customer(id)
);

select username, pswd from customer where username = 'colin' AND pswd = 'koo';

create or replace trigger customer_pk_trig
before insert or update on customer
for each row
begin
    if INSERTING then
        select customer_seq.nextVal into :new.id from dual;
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

create or replace trigger acc_pk_trig
before insert or update on accounts
for each row
begin
    if INSERTING then
        select accounts_seq.nextVal into :new.id from dual;
    elsif UPDATING then
        select :old.id into :new.id from dual;
    end if;
end acc_pk_trig;
/

create or replace procedure account_app (acc_id in number, type in varchar2, user_id in number)
as
begin
    insert into accounts (id, balance, type) values (acc_id, type, 100);
    insert into pending_accounts (acc_id) values (acc_id);
    insert into emp_acc_bridge (user_id, acc_id) values (user_id, acc_id);
end account_app;
/

create or replace function update_balance (amount in number, accid in number)
return number
is
    new_balance number(11);
begin
    select balance into new_balance from account where acc_id = accid;
    return new_balance+amount;
end update_balance;
/
create or replace procedure withdraw (amount in number, accid in number)
as 
    current_bal number(11);
begin
    set transaction name 'customer_withdraw';
    select balance into current_bal from accounts where id = accid;
        IF (current_bal >= amount) THEN
            current_bal := current_bal - amount;
            update accounts set balance = current_bal where id = accid;
            commit;
        END IF;
end withdraw;
/
create or replace procedure deposit (amount in number, accid in number)
as 
    current_bal number(11);
begin
    set transaction name 'customer_deposit';
    select balance into current_bal from accounts where id = accid;
        IF (amount > 0) THEN
            current_bal := current_bal + amount;
            update accounts set balance = current_bal where id = accid;
            commit;
        END IF;
end deposit;
/
create or replace procedure transfer (amount in number, accid in number, otheraccid in number)
as 
    current_bal number(11);
    other_current_bal number(11);
begin
    set transaction name 'customer_transfer';
    select balance into current_bal from accounts where id = accid;
    select balance into other_current_bal from accounts where id = otheraccid;
    
        IF (current_bal > amount) THEN
            current_bal := current_bal - amount;
            update accounts set balance = current_bal where id = accid;
            other_current_bal := other_current_bal + amount;
            update accounts set balance = other_current_bal where id = otheraccid;
            commit;
        END IF;
end transfer;
/


--create or replace procedure delete_user
----    delete address and employee if match, move joint to indiv acc
--create or replace procedure delete_account
--create or replace procedure account_app
---- seq for acc, joint, pend all the same
--create or replace procedure withdraw
--create or replace procedure deposit
--create or replace procedure transfer
--trigger when account/pend added to user, add to bridge and 