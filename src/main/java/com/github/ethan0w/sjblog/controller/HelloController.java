package com.github.ethan0w.sjblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {

	@ResponseBody
	@RequestMapping("/")
	public String hello(){
		return "This site is under construction";
	}
}
