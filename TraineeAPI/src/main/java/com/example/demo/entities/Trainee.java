package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int traineeId;
	@NotEmpty(message= "Name of the Trainee must not be empty")
	private String traineeName;
	@NotEmpty(message= "Domain of the Trainee must not be empty")
	private String traineeDomain;
	private String traineeLocation;
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeLocation=" + traineeLocation + "]";
	}
	
}
