package com.demo.crudsimples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String home(){
        return "pages/cadastrarPessoa.xhtml";
    }
	
}
