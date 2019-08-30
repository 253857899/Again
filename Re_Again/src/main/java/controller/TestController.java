package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entry.Type;
import service.TypeService;

@Controller
public class TestController {
		@Autowired
		TypeService service;
		
		@RequestMapping("index")
		public String index(String name,ModelMap m) {
			m.put("typelist", service.select(name));
			return "index";		
		}
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
			m.put("shoot", service.selectById(id));
			m.put("id",id);
			return "edit";
		}

}
