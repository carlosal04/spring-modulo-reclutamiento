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

import com.example.demo.models.entity.Vacant;
import com.example.demo.models.service.VacantService;
import com.example.demo.util.paginator.PageRender;

@Controller
@RequestMapping("/vacante")
@SessionAttributes("vacante")
public class VacantController {
	
	@Autowired
	private VacantService vacantService;
	
	@GetMapping({"/listar", "/"})
	public String list (@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Vacant> vacants = vacantService.findAll(pageRequest);
		PageRender<Vacant> pageRender = new PageRender<Vacant>("/vacant/list", vacants);
		
		model.addAttribute("page", pageRender);
		model.addAttribute("vacants", vacants);
		model.addAttribute("title", "Lista de vacantes");
		
		return "/vacant/list";
	}
	
	@GetMapping("/crear")
	public String create(Model model) {
		
		Vacant vacant = new Vacant();
		model.addAttribute("title", "Crear vacante");
		model.addAttribute("vacant", vacant);
		return "/vacant/form";
	}
	
	@PostMapping("/guardar")
	public String save(@Valid Vacant vacant, BindingResult result,
			Model model, RedirectAttributes flash, SessionStatus status) {
		
		model.addAttribute("title", "Crear una vacante");
		if(!result.hasErrors()) {
			String mensaje = (vacant.getId() != null) ? "Vacante actualizada con éxito": "Vacante agregada con éxito";
			vacantService.save(vacant);
			status.setComplete();
			flash.addFlashAttribute("success", mensaje);
			return "redirect:/vacante/listar";
		}
		
		return "/vacant/form";
	}
	
	@GetMapping("/editar/{id}")
	public String edit(@PathVariable(name = "id") Long id, Model model,
			RedirectAttributes flash) {
		
		Vacant vacant = null;
		
		if(id > 0) {
			vacant = vacantService.findOne(id);
			if(vacant == null) {
				flash.addFlashAttribute("error", "La vacante no existe");
				return "redirect:/vacante/listar";
			}
			
		} else {
			flash.addFlashAttribute("error", "ID inválido para vacante");
			return "redirect:/vacante/listar";
		}
		model.addAttribute("title", "Editar cliente");
		model.addAttribute("vacant", vacant);
		return "/vacant/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable(name = "id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			Vacant vacant = vacantService.findOne(id);
			if(vacant != null) {
				vacantService.delete(id);
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
