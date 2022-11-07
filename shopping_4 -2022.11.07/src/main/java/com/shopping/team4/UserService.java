package com.shopping.team4;

import java.util.List;
import java.util.Map;

public interface UserService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);
	
	int idCheck(Map<String, Object> map) throws Exception;

	boolean edit(Map<String, Object> map);

	boolean login(Map<String, Object> map);
	
	Map<String, Object> login_ok(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);
	
	
}
