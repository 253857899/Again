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
			System.out.println("����������");
			System.out.println("ע���������");
			System.out.println("��Ȼ��ҹ�¼�");
			System.out.println("�������");
			return "index";
		}
}
