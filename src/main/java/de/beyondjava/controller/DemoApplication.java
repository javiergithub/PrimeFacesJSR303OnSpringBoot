package de.beyondjava.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@Scope("request")
@RequestMapping(value="/pedro")
public class DemoApplication {

    @RequestMapping
	String home(@RequestParam(value="name", required=false, defaultValue="World") String named) {
		return "Hello " + named + " !";
	}	
}
