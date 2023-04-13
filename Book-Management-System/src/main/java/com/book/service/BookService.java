package com.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.model.Book;

@Service
public interface BookService {

	public Book addNewBook(Book book);
	public List<Book> getAllBook();
	public Book getBookById(Long id);
	public void deleteBookById(Long id);
	public Book updateBook(Long id ,Book book);
	
}
