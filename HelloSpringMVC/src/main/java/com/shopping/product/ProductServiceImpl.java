package com.shopping.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Controller�� DAO�� �̾��ִ� ��
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productdao;//��ü �ڵ� ���� �� ����
	
	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.productdao.insert(map);
		if(affectRowCount==1)
			return map.get("pd_name").toString();
		return null;
	}
	
	@Override
	public Map<String,Object> detail
		(Map<String,Object> map) {
		return this.productdao.selectDetail(map);
	}

	@Override
	public boolean edit(Map<String, Object> map) {
		int afftectRowCount = 
				this.productdao.update(map);
		//afftectRowCount�� 1�� �� true����
		//�� update ������ true����
		return afftectRowCount==1;
	}
	
	@Override
	public boolean remove(Map<String,Object> map) {
		int affectRowCount 
		= this.productdao.delete(map);
		return affectRowCount==1;
	}
	
	//import�� ���ǻ��� : java.awt �ƴ�
	@Override
	public List<Map<String,Object>> list
	(Map<String,Object> map) {
		return this.productdao.selectList(map);
	}

	@Override
	public int countPD(Map<String, Object> map) {
		return this.productdao.countPD(map);
	}




	
}










