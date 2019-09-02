package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entry.Book;
import entry.Type;

import service.BookService;
import service.TypeService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Type")
public class TypeController {
		@Autowired
		TypeService service;
		@Autowired
		BookService bservice;
		@RequestMapping("index")
		public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
			String where="";
			if(txt!=null && txt!="")
				where=" where type.name like '%"+txt+"%'";
			return service.select(where, page, limit);
		}
		
		@RequestMapping("select")
		public @ResponseBody Type select(int id) {
			return service.selectByid(id);
		}
		
		@RequestMapping("getBookid")
		public @ResponseBody List<Book> getBookid() {
			return bservice.select();
		}
		
		@RequestMapping("getStatus")
		public @ResponseBody String[] getStatus() {
			return Type.status_name;
		}
		
		@RequestMapping("delete")
		public @ResponseBody String  delete(Type b) {
			service.delete(b);
			return "{\"status\":1}";
		}
		
		@RequestMapping("insert")
		public @ResponseBody String  insert(Type b) {
			service.insert(b);
			return "{\"status\":1}";
		}
		
		@RequestMapping("update")
		public @ResponseBody String update(Type b) {
			service.update(b);
			return "{\"status\":1}";
		}

}
