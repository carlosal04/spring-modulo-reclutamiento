package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vacantes")
public class Vacante implements Serializable {

	private static final long serialVersionUID = 8430041856756088810L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String titulo;
	
	private Double salarioMin;
	
	private Double salarioMax;
	
	@Column(name = "habilidad_requerida")
	private String habilidadesRequeridas;
	
	@Column(name = "habilidad_deseada")
	private String habilidadesDeseadas;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "candidato_id")
	private List<Candidato> candidatos;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getSalarioMin() {
		return salarioMin;
	}

	public void setSalarioMin(Double salarioMin) {
		this.salarioMin = salarioMin;
	}

	public Double getSalarioMax() {
		return salarioMax;
	}

	public void setSalarioMax(Double salarioMax) {
		this.salarioMax = salarioMax;
	}

	public void addHabilidadesRequeridas(String habilidad) {
		this.habilidadesRequeridas += habilidad.concat(" \n");
	}
	
	public void addHabilidadesDeseadas(String habilidad) {
		this.habilidadesDeseadas += habilidad.concat(" \n");
	}
	
	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}
	
	public void addCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}

}
