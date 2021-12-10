package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginCintroller {

	@Autowired
	private UserRepository userRepository ;
	
	@RequestMapping("/")
	public String index() {
		return "Login";
	}
	
	@RequestMapping("/in")
	public String in(HttpServletRequest request ,Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userRepository.findByUsernameAndPassword(username, password);
		String str = "";
		if (user != null) {
			str = "sucess";
		}else {
			str="error";
		}
		    
		return str;
	}
}
