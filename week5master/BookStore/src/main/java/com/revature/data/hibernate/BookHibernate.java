package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.beans.Customer;
import com.revature.data.BookDAO;
import com.revature.utils.HibernateUtil;

public class BookHibernate implements BookDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int addBook(Book b) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		Integer id = 0;
		try {
			id = (Integer) s.save(b);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
		} finally {
			s.close();
		}
		return id;
	}

	@Override
	public Book getBook(int i) {
		Session s = hu.getSession();
		Book b = s.get(Book.class, i);
		s.close();
		return b;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Session s = hu.getSession();
		String query = "from Book where isbn10=:isbn or isbn13=:isbn";
		Query<Book> q = s.createQuery(query, Book.class);
		q.setParameter("isbn", isbn);
		return q.uniqueResult();
	}

	@Override
	public Set<Book> getBooks() {
		Session s = hu.getSession();
		String query = "FROM Book";
		Query<Book> q = s.createQuery(query, Book.class);
		List<Book> bookList = q.getResultList();
		Set<Book> bookSet = new HashSet<Book>();
		bookSet.addAll(bookList);
		return bookSet;
	}

	@Override
	public Set<Book> getBooksByAuthor(Author a) {
		Session s = hu.getSession();
		String query = "FROM Book b where :author = some elements(b.authors)";
		Query<Book> q = s.createQuery(query, Book.class);
		q.setParameter("author", a);
		List<Book> bookList = q.getResultList();
		Set<Book> bookSet = new HashSet<Book>();
		bookSet.addAll(bookList);
		return bookSet;
	}

	@Override
	public Set<Book> getReadingList(Customer c) {
		// this is so terrible
		return c.getReadingList();
	}

	@Override
	public void updateBook(Book b) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		s.update(b);
		t.commit();
		s.close();
	}

	@Override
	public void deleteBook(Book b) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		s.delete(b);
		t.commit();
		s.close();
	}
}
