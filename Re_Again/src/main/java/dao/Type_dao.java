package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Book;
import entry.Type;

@Repository
public interface Type_dao {
	@Select("select count(1) from book inner join type on type.bookid=book.typeid ${where}")
	public int search(@Param(value = "where") String where);
	
	@Select("select type.*,book.name bookname from book inner join type on type.bookid=book.typeid ${where} order by id ${limit}")
	public List<Type> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into type(name,status,bookid) values(#{name},#{status},#{bookid})")
	public int insert(Type b);
	
	@Update("update type set name=#{name},status=#{status},bookid=#{bookid} where id=#{id}")
	public int update(Type b);
	
	@Delete("delete from type  where id=#{id}")
	public int delete(Type b);
}
