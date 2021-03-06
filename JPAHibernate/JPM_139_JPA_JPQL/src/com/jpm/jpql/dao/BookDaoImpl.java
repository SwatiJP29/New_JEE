package com.jpm.jpql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jpm.jpql.entities.Book;
import com.jpm.jpql.util.JPAUtil;

public class BookDaoImpl implements IBookDao{
	//prep -work
	private EntityManager entityManager;
	private Logger logger;
	
	public BookDaoImpl() {
		entityManager = JPAUtil.geEntityManager();
		logger = LoggerFactory.getLogger(BookDaoImpl.class);
	}

	@Override
	public Book getBookById(int id) {
		Book book = entityManager.find(Book.class, id);
		logger.info("Invoked getBookById at BookDaoImpl", book);
		return book;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		String qStr = "SELECT b1 FROM Book b1 WHERE b1.title LIKE :ptitle";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("ptitle", "%"+title+"%");
		return query.getResultList();
	}

	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(b1.id) FROM Book b1";
		TypedQuery<Long> query = entityManager.createQuery(qStr, Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		String qStr = "SELECT b1 FROM Book b1 WHERE b1.author LIKE :pauthor";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("pauthor", "%"+author+"%");
		return query.getResultList();
		
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> query = entityManager.createNamedQuery("getAllBooks", Book.class);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		String qStr = "SELECT b1 FROM Book b1 WHERE b1.price BETWEEN :price_low AND :price_high";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("price_low", low);
		query.setParameter("price_high", high);
		List<Book> books = query.getResultList();
		return books;
	}

}
