package cn.tj.fnzi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/user/list")
	public String index(ModelMap model) {
		
		model.addAttribute("msg", "this is a user page");
		
		return "/user/user";
	}
}
