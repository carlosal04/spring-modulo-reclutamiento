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
	
	@Column(name = "salario_minimo", columnDefinition = "Decimal(10,2) default '0.00'")
	private Double salarioMin;
	
	@Column(name = "salario_maximo", columnDefinition = "Decimal(10,2) default '0.00'")
	private Double salarioMax;
	
	@NotEmpty
	@Column(name = "habilidades_requeridas")
	private String habilidadesRequeridas;
	
	@Column(name = "habilidades_deseadas")
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

	
	
	public String getHabilidadesRequeridas() {
		return habilidadesRequeridas;
	}

	public void setHabilidadesRequeridas(String habilidadesRequeridas) {
		this.habilidadesRequeridas = habilidadesRequeridas;
	}

	public String getHabilidadesDeseadas() {
		return habilidadesDeseadas;
	}

	public void setHabilidadesDeseadas(String habilidadesDeseadas) {
		this.habilidadesDeseadas = habilidadesDeseadas;
	}

	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}
	
	public void addCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}

}
