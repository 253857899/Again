package controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entry.Type;
import service.BookService;
import service.TypeService;

@Controller
@RequestMapping("Type")
public class TypeController {
		@Autowired
		TypeService service;
		@Autowired
		BookService bservice;
		@RequestMapping("index")
		public String index(String name,ModelMap m) {
			m.put("typelist", service.select(name));
			return "Type/index";		
		}
		
		@RequiresPermissions("delete")
		@RequestMapping("delete")
		public String delete(int id, ModelMap m) {
			service.delete(id);
			return index(null,m);
		}
		@RequestMapping("insert")
		public String insert(Type t, ModelMap m) {
			service.insert(t);
			return index(null,m);
		}
		@RequestMapping("update")
		public String update(Type t, ModelMap m) {
			service.update(t);
			return index(null,m);
		}
		@RequestMapping("add")
		public String add(Integer id,ModelMap m) {
			if(id!=null)
			m.put("shoot", service.selectById(id));
			m.put("statuses", Type.status_name);
			m.put("booklist", bservice.select());
			m.put("id",id);
			return "Type/edit";
		}

}
