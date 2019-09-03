package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.User;

@Repository
public interface User_dao {	
	@Select("SELECT * FROM  User  where name =#{name} and pass = #{pass}" )
	public User login(User t);
	@Select("SELECT * FROM  User  ${where}" )
	public List<User> select(@Param(value = "where" ) String where);
	@Delete("delete from User where id = #{id} ")
	public void delete(int id);
	@Insert("insert into User(name,pass) value(#{name},#{pass})")
	public void insert(User t);
	@Update("update User set name=#{name},pass=#{pass} where id=#{id}")
	public void update(User t);
	@Select("select * from User where id = #{id}")
	public User selectById(int id);
}
