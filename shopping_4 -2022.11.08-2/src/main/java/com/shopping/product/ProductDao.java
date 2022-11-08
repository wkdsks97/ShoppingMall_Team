package com.shopping.product;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	 @Autowired
	 SqlSessionTemplate sqlSessionTemplate;
	 
	 public int insert(Map<String, Object> map) {
			//mapper(=book_SQL.xml)�� �ִ� id�� insert��
			//������ ������
			return 
			this.sqlSessionTemplate.insert
			("pd.insert",map);
		}
		
		public Map<String,Object> selectDetail
		(Map<String,Object> map) {
			return this.sqlSessionTemplate.
					selectOne("pd.select_detail",map);
		}
		
		public int update(Map<String,Object> map) {
			return 
			this.sqlSessionTemplate.update
			("pd.update", map);
		}
		
		public int delete(Map<String, Object> map) {
			return 
			this.sqlSessionTemplate.delete
			("pd.delete",map);
		}
	 

	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList
				("pd.select_list",map);
	}

	public int countPD(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne
				("pd.countPD",map);
	}


	 
	 
	 
}