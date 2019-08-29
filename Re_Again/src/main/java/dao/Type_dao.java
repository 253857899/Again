package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import entry.Type;

@Repository
public interface Type_dao {
	@Select("select * from type ${where}")
	public List<Type> select(@Param(value = "where" ) String where);
}
