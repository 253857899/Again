package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
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
		public String login(User u,String code,ModelMap m,HttpSession s) {
			String num=s.getAttribute("number").toString();
			if(!num.equalsIgnoreCase(code)) {
				return "redirect:/login.html";
			}
			
			//SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getName(),u.getPass()));
			User user=service.login(u);
			if(user!=null) {
				s.setMaxInactiveInterval(10);
				s.setAttribute("user", user);
				return "redirect:/index.jsp";
			}else {
				return "redirect:/login.html";
			}
		}
		@RequestMapping("outlogin")
		public String login(HttpSession s,HttpServletRequest req) {
			s.removeAttribute("user");
			
			return "redirect:../login.html";
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
