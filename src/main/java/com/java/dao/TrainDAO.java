package com.java.dao;

import java.util.List;

import com.java.dto.TrainResponseDTO;
import com.java.model.Train;

public interface TrainDAO {

	void addTrainDetails(Train train);

	List<TrainResponseDTO> searchTrain(String from, String to);


}

