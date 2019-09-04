package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entry.Type;
import service.BookService;
import service.TypeService;

@Controller
@RequestMapping("Type")
public class TypeController extends BasicController<Type> {
	@Autowired
	BookService bservice;
	
	@Autowired
	TypeService service;

	@Override
	public String index(ModelMap m,HttpServletRequest req) {
		String txt=req.getParameter("txt");
		String where=""; 
		if(txt!=null&&txt.length()>0) where=" where type.name like '%"+txt+"%' ";
		m.put("list", service.getWhere(where));
		return "Type/index";
	}

	@RequestMapping("add")
	public String add(ModelMap m,HttpServletRequest req) {
		m.put("statuses", Type.status_name);
		m.put("booklist", bservice.getAll());
		return "Type/edit";
	}
	@RequestMapping("edit")
	public String edit(Integer id,ModelMap m,HttpServletRequest req) {
		m.put("info", service.getByid(id));
		return add(m,req);
	}

}