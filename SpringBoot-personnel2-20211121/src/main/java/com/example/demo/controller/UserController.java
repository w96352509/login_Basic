package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("users" , userRepository.findAll());
		return "User";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request , Model model) {
		    String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userRepository.save(user);
		return "redirect:/user/";
	}
	
}
