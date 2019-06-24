package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.entity.Vacante;
import com.example.demo.models.service.IVacanteService;
import com.example.demo.util.paginator.PageRender;

@Controller
@RequestMapping("/vacante")
@SessionAttributes("vacante")
public class VacanteController {
	
	@Autowired
	private IVacanteService vacanteService;
	
	@GetMapping({"/listar", "/"})
	public String listarVacantes (@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Vacante> vacantes = vacanteService.findAll(pageRequest);
		PageRender<Vacante> pageRender = new PageRender<Vacante>("/vacante/listar", vacantes);
		
		model.addAttribute("page", pageRender);
		model.addAttribute("vacantes", vacantes);
		model.addAttribute("titulo", "Lista de vacantes");
		
		return "/vacante/listar";
	}
	
	@GetMapping("/crear")
	public String crearVacante(Model model) {
		
		Vacante vacante = new Vacante();
		model.addAttribute("titulo", "Crear vacante");
		model.addAttribute("vacante", vacante);
		return "/vacante/form";
	}
	
	@PostMapping("/guardar")
	public String guardarVacante(@Valid Vacante vacante, BindingResult result,
			Model model, RedirectAttributes flash, SessionStatus status) {
		
		model.addAttribute("titulo", "Crear una vacante");
		
		if(!result.hasErrors()) {
			String mensaje = (vacante.getId() != null) ? "Vacante actualizada con éxito": "Vacante agregada con éxito";
			vacanteService.save(vacante);
			status.setComplete();
			flash.addFlashAttribute("success", mensaje);
			return "redirect:listar";
		}
		
		return "/vacante/form";
	}
	
	@GetMapping("/editar/{id}")
	public String editarVacante(@PathVariable(name = "id") Long id, Model model,
			RedirectAttributes flash) {
		
		Vacante vacante = null;
		
		if(id > 0) {
			vacante = vacanteService.findOne(id);
			if(vacante == null) {
				flash.addFlashAttribute("error", "La vacante no existe");
				return "redirect:/vacante/listar";
			}
			
		} else {
			flash.addFlashAttribute("error", "ID inválido para vacante");
			return "redirect:/vacante/listar";
		}
		model.addAttribute("titulo", "Editar cliente");
		model.addAttribute("vacante", vacante);
		return "/vacante/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarVacante(@PathVariable(name = "id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			Vacante vacante = vacanteService.findOne(id);
			if(vacante != null) {
				vacanteService.delete(id);
				flash.addFlashAttribute("success", "Vacante borrada con éxito");
			} else {
				flash.addFlashAttribute("error", "No existe una vacante con el ID: " + id.toString());
			}
		} else {
			flash.addFlashAttribute("error", "ID de vacante inválida");
		}
		return"redirect:/vacante/listar";
	}

}
