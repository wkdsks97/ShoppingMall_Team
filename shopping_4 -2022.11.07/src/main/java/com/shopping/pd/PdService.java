package com.shopping.pd;

import java.util.List;
import java.util.Map;

public interface PdService {

	String create(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);

}
