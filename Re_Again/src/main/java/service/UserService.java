package service;

import java.util.List;

import entry.User;

public interface UserService {
	public List<User> select(String where);
	public void delete(int id);
	public void insert(User t);
	public void update(User t);
	public User selectById(int id);
	public User login(User t);
}
