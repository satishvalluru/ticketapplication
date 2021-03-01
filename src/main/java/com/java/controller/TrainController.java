package com.java.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.TrainRequestDTO;
import com.java.dto.TrainResponseDTO;
import com.java.service.TrainService;

@Controller
public class TrainController {

	private static final Logger logger = Logger.getLogger(TrainController.class);

	@Autowired
	TrainService trainService;

	@RequestMapping(value = "/trains", method = RequestMethod.POST)
	@ResponseBody
	public String addTrainDetails(@RequestBody TrainRequestDTO trainRequestDTO) {
		trainService.addTrainDetails(trainRequestDTO);
		return "Train details added successfully";
	}

	@RequestMapping(value = "/trains", method = RequestMethod.GET)
	@ResponseBody
	public List<TrainResponseDTO> searchTrains(@RequestParam String from, @RequestParam String to,
			@RequestParam String date) {
		List<TrainResponseDTO> trainResponse = trainService.searchTrain(from, to, date);
		return trainResponse;
	}

}