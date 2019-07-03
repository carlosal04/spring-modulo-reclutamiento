package com.example.demo.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrevistas")
public class Entrevista implements Serializable {

	private static final long serialVersionUID = 4551314538701339817L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fecha;
	
	private LocalTime hora;
	
	private String tipoEntrevista;
	
	private String retroalimentacion;
	
	private boolean esAprobado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Candidato candidato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Empleado empleado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getTipoEntrevista() {
		return tipoEntrevista;
	}

	public void setTipoEntrevista(String tipoEntrevista) {
		this.tipoEntrevista = tipoEntrevista;
	}

	public String getRetroalimentacion() {
		return retroalimentacion;
	}

	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}

	public boolean isEsAprobado() {
		return esAprobado;
	}

	public void setEsAprobado(boolean esAprobado) {
		this.esAprobado = esAprobado;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	

}
