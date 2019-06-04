package ru.eltex.spring;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HTML {
	private static final Logger log = Logger.getLogger(HTML.class);

	@GetMapping("/")
	public String index() {
		log.debug("HTML controller: index");
		return "index.html";
	}
}
