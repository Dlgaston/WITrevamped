package com.capstone.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "plan_start")
	private LocalDate planStart;
	@Column(name = "plan_end")
	private LocalDate planEnd;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orm_id")
	private OneRepMax ormId;
	
	public Plan() {
		
	}

	public Plan(Long id, String name, LocalDate planStart, LocalDate planEnd, OneRepMax ormId) {
		super();
		this.id = id;
		this.name = name;
		this.planStart = planStart;
		this.planEnd = planEnd;
		this.ormId = ormId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPlanStart() {
		return planStart;
	}

	public void setPlanStart(LocalDate planStart) {
		this.planStart = planStart;
	}

	public LocalDate getPlanEnd() {
		return planEnd;
	}

	public void setPlanEnd(LocalDate planEnd) {
		this.planEnd = planEnd;
	}

	public OneRepMax getOrmId() {
		return ormId;
	}

	public void setOrmId(OneRepMax ormId) {
		this.ormId = ormId;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", planStart=" + planStart + ", planEnd=" + planEnd + ", ormId="
				+ ormId + "]";
	}
	
	
}
