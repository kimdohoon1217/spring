package kr.or.ddit.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringController {
	
	@RequestMapping("/hello")
	public String helloSpring() {
		return "hello/helloSpring";
	}
	
}
