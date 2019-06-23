package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.service.IVacanteService;

@Controller
public class VacanteController {
	
	@Autowired
	private IVacanteService vacanteService;
	
	@GetMapping({"/listar", "/"})
	public String listar (Model model) {
		model.addAttribute("titulo", "Lista de vacantes");
		model.addAttribute("vacantes", vacanteService.findAll());
		return "/vacante/listar";
	}

}
