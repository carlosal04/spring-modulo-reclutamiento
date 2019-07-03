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
@Table(name = "vacants")
public class Vacant implements Serializable {

	private static final long serialVersionUID = 8430041856756088810L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String title;
	
	@Column(name = "min_salary", columnDefinition = "Decimal(10,2) default '0.00'")
	private Double minSalary;
	
	@Column(name = "max_salary", columnDefinition = "Decimal(10,2) default '0.00'")
	private Double maxSalary;
	
	@NotEmpty
	@Column(name = "required_skills")
	private String requiredSkills;
	
	@Column(name = "wishable_skills")
	private String wishableSkills;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id")
	private List<Candidate> candidates;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public String getWishableSkills() {
		return wishableSkills;
	}

	public void setWishableSkills(String wishableSkills) {
		this.wishableSkills = wishableSkills;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}
	
	public void addCandidato(Candidate candidate) {
		this.candidates.add(candidate);
	}

}
