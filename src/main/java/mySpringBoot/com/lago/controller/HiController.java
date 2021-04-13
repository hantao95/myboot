package mySpringBoot.com.lago.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("app")
public class HiController {
	
	@RequestMapping("hi")
	public String sayHi() {
		return "hello world";
	}
}
