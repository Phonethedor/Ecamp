package com.jvega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LogoutController {
	
	//metodo para rersponder al request  / logout
	@GetMapping("/logout")
	public RedirectView logout() {
		return new RedirectView("/login");
	}

}
