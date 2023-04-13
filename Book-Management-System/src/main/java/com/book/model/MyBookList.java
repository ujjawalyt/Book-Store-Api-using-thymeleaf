package com.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="MyBook")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MyBookList {

 @Id
 private Long id;
	private String name;
	private String author;
	private Double price;
 
 
}
