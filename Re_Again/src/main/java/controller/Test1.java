package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class Test1 {
		@RequestMapping("index")
		public String index(@RequestParam(name="poet") String name,ModelMap m) {
			m.put("poet", name);
			System.out.println("我永恒的灵魂");
			System.out.println("注视着你的心");
			System.out.println("纵然黑夜孤寂");
			System.out.println("白昼如焚");
			return "index";
		}
}
