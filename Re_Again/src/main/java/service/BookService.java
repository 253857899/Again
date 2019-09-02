package service;

import java.util.List;

import entry.Book;

public interface BookService {
	public List<Book> select();
	public void delete(int id);
	public void insert(Book t);
	public void update(Book t);
	public Book selectById(int id);
}
