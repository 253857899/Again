package service;

import java.util.List;

import entry.Type;

public interface TypeService {
	public List<Type> select(String where);
}
