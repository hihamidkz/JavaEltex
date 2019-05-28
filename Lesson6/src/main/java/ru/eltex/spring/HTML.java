package ru.eltex.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HTML {
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
}
