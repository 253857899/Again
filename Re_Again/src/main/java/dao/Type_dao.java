package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import entry.Type;

@Repository
public interface Type_dao {
	@Select("SELECT type.*,book.name bookname FROM book INNER JOIN type on type.bookid = book.typeid ${where}" )
	public List<Type> select(@Param(value = "where" ) String where);
	@Delete("delete from type where id = #{id} ")
	public void delete(int id);
	@Insert("insert into type(name,status,bookid) value(#{name},#{status},#{bookid})")
	public void insert(Type t);
	@Update("update type set name=#{name},status=#{status},bookid=#{bookid} where id=#{id}")
	public void update(Type t);
	@Select("select * from type where id = #{id}")
	public Type selectById(int id);
}
