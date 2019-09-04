package dao;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import entry.Book;



@Repository
public interface Book_dao {
	@Select("select * from book")
	public List<Book> select();
	
	@Select("select count(1) from book inner join type on type.bookid=book.typeid ${where}")
	public Integer search(@Param(value = "where") String where);
	
	@Select("select Type.*,book.name bookname from book inner join Type on Type.bookid=book.typeid ${where} ${limit}")
	public List<Book> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into Book(name,status,bookid) values(#{name},#{status},#{bookid})")
	public Integer insert(Book b);
	
	@Update("update Book set name=#{name},status=#{status},bookid=#{bookid} where id=#{id}")
	public Integer update(Book b);
	
	@Delete("delete from Book  where id=#{id}")
	public Integer delete(Book b);
}
