package cn.tj.fnzi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/auth/list")
	public String list(ModelMap model) {
		
		model.addAttribute("msg", "this is a auth list page...");
		
		return "/auth/auth";
	}
	
}
