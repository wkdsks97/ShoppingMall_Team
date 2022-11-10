package com.shopping.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ProductController {

	
	@Autowired
	ProductService productservice;
	

	
	@RequestMapping(value="/mainhome2")
	public ModelAndView list
	(@RequestParam Map<String,Object> map,
	 @RequestParam(value="nowPage",required=false) String nowPage) {
		double CNT = 8.0; 
		int LIMITCOUNT = (int)CNT;
		if(nowPage!=null) {
			int now = Integer.parseInt(nowPage);
			int skipCount=0;
			if(now>1)
				skipCount = (now-1)*LIMITCOUNT;
			map.put("skipCount", skipCount);
		} else {
			map.put("skipCount",0);
		}
		
		List<Map<String,Object>> list =
				this.productservice.list(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",list);
		int totalCount = 
				(int)Math.ceil
				(this.productservice.countPD(map)/CNT);
				
		mav.addObject("totalCount", totalCount);
		
		int nowPos = nowPage==null?1:Integer.parseInt(nowPage);
		if(nowPos<=0)
			nowPos=1;
		mav.addObject("nowPage",nowPos);
		
		int endPage = (int)(Math.ceil(nowPos/CNT)*(LIMITCOUNT));
		int startPage = 0;
		if(endPage>totalCount) {
			startPage = endPage-(LIMITCOUNT)+1;
			endPage=totalCount;
		} else {
			startPage = endPage-(LIMITCOUNT)+1;
		}
		if(startPage<=0)
			startPage=1;
		
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		
		
		if(map.containsKey("keyword"))
			mav.addObject("keyword", map.get("keyword"));
		
		mav.setViewName("/user/mainhome2");
		return mav;
		
	}
	
	
	
	
	
	
}
