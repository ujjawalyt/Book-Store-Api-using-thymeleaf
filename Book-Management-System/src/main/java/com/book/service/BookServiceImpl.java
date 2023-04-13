package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
	private BookRepository bookRepository;

	
	@Override
	public Book addNewBook(Book book) {
	return	bookRepository.save(book);
		
	}

	@Override
	public List<Book> getAllBook() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
	
		Optional<Book> book = bookRepository.findById(id);
		
		return book.get();
	}

	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public Book updateBook(Long id, Book book) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
