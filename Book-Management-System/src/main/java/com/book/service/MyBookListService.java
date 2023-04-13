package com.book.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.book.model.MyBookList;



@Service
public interface MyBookListService {


	public void saveBook(MyBookList book);
	public List<MyBookList> getAllMyBook();
	public void deleteMyBook(Long id);
}
