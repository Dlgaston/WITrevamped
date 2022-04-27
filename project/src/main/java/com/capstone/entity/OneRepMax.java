package com.capstone.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "one_rep_max")
public class OneRepMax {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "bench_press_max")
	private Double benchPressMax;
	@Column(name = "squat_max")
	private Double squatMax;
	@Column(name = "overhead_press_max")
	private Double overHeadPressMax;
	@Column(name = "deadlift_max")
	private Double deadliftMax;
	@Column(name = "power_clean_max")
	private Double powerCleanMax;
	
	public OneRepMax() {
		
	}

	public OneRepMax(Double benchPressMax, Double squatMax, Double overHeadPressMax, Double deadliftMax,
			Double powerCleanMax) {
		super();
		this.benchPressMax = benchPressMax;
		this.squatMax = squatMax;
		this.overHeadPressMax = overHeadPressMax;
		this.deadliftMax = deadliftMax;
		this.powerCleanMax = powerCleanMax;
	}

	public Double getBenchPressMax() {
		return benchPressMax;
	}

	public void setBenchPressMax(Double benchPressMax) {
		this.benchPressMax = benchPressMax;
	}

	public Double getSquatMax() {
		return squatMax;
	}

	public void setSquatMax(Double squatMax) {
		this.squatMax = squatMax;
	}

	public Double getOverHeadPressMax() {
		return overHeadPressMax;
	}

	public void setOverHeadPressMax(Double overHeadPressMax) {
		this.overHeadPressMax = overHeadPressMax;
	}

	public Double getDeadliftMax() {
		return deadliftMax;
	}

	public void setDeadliftMax(Double deadliftMax) {
		this.deadliftMax = deadliftMax;
	}

	public Double getPowerCleanMax() {
		return powerCleanMax;
	}

	public void setPowerCleanMax(Double powerCleanMax) {
		this.powerCleanMax = powerCleanMax;
	}
	
}

