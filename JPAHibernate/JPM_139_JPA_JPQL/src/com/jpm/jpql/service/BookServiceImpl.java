package com.jpm.jpql.service;

import java.util.List;

import com.jpm.jpql.dao.BookDaoImpl;
import com.jpm.jpql.dao.IBookDao;
import com.jpm.jpql.entities.Book;

public class BookServiceImpl implements IBookService {
	private IBookDao bookDao;
	
	public BookServiceImpl() {
		bookDao = new BookDaoImpl();
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}

	@Override
	public Long getBookCount() {
		return bookDao.getBookCount();
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		return bookDao.getAuthorBooks(author);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		return bookDao.getBooksInPriceRange(low, high);
	}

}