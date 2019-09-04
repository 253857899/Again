package service_Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book_dao;
import entry.Book;

import service.BookService;

@Service
public class BookServiceImpl extends BasicServiceImpl<Book> implements BookService{
	@Autowired
	Book_dao dao;
	
}
