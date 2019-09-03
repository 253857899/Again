package service_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.User_dao;
import entry.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	User_dao dao;
	public List<User> select(String where) {
			if(where==""||where==null)
				return dao.select("");
		else 
			return dao.select(" where name like '%"+where+"%'");
	}
	public void delete(int id) {
		dao.delete(id);
	}
	public void insert(User t) {
		 dao.insert(t);
	}
	public void update(User t) {
		dao.update(t);
	}
	public User selectById(int id) {
		return dao.selectById(id);
	}
	public User login(User t) {
		return dao.login(t);
	}
}
