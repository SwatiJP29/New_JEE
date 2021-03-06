package com.jpm.jpql.client;

import com.jpm.jpql.service.BookServiceImpl;
import com.jpm.jpql.service.IBookService;

public class BookClient {
	
	public static void main(String[] args) {
		//prep work
		IBookService service =  new BookServiceImpl();
		/*System.out.println("*********************** Listing book with id 101********************************");
		System.out.println("Book with ID 101 : " + service.getBookById(101));
		
		
		System.out.println("*********************** Listing books********************************");
		System.out.println("Books : " + service.getAllBooks());
		
		System.out.println("*********************** Listing books by title********************************");
		System.out.println("Books by title: " + service.getBookByTitle("EE"));*/
		
		/*System.out.println("*********************** Listing books by author********************************");
		System.out.println("Books by author: " + service.getAuthorBooks("an"));*/
		
		/*System.out.println("*********************** Listing books count********************************");
		System.out.println("Books count: " + service.getBookCount());*/
		
		System.out.println("*********************** Listing books in price range between 300 and 600********************************");
		System.out.println("Books count: " + service.getBooksInPriceRange(100, 400));
	}

}
