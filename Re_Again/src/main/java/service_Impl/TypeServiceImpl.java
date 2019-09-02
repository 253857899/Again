package service_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Type_dao;
import entry.Type;
import service.TypeService;
import utils.ReturnInfo;

@Service
public class TypeServiceImpl implements TypeService{
	@Autowired
	Type_dao dao;
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage = page != null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where, ReturnInfo.getLimit(page, max)));
		if (canpage)
			info.setCount(dao.search(where));
		return info;
	}

	public Type selectByid(int id) {
		return dao.select("where type.id=" + id, "limit 1").get(0);
	}

	public int insert(Type b) {
		return dao.insert(b);
	}

	public int update(Type b) {
		return dao.update(b);
	}

	public int delete(Type b) {
		return dao.delete(b);
	}
}
