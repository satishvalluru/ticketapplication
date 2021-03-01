package com.java.dto;

import java.util.ArrayList;
import java.util.List;

import com.java.enums.TrainDay;

public class TrainResponseDTO {
	
	private Integer trainId;
	
	private String trainNumber;

	private String trainName;

	private String source;

	private String destination;

	private String arrivalTime;

	private String departureTime;
	
	private List<TrainDay> trainAvailability = new ArrayList<>();


	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public List<TrainDay> getTrainAvailability() {
		return trainAvailability;
	}

	public void setTrainAvailability(List<TrainDay> trainAvailability) {
		this.trainAvailability = trainAvailability;
	}


}
