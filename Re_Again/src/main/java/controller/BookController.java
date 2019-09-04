package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entry.Book;
import service.BookService;

@Controller
@RequestMapping("Book")
public class BookController {
		@Autowired
		BookService service;
		
		@RequestMapping("index")
		public String index(String name,ModelMap m) {
			m.put("Booklist", service.getWhere(name));
			return "Book/index";		
		}
		@RequestMapping("delete")
		public String delete(int id, ModelMap m) {
			service.delete(id);
			return index(null,m);
		}
		@RequestMapping("insert")
		public String insert(Book t, ModelMap m) {
			service.insert(t);
			return index(null,m);
		}
		@RequestMapping("update")
		public String update(Book t, ModelMap m) {
			service.update(t);
			return index(null,m);
		}
		@RequestMapping("add")
		public String add(Integer id,ModelMap m) {
			if(id!=null)
			m.put("shoot", service.getByid(id));
			m.put("id",id);
			return "Book/edit";
		}

}
