insert into customer (id, username, pswd) values (1, 'colin1', 'koo');
insert into customer (id, username, pswd) values (1, 'colin2', 'koo');
insert into customer (id, username, pswd) values (1, 'colin3', 'koo');
insert into customer (id, username, pswd) values (1, 'colin4', 'koo');
insert into customer (id, username, pswd) values (1, 'colin5', 'koo');

select address_seq from dual;

insert into address(id, lineone, city, state, zip)
    values (1, 'a', 'morgantown', 'wv', '12345');
insert into address(id, lineone, city, state, zip) 
    values (1, 'b', 'morgantown', 'wv', '12345');    
insert into address(id, lineone, city, state, zip) 
    values (1, 'c', 'morgantown', 'wv', '12345');    
insert into address(id, lineone, city, state, zip) 
    values (1, 'd', 'morgantown', 'wv', '12345');    
insert into address(id, lineone, city, state, zip) 
    values (1, 'e', 'morgantown', 'wv', '12345');    

select * from customer natural join address;

insert into accounts values (1, 100, 'checking');
insert into accounts values (1, 100, 'checking');
insert into accounts values (1, 100, 'checking');
insert into accounts values (1, 100, 'savings');
insert into accounts values (1, 100, 'savings');
insert into accounts values (1, 100, 'savings');
insert into accounts values (1, 100, 'savings');
insert into accounts values (1, 100, 'checking');

select * from accounts;
insert into customer_acc_bridge values (1, 1);
insert into customer_acc_bridge values (2, 2);
insert into customer_acc_bridge values (3, 3);
insert into customer_acc_bridge values (4, 4);
insert into customer_acc_bridge values (5, 5);
insert into customer_acc_bridge values (5, 6);
insert into customer_acc_bridge values (5, 7);
insert into customer_acc_bridge values (4, 7);


select * from customer_acc_bridge;

--ALTER TABLE emp_acc_bridge RENAME TO customer_acc_bridge;

select username, customer.id, lineone from customer 
    join address on customer.id = address.id join customer_acc_bridge 
    on customer.id = customer_acc_bridge.user_id;
    
insert into employees values (5, 'admin');
insert into employees values (5, 'employee');
insert into employees values (4, 'employee');
select * from employees;

insert into pending_accounts values (8);

select * from pending_accounts;

insert into joint_accounts values (8, 1, 2);

select * from joint_accounts;