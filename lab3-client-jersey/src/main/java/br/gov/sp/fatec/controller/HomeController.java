package br.gov.sp.fatec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(path = "")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
}
