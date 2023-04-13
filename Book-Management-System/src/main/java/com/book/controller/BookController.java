package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.model.Book;
import com.book.model.MyBookList;
import com.book.service.BookService;
import com.book.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	MyBookListService myBookListService;
	
	
	@GetMapping("/")
	public String homepPage() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_book")
	public ModelAndView availableBook() {
		
		List<Book> list= bookService.getAllBook();
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("availablebook");
//		modelAndView.addObject("book", list);
//		return modelAndView ;
		
//	or 
		return new ModelAndView("availablebook" ,"book", list);
	}
	
	@PostMapping("/save")
	public String addNewBook(@ModelAttribute Book book) {
		bookService.addNewBook(book);
		return "redirect:/available_book";
		
	}
	
	@GetMapping("/my_books")
	public String getMyBook(Model model) {
		List<MyBookList>list = myBookListService.getAllMyBook();
		model.addAttribute("book", list );
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public  String getMyList(@PathVariable Long id) {
		Book b= bookService.getBookById(id);
		MyBookList myBookList = new MyBookList(b.getId() ,b.getName(), b.getAuthor() ,b.getPrice());
		myBookListService.saveBook(myBookList);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/deletemylist/{id}")
	public String deleteMyList(@PathVariable("id") Long id) {
		myBookListService.deleteMyBook(id);
		return "redirect:/my_books";
		
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deletBookFormDb(@PathVariable("id") Long id)
	{
		bookService.deleteBookById(id);
		
		return "redirect:/available_book";
		
		
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")Long id,Model model) {
		Book book =bookService.getBookById(id);
		model.addAttribute("book", book);
		
		return "updateBook";
	}
	
	
	
}
