package com.java.service;

import java.util.List;

import com.java.dto.TrainRequestDTO;
import com.java.dto.TrainResponseDTO;

public interface TrainService {

	void addTrainDetails(TrainRequestDTO trainRequestDTO);

	List<TrainResponseDTO> searchTrain(String from, String to, String date);

	
}
