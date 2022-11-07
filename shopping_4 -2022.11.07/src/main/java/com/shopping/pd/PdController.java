package com.shopping.pd;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PdController {
	@Autowired
	PdService pdService;
	
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
	
	
	
	
}
