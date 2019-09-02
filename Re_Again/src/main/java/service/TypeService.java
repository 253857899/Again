package service;

import java.util.List;

import entry.Type;
import utils.ReturnInfo;

public interface TypeService {
public ReturnInfo select(String where,Integer page,Integer max);
	
	public Type selectByid(int id);
	
	public int insert(Type b);
	
	public int update(Type b);
	
	public int delete(Type b);
	
}
