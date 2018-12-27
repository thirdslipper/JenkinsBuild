create table bear (
bear_id number primary key,
cave_id number,
honeypot_id number,
bear_color varchar2(25),
breed varchar2(25),
weight number(6,2),
height number(6,2)
);

create table cave_id (
cave_id_id number primary key,
sq_footage number(6,2),
caveType varchar2(25)
);

create table honey_pot(
honeypot_id number primary key,
volume number(10,2),
honeyAmount number(10,2)
);

create table parent_cub (
parent_id number,
cub_id number
);

create sequence honeypotid_seq;
create sequence bearid_seq;
create sequence caveid_seq;


insert into bear (bear_id, cave_id, honeypot_id, bear_color, breed, height, weight)
select bearid_seq.nextVal, 1, 1, 'brown', 'kodiak', 1, 50 from dual;

insert into cave_id (cave_id_id, sq_footage, cavetype)
    select caveid_seq.nextVal, 4, 'Dark' from dual;

insert into honey_pot (honeypot_id, volume, honeyamount)
    select honeypotid_seq.nextVal, 706, 607 from dual;
    
commit;