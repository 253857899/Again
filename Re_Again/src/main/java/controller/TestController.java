package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
