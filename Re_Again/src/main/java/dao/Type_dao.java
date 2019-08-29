package dao;

import java.util.List;



import org.springframework.stereotype.Repository;

import entry.Type;

@Repository
public interface Type_dao {
	public List<Type> select(String where);
}
