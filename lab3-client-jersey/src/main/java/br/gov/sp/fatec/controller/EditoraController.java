package br.gov.sp.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.dto.EditoraDto;
import br.gov.sp.fatec.service.EditoraService;

@Controller
@RequestMapping(path = "/editora")
public class EditoraController {
	@Autowired
	private EditoraService service;

	@RequestMapping(path = "")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("editora-lista");
		model.addObject("editoras", service.list());
		return model;
	}

	@RequestMapping(path = "/new")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("editora-edicao");
		model.addObject("editora", new EditoraDto());
		return model;
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView model = new ModelAndView("editora-edicao");
		model.addObject("editora", service.load(id));
		return model;
	}

	@RequestMapping(value = "/save")
	public ModelAndView edit(@ModelAttribute EditoraDto editora) {
		service.save(editora);
		return new ModelAndView("redirect:/editora");
	}
}
