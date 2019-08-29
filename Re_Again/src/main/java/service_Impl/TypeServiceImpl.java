package service_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.Type_dao;
import entry.Type;
import service.TypeService;

@Component
public class TypeServiceImpl implements TypeService{
	@Autowired
	Type_dao dao;

	public List<Type> select(String where) {
			if(where==""||where==null)
				return dao.select("");
		else 
			return dao.select(" where name like '%"+where+"%'");
	}
}
