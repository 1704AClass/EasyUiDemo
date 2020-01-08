package com.easyui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.easyui.pojo.User;
import com.easyui.service.LoginService;

@Controller
@SessionAttributes
@RequestMapping("/loginController")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public ModelAndView login(String username,String userpwd,HttpServletRequest request){
		ModelAndView mView = new ModelAndView();
		User user = loginService.login(username);
		if(user!=null){
			if(user.getPwd().equals(userpwd)){
				//放到session中
				request.getSession().setAttribute("user", user);
				mView.setViewName("redirect:/home.html");
				return mView;
			}
		}
		mView.setViewName("redirect:/login.html");
		return mView;
	}
	
	
	
	
}
