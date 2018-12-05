-- Authors
insert into author(id, firstname, lastname, aboutblurb)
    values(1, 'J.K.', 'Rowling', 'One of the richest people in the world.');
insert into author(id, firstname, lastname)
    values(56, 'Robert', 'Jordan');
insert into author(firstname, lastname)
    values('Steven', 'Brust');
insert into author(firstname, lastname) values ('George','Martin');

update author set id=56 where id = 2;

-- Books
insert into book(title, isbn10, isbn13, price, stock)
    values('A Game of Thrones',
  '0553593714',
  '978-0553593716',
  8.79,
  60);
insert into book(id, title, isbn10, isbn13, price, stock)
    values(1, 'The Eye of the World', '0812511816', '978-0812511819', 8.69, 500);
insert into book (id, isbn10, isbn13, title, price, stock)
  values(1,'0590353403','978-0590353403','Harry Potter and the Sorcerer''s Stone',19.82,50);
insert into book (isbn10, isbn13, title, price, stock)
  values('0439064872', '978-0439064873', 'Harry Potter and the Chamber of Secrets', 8.33, 30);

-- We have books. No one has written any books.
select id from author where firstname='J.K.';
insert into book_author (author_id, book_id)
    values((select id from author where firstname='J.K.'),
        (select id from book where title like 'Harry Potter and the S%'));
insert into book_author (author_id, book_id)
    values((select id from author where firstname='J.K.'),
        (select id from book where title like 'Harry Potter and the C%'));
insert into book_author (author_id, book_id)
    values((select id from author where firstname='George' and lastname='Martin'),
    (select id from book where title='A Game of Thrones'));
insert into book_author (author_id, book_id)
    values((select id from author where firstname ='Robert' and lastname='Jordan'),
    (select id from book where title='The Eye of the World'));
    
    
select b.title, author.firstname, author.lastname from (select * from book join book_author
    on book.id=book_author.book_id) b join author on b.author_id=author.id;

commit;