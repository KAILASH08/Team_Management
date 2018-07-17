package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.boot.model.RfmTeam;
import com.boot.respository.RfmTeamRepository;





@RestController
@RequestMapping("api/v2")
public class RfmTeamController2 
{
	private static final Logger logger = LoggerFactory.getLogger(RfmTeamController2.class);

	@Autowired
	private RfmTeamRepository rfmTeamRepository;
	
	@RequestMapping(value = "rfmTeams", method = RequestMethod.GET)
	public List<RfmTeam> list()
	{
		logger.info("Inside list method of RfmTeamController2");
		return rfmTeamRepository.findAll();
		
	}
	
	@RequestMapping(value = "rfmTeams", method = RequestMethod.POST)
	public RfmTeam create(@RequestBody RfmTeam rfmTeam)
	{
		//logger.info("Inside create method of RfmTeamController2"+rfmTeam.getBirthDate());
		return rfmTeamRepository.saveAndFlush(rfmTeam);
	}
	
	@RequestMapping(value = "rfmTeams/{id}", method = RequestMethod.GET)
	public RfmTeam get(@PathVariable Long id)
	{
		logger.info("Inside get method of RfmTeamController2");
		return rfmTeamRepository.findOne(id);
	}
	
	@RequestMapping(value = "rfmTeams/{id}", method = RequestMethod.PUT)
	public RfmTeam get(@PathVariable Long id, @RequestBody RfmTeam rfmTeam)
	{
		logger.info("Inside get method of RfmTeamController2 with two parameters!");
		RfmTeam existingRfmTeam = rfmTeamRepository.findOne(id);
		BeanUtils.copyProperties(rfmTeam, existingRfmTeam);
		return rfmTeamRepository.saveAndFlush(existingRfmTeam);
	}
	
	@RequestMapping(value = "rfmTeams/{id}", method = RequestMethod.DELETE)
	public RfmTeam delete(@PathVariable Long id)
	{
		logger.info("Inside delete method of RfmTeamController2!");
		RfmTeam existingRfmTeam = rfmTeamRepository.findOne(id);
		rfmTeamRepository.delete(existingRfmTeam);
		return existingRfmTeam;
	}
	
	
	
}
