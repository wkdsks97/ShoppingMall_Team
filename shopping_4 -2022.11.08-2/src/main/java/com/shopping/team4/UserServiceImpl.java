package com.shopping.team4;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.userDao.insert(map);
		if (affectRowCount == 1) {
			return map.get("id").toString();
		}
		return null;

	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.userDao.selectDetail(map);
	}

	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.userDao.update(map);
		return affectRowCount == 1;

	}

	@Override
	public int idCheck(Map<String, Object> map) throws Exception {
		int result = userDao.idCheck(map);
		return result;
	}

	@Override
	public boolean login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public Map<String, Object> login_ok(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.userDao.Login_Check(map);
	}

	@Override
	public int idCheck_test(String id) {
		int cnt1 = userDao.idCheck_test(id);
		System.out.println(cnt1);
		System.out.println("aa");
		return cnt1;
	}
	

	@Override  
	public List<Map<String, Object>> list(Map<String, Object> map){  
	return this.userDao.selectList(map);  
	}  
	

}
