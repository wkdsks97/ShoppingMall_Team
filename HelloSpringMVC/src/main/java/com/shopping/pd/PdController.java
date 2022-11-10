package com.shopping.pd;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.team4.UserService;

@Controller
public class PdController {
	@Autowired
	PdService pdService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView index() {
	    return new ModelAndView("admin/index");
	}
	
	@RequestMapping(value="/admin/goods/register", method = RequestMethod.GET)
	public ModelAndView register() {
	    return new ModelAndView("admin/goods/register");
	}
	
	@RequestMapping(value = "/admin/goods/register", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String pdId = this.pdService.create(map);
	    if (pdId == null) {
	        mav.setViewName("redirect:/admin/goods/register");
	    }else {
	        mav.setViewName("redirect:/index");
	    }  

	    return mav;
	}
	
	@RequestMapping(value = "/admin/goods/list")  
	public ModelAndView list(@RequestParam Map<String, Object> map) {  

	List<Map<String, Object>> list = this.pdService.list(map);  

	ModelAndView mav = new ModelAndView();  
	mav.addObject("data", list);  
	
	if (map.containsKey("keyword")) {  
		mav.addObject("keyword", map.get("keyword"));  
		} 
	
	mav.setViewName("/admin/goods/list");  
	return mav;  
	}  
	
	@RequestMapping(value = "/admin/goods/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
	    Map<String, Object> detailMap = this.pdService.detail(map);

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("data", detailMap);
	    String pd_num = map.get("pd_num").toString();
	    mav.addObject("pd_num", pd_num);
	    mav.setViewName("/admin/goods/detail");
	    return mav;
	}
	
	@RequestMapping(value = "/admin/goods/detail2", method = RequestMethod.GET)
	public ModelAndView detail2(@RequestParam Map<String, Object> map) {
	    Map<String, Object> detailMap = this.pdService.detail(map);

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("data", detailMap);
	    String pd_num = map.get("pd_num").toString();
	    mav.addObject("pd_num", pd_num);
	    
	    System.out.println(mav.toString());
	    mav.setViewName("/admin/goods/detail2");
	    return mav;
	}
	@RequestMapping(value = "/admin/goods/detail2", method = RequestMethod.POST)  
	public ModelAndView detailPost(@RequestParam Map<String, Object> map) {  
		ModelAndView mav = new ModelAndView();  
		System.out.println("!!!!!!!!!!!!!!!!!!!!! /admin/goods/detail2 post" + map);  
	
		
		List<Map<String, Object>> list = this.userService.list(map);  
		String id = map.get("id").toString();
		System.out.println("!!id="+map.get("id"));
		
		System.out.println(map.get("action"));
		if(map.get("action").equals("카트에 담기")) {
			
		mav.setViewName("redirect:/user/cartlist/?id="+id );  }
		
		else if(map.get("action").equals("구매하기")) {
			
		mav.setViewName("redirect:/user/buy");  }

	return mav;  
	}  
	//buy 

	
	
	@RequestMapping(value = "/admin/goods/update", method = RequestMethod.GET)  
	public ModelAndView update(@RequestParam Map<String, Object> map) {  
	Map<String, Object> detailMap = this.pdService.detail(map);  

	ModelAndView mav = new ModelAndView();  
	mav.addObject("data", detailMap);  
	mav.setViewName("/admin/goods/update");  
	return mav;  
	}  
	
	@RequestMapping(value = "/admin/goods/update", method = RequestMethod.POST)  
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {  
	ModelAndView mav = new ModelAndView();  

	boolean isUpdateSuccess = this.pdService.edit(map);  
	if (isUpdateSuccess) {  
	String pd_num = map.get("pd_num").toString();  
	mav.setViewName("redirect:/admin/goods/detail?pd_num=" + pd_num);  
	}else {  
	mav = this.update(map);  
	}  

	return mav;  
	}  
	
	@RequestMapping(value = "/admin/goods/delete", method = RequestMethod.POST)  
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {  
	ModelAndView mav = new ModelAndView();  

	boolean isDeleteSuccess = this.pdService.remove(map);  
	if (isDeleteSuccess) {  
	mav.setViewName("redirect:/admin/goods/list");  
	}else {  
		String pd_num = map.get("pd_num").toString();  
		mav.setViewName("redirect:/admin/goods/detail?pd_num=" + pd_num); 
	}  

	return mav;  
	}  
	
	
}
