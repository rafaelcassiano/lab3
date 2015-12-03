package br.gov.sp.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.dto.AutorDto;
import br.gov.sp.fatec.service.AutorService;

@Controller
@RequestMapping(path = "/autor")
public class AutorController {
	@Autowired
	private AutorService service;

	@RequestMapping(path = "")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("autor-lista");
		model.addObject("autores", service.list());
		return model;
	}

	@RequestMapping(path = "/new")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("autor-edicao");
		model.addObject("autor", new AutorDto());
		return model;
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView model = new ModelAndView("autor-edicao");
		model.addObject("autor", service.load(id));
		return model;
	}

	@RequestMapping(value = "/save")
	public ModelAndView save(@ModelAttribute AutorDto autor) {
		service.save(autor);
		return new ModelAndView("redirect:/autor");
	}
}
