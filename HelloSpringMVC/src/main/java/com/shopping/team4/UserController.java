package com.shopping.team4;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	UserService userService;

//	@RequestMapping(value="/home")
//	public ModelAndView home(@RequestParam Map<String,Object>map) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/user/home");
//		
//		return mav;
//		
//	}

	@RequestMapping(value = "/home")
	public ModelAndView home(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.invalidate();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/home");
		// return new ModelAndView("book/home");
		return mav;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/login");
		System.out.println("??????????");
		// return new ModelAndView("book/home");
		return mav;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login_post(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// return new ModelAndView("book/home");
		Map<String, Object> userpw = this.userService.login_ok(map);

		// mav.addObject(userpw);

		// map.get("id");
		// System.out.println(userpw.get("pw"));
		// System.out.println(map.get("pw"));

		PasswordEncoder p = new BCryptPasswordEncoder();
//		String encodepw = p.encode(map.get("pw").toString());
//		
//		System.out.println(encodepw);
//		System.out.println(userpw.get("pw").toString());
		System.out.println(p.matches(map.get("pw").toString(), userpw.get("pw").toString()));

		if (userpw == null) {

//		String UserId = map.get("UserId").toString();  
//		mav.addObject("id", UserId);
			mav.setViewName("/user/login");

		} else {
			if (p.matches(map.get("pw").toString(), userpw.get("pw").toString())) {
				HttpSession session = request.getSession();
				session.setAttribute("id", map.get("id"));
				mav.setViewName("redirect:home2_loginOK");
			} else {
				mav.setViewName("/user/create_user");
			}
		}

		return mav;

	}

	@RequestMapping(value = "/home2_loginOK", method = RequestMethod.GET)
	public ModelAndView login_2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/home2_loginOK");
		System.out.println("??????????");
		// return new ModelAndView("book/home");
		return mav;

	}

	@RequestMapping(value = "/detail_user", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.userService.detail(map);

		ModelAndView mav = new ModelAndView();

		mav.addObject("data", detailMap);

		String UserId = map.get("UserId").toString();
		mav.addObject("id", UserId);
		mav.setViewName("/user/detail_user");
		return mav;
	}

	@RequestMapping(value = "/create_user", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("user/create_user");
	}

	@RequestMapping(value = "/create_user", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		PasswordEncoder p = new BCryptPasswordEncoder();
		String encodepw = p.encode(map.get("pw").toString());

		map.replace("pw", encodepw);

		String UserId = this.userService.create(map);

		if (UserId == null) {
			mav.setViewName("redirect:/create_user");
		} else {
			mav.setViewName("redirect:/detail_user?UserId=" + UserId);
		}

		return mav;
	}

	@RequestMapping(value = "/update_user", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.userService.detail(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/user/update_user");
		return mav;
	}

	@RequestMapping(value = "/update_user", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		PasswordEncoder p = new BCryptPasswordEncoder();
		String encodepw = p.encode(map.get("pw").toString());
		map.replace("pw", encodepw);

		boolean isUpdateSuccess = this.userService.edit(map);
		if (isUpdateSuccess) {
			String UserId = map.get("UserId").toString();

			mav.setViewName("redirect:/detail_user?UserId=" + UserId);
		} else {
			mav = this.update(map);
		}

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/idCheck_test", method = RequestMethod.POST,produces = "application/json")
	public int idCheck_test(@RequestParam("id") String id) {
		
		int cnt = userService.idCheck_test(id);
		System.out.println(cnt);
		System.out.println("bb");
		return cnt;
		
	}
	
	
	
	
	
	
	
	
	
}
