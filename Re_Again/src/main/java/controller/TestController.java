package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class TestController {
		@RequestMapping("index")
		public String index(@RequestParam(name="poet") String name,ModelMap m) {
			m.put("poet", name);
			System.out.println("¿ØÖÆÆ÷Æô¶¯!!!!!!!!!!!!!!!!!!!");
			return "index";
		}
}
