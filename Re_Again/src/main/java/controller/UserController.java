package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entry.User;
import service.BookService;
import service.UserService;

@Controller
@RequestMapping("User")
public class UserController {
		@Autowired
		UserService service;
		@Autowired
		BookService bservice;
		
		@RequestMapping("login")
		public String login(String name,ModelMap m) {
			return "User/login";
		}
		
		
		@RequestMapping("index")
		public String index(String name,ModelMap m) {
			m.put("Userlist", service.select(name));
			return "User/index";		
		}
		@RequestMapping("delete")
		public String delete(int id, ModelMap m) {
			service.delete(id);
			return index(null,m);
		}
		@RequestMapping("insert")
		public String insert(User t, ModelMap m) {
			service.insert(t);
			return index(null,m);
		}
		@RequestMapping("update")
		public String update(User t, ModelMap m) {
			service.update(t);
			return index(null,m);
		}
		@RequestMapping("add")
		public String add(Integer id,ModelMap m) {
			if(id!=null)
			m.put("shoot", service.selectById(id));
			m.put("booklist", bservice.select());
			m.put("id",id);
			return "User/edit";
		}

}
