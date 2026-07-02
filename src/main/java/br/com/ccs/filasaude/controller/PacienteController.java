package br.com.ccs.filasaude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import br.com.ccs.filasaude.model.Paciente;
import br.com.ccs.filasaude.repository.PacienteRepository;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    
    // ABRIR FORMULÁRIO
    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("paciente", new Paciente());
        return "paciente/cadastrar";
    }

    // SALVAR
    @PostMapping("/salvar")
    public String salvar( @ModelAttribute Paciente paciente,Errors errors, Model model){
    	if (errors.hasErrors()) {
    		 return "paciente/cadastrar";
        }
        pacienteRepository.save(paciente);
        model.addAttribute("paciente",new Paciente());
        model.addAttribute("mensagem","Paciente salvo com sucesso!");
        return "redirect:/pacientes/listar";
    }

    // LISTAR
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("lista",pacienteRepository.findAll());
        return "paciente/lista";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id,Model model) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        model.addAttribute( "paciente",paciente);
        return "paciente/cadastrar";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id,Model model) {
        pacienteRepository.deleteById(id);
        model.addAttribute("mensagem","Paciente ID " + id  + " excluído com sucesso");
        model.addAttribute("lista",pacienteRepository.findAll());
        return "redirect:/pacientes/listar";
    }
}
