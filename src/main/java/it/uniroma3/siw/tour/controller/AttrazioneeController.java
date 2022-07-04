package it.uniroma3.siw.tour.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.tour.model.Attrazione;
import it.uniroma3.siw.tour.service.AttrazioneService;

@Controller
public class AttrazioneeController {
	
	@Autowired
	private AttrazioneService attrazioneService; 

	@GetMapping("/allAttrazioni")
	private String allAttrazioni(Model model) {
		model.addAttribute("attrazioni", this.attrazioneService.getAllAttrazioni());
		return "allAttrazioni";
	}
	
	@GetMapping("/attrazione/{id}")
	private String attrazione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attrazione", this.attrazioneService.attrazioneById(id));
		return "attrazione";
	}
	
	@GetMapping("/admin/attrazioneForm")
	private String getattrazioneForm(Model model) {
		model.addAttribute("attrazione", new Attrazione());
        
        return "/admin/attrazioneForm";
	}
	
	@GetMapping("/admin/deleteattrazione/{id}")
	public String deleteattrazione(@PathVariable("id") Long id) {
		attrazioneService.deleteAttrazioneById(id);
		return "redirect:/allIngredienti";
	}
	
	@PostMapping("/admin/attrazioneForm")
	private String postAttrazioneForm(@Valid @ModelAttribute("attrazione") Attrazione attrazione, BindingResult bindingResult) {
		
		if(!bindingResult.hasErrors()) {
			attrazioneService.saveAttrazione(attrazione);
			return "redirect:/allIngredienti";
		} else {
			return "admin/attrazioneForm";
		}
	}
	
}
