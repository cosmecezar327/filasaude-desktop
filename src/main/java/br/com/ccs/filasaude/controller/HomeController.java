package br.com.ccs.filasaude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.ccs.filasaude.repository.PacienteRepository;

@Controller
public class HomeController {

	@Autowired
	private PacienteRepository repository;

	@GetMapping("/")
	public String home(Model model){

	    model.addAttribute("totalPacientes", repository.count());

	    return "home";
	}
}