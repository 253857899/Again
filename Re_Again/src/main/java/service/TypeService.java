package service;

import java.util.List;

import entry.Type;

public interface TypeService {
	public List<Type> select(String where);
	public void delete(int id);
	public void insert(Type t);
	public void update(Type t);
	public Type selectById(int id);
}
