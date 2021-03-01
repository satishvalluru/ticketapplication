package com.java.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.TrainDAO;
import com.java.dto.TrainRequestDTO;
import com.java.dto.TrainResponseDTO;
import com.java.enums.TrainDay;
import com.java.model.Train;
import com.java.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainDAO trainDAO;

	@Override
	public void addTrainDetails(TrainRequestDTO trainRequestDTO) {
		Train train = new Train();
		BeanUtils.copyProperties(trainRequestDTO, train);
		train.getTrainAvailability().add(TrainDay.MONDAY);
		train.getTrainAvailability().add(TrainDay.THURSDAY);
		train.getTrainAvailability().add(TrainDay.SATURDAY);
		trainDAO.addTrainDetails(train);
	}

	@Override
	public List<TrainResponseDTO> searchTrain(String from, String to, String date) {
		List<TrainResponseDTO> trainList = trainDAO.searchTrain(from, to);
		System.out.println(trainList.size());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		int day = 0;
		try {
			day = format.parse(date).getDay();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<TrainResponseDTO> trainListFinal = new ArrayList<>();
		for (TrainResponseDTO train : trainList) {
			train.getTrainAvailability().contains(day);
			trainListFinal.add(train);

		}

		return trainListFinal;
	}

}
