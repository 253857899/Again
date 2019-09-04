package service_Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

import service.BasicService;

@Service
public class BasicServiceImpl<T> implements BasicService<T>{


@SuppressWarnings("rawtypes")
private Object execDao(String mname,Object... objs){
	try {
	Field f = this.getClass().getDeclaredField("dao");
	f.setAccessible(true);
	Object dao = f.get(this);
	Class<? extends Object> cls = dao.getClass();  //dao的字节码
	Class[] cs=new Class[objs.length];
	for(int i=0;i<objs.length;i++)cs[i]=objs[i].getClass();
	Method m= cls.getMethod(mname, cs);
	m.setAccessible(true);
	return m.invoke(dao, objs);
	}catch (Exception e) {
		return null;
	}
	
}

@SuppressWarnings("unchecked")
public List<T> getWhere(String where) {
	Object o=execDao("getWhere", where);
	if(o!=null) return (List<T>) o;
	else return new ArrayList<T>();
}

@SuppressWarnings("unchecked")
public List<T> getAll() {
	Object o=execDao("getAll");
	if(o!=null) return (List<T>) o;
	else return new ArrayList<T>();
}

@SuppressWarnings("unchecked")
public T getByid(Integer id) {
	Object o=execDao("getByid");
	if(o!=null) return (T) o;
	else return null;
}

public int delete(Integer id) {
	Object o=execDao("delete",id);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer insert(T t) {
	Object o=execDao("insert",t);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer update(T t) {
	Object o=execDao("update",t);
	if(o!=null) return (Integer) o;
	else return -2;
}


}