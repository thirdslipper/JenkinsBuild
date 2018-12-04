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

-- let's be unecessarily complicated
select * from (select artist.name, album.title from artist join album using(artistid)) where title = 'Let There Be Rock';