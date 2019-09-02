package service_Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book_dao;
import entry.Book;

import service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	Book_dao dao;
	public List<Book> select() {
			return dao.select();
	}
	public void delete(int id) {
		dao.delete(id);
	}
	public void insert(Book t) {
		 dao.insert(t);
	}
	public void update(Book t) {
		dao.update(t);
	}
	public Book selectById(int id) {
		return dao.selectById(id);
	}
}
