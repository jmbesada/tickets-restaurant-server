package com.qwi.josemi.ticketsRestaurant.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwi.josemi.ticketsRestaurant.domain.UserDocument;
import com.qwi.josemi.ticketsRestaurant.repository.UserRepository;

@Controller
@RequestMapping("/statisticsController")
public class StatisticsController {

	@Autowired UserRepository userRepository;
	
	@RequestMapping("/getUserAccess")
	public void getUserAccess(HttpServletResponse response) throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), userRepository.findAllOrderByAccessNumber());
		
	}
}
