package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.MyBookList;
import com.book.repository.MyBookRepository;

@Service
public class MyBookServiceImpl implements MyBookListService{

	@Autowired
	private MyBookRepository myBookRepository;

	@Override
	public void saveBook(MyBookList book) {
		myBookRepository.save(book);
		
	}

	@Override
	public List<MyBookList> getAllMyBook() {
	return	myBookRepository.findAll();
		
	}

	@Override
	public void deleteMyBook(Long id) {
	
	  myBookRepository.deleteById(id);
		
	}

	
}
