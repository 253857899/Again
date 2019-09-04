package controller;

import java.lang.reflect.Field;

import java.lang.reflect.ParameterizedType;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service_Impl.BasicServiceImpl;
import utils.ReturnInfo;

@Controller
public class BasicController<T>  {
	
	BasicServiceImpl<T> basicservice;
	
	@ModelAttribute
	public void init() throws Exception{
		Field f=this.getClass().getDeclaredField("service");
		f.setAccessible(true);
		Object dao=f.get(this);
		basicservice=(BasicServiceImpl<T>) dao;
	}
	
	private String getTname() {
		return getRealType().getSimpleName();
	}
	
	public Class getRealType(){
		// 获取当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一个类型参数的真实类型
		return (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where "+getTname()+".name like '%"+txt+"%'";
		return basicservice.select(where, page, limit);
	}
	
	
	
	@RequestMapping("select")
	public @ResponseBody T select(int id) {
		return basicservice.selectByid(id);
	}
	


	@RequestMapping("delete")
	public @ResponseBody String  delete(T b) {
		basicservice.delete(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("insert")
	public @ResponseBody String  insert(T b) {
		basicservice.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(T b) {
		basicservice.update(b);
		return "{\"status\":1}";
	}
}
