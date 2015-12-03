package br.gov.sp.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.dto.LivroDto;
import br.gov.sp.fatec.service.AutorService;
import br.gov.sp.fatec.service.EditoraService;
import br.gov.sp.fatec.service.LivroService;

@Controller
@RequestMapping(path = "/livro")
public class LivroController {
	@Autowired
	private LivroService service;

	@Autowired
	private EditoraService editoraService;

	@Autowired
	private AutorService autorService;

	@RequestMapping(path = "")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("livro-lista");
		model.addObject("livros", service.list());
		return model;
	}

	@RequestMapping(path = "/new")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("livro-edicao");
		model.addObject("livro", new LivroDto());
		addLists(model);
		return model;
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView model = new ModelAndView("livro-edicao");
		model.addObject("livro", service.load(id));
		addLists(model);
		return model;
	}

	@RequestMapping(value = "/save")
	public ModelAndView save(@ModelAttribute LivroDto livro) {
		service.save(livro);
		return new ModelAndView("redirect:/livro");
	}

	private void addLists(ModelAndView model) {
		model.addObject("editoras", editoraService.list());
		model.addObject("autores", autorService.list());
	}
}
