-- DQL - Data Query Language
select * from album;
SELECT * FROM ALBUM;
SeleCT * FRom ALBuM;
-- Is SQL case sensitive?
select 'title' from album; -- single quotes indicate a string
select 'TiTlE' from album;
select title from album where title = 'Big Ones';
select title from album where title = 'Big OnEs';
select title from album;
select "TITLE" from album; -- double quotes indicate an identifier
select "title" from album;

-- DO NOT DO THIS
/*create table "album" (
"albumId" number primary key,
"title" varchar2(16) not null,
artistId number not null);
drop table "album";*/

select title, artistid from album;
select * from album;
select albumid, title, artistid from album;

select * from artist;
select * from artist where artistid = 1;
select * from artist where name like 'Ba%';
select * from artist where name = 'Foo Fighters';
select * from artist where artistid = 84;

-- Nested Query
select albumid, title from album where artistid = (select artistid from artist where name = 'Foo Fighters');

select * from artist join album on artist.artistid = album.artistid;
select name, title from artist join album on artist.artistid = album.artistid;
select * from artist natural join album; -- natural join: A join amongst shared columns
select * from artist join album using (artistid); -- using: specify a shared column to join on

-- let's be unnecessarily complicated
select * from (select artist.name, album.title from artist join album using(artistid)) where title = 'Let There Be Rock';

select artist.name, album.title from artist join album using (artistid) where album.title = 'Let There Be Rock';

--Views: Basically saving a query as a queryable object
create view album_artist as
    (select artist.name, album.title from artist join album using(artistid));
select * from album_artist;

-- intro to functions
/* There are two kinds of functions in SQL
Scalar - functions that operate on a single value
Aggregate - functions that operate on multiple rows and return a single result
*/
-- Scalar
select length(name), name from artist;
select substr(name, 1, 5) from artist;
select concat(name, artistid) from artist;
select systimestamp from dual;

select name from artist where length(name)>6;

-- Aggregate
select count(*) from album; -- count returns number of rows;

select artistid, count(artistid) as "Number of Albums" from album group by artistid;

select name, "Number of Albums" from artist join
    (select artistid, count(artistid) as "Number of Albums" from album group by artistid)
using (artistid);

select name, count(title) as "NumRecords" from 
    (select artist.name, album.title from artist join album using(artistid))
group by name;

select name, count(title) as "NumRecords" from 
    (select artist.name, album.title from artist join album using(artistid))
group by name order by "NumRecords" desc;


/* select all rock tracks and the artist's name */
-- Select all from track table
select * from track;
-- narrow down to the results we want
select name, genreid, albumid from track;
-- join with genre
select track.name as "Track Name", track.albumid as "Album Id", genre.name as "Genre"
    from track join genre using (genreid);
-- Restrict results with a where clause
select track.name as "Track Name", track.albumid as "Album Id", genre.name as "Genre"
    from track join genre using (genreid) where genre.name = 'Rock' or genre.name = 'Rock And Roll';
-- get the artists name!
-- join to album
select "Track Name", album.artistid as "Artist ID" from (select track.name as "Track Name",
    track.albumid as "Album Id", genre.name as "Genre"
    from track join genre using (genreid) where genre.name = 'Rock' or genre.name = 'Rock And Roll')
    join album on album.albumid = "Album Id";
-- join with artist
select "Track Name", artist.name from (select "Track Name", album.artistid as "Artist ID" from (select track.name as "Track Name",
    track.albumid as "Album Id", genre.name as "Genre"
    from track join genre using (genreid) where genre.name = 'Rock' or genre.name = 'Rock And Roll')
    join album on album.albumid = "Album Id")
    join artist on "Artist ID" = artist.artistid order by artist.name asc;
    
/*
    Natural Join - The db attempts to perform an inner join on like columns
    Inner Join - Only matches show up in result set
    Outer Join - Shows everything including rows which have no match in the other table
    Left Outer Join - Shows all results in left table with matching results in right if they exist
    Right Outer Join - Shows all results in right table with matching results in left if they exist
    Cross Join - cartesian product of two tables
    Self Join - Any join where both tables are the same table
*/

-- Self Join
select * from employee;
-- self inner join
select emp.firstname as "Employee", man.firstname as "Manager"
    from employee emp join employee man on emp.reportsto = man.employeeid;
-- self outer join
select emp.firstname as "Employee", man.firstname as "Manager"
    from employee emp full outer join employee man on emp.reportsto = man.employeeid;
-- self right outer join
select emp.firstname as "Employee", man.firstname as "Manager"
    from employee emp right outer join employee man on emp.reportsto = man.employeeid;
-- self left outer join
select emp.firstname as "Employee", man.firstname as "Manager"
    from employee emp left outer join employee man on emp.reportsto = man.employeeid;

-- cross join
select * from artist;
select * from album;
select * from artist, album;
select count(*) from artist; --275
select count(*) from album; --347
select count(*) from artist, album;

-- group by and having
select count(firstname), company from customer group by company;
-- where clause
select count(firstname), company from customer where company='Google Inc.';
--cannot use group function prior to a group by witha  where clause.
select count(firstname), company from customer where count(firstname)>1 group by company;
select count(firstname), company from customer group by company having count(firstname)=1;.

select count(albumid) as "# of Albums", name
    from (select album.albumid, artist.artistid, artist.name
    from album join artist on album.artistid = artist.artistid)
    where artistid>5
    group by name
    having count(albumid) >1
    order by "# of Albums";
-- cannot use having without a group by
select count(albumid) from album where albumid>5;
select count(albumid) from album having albumid>5;


-- Set operations
/*
    Combine result sets. Each resultset to be combined must have the same schema.
    Union - All unique rows in both resultsets (a,b,c) Union (b,c) = (a,b,c)
    Union All - All rows in both resultsets (a,b,c) union all (b,c) = (a,b,c,b,c)
    Intersect - Only rows that are in both resultsets (a,b,c) intersect (b,c) = (b,c)
    Minus - What A has that B doesn't (a,b,c) minus(b,c) = (a)
*/

select * from customer where state = 'CA';
select * from customer where country = 'Brazil';
select * from customer where state = 'CA' union 
    select * from customer where country = 'Brazil';
    
select * from invoiceline where unitprice > .99; --111
select * from invoiceline where trackid <3000; --1961
select * from invoiceline where unitprice >.99 minus select * from invoiceline where trackid <3000;
select * from invoiceline where unitprice >.99 intersect select * from invoiceline where trackid <3000;

select firstname from employee;
select firstname from customer;
select firstname from employee intersect select firstname from customer;
select firstname, lastname from employee intersect select firstname, lastname from customer;

select e.firstname, employee.lastname from (select firstname from employee intersect select firstname from customer) e
    join employee on employee.firstname = e.firstname union
    (select e.firstname, customer.lastname from (select firstname from employee intersect select firstname from customer) e
    join customer on customer.firstname = e.firstname);

select customer.firstname, customer.lastname, employee.firstname, employee.lastname from customer
    join employee on customer.firstname = employee.firstname;