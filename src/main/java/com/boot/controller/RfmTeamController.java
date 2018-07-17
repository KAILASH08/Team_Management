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
@RequestMapping("api/v1")
public class RfmTeamController 
{
	private static final Logger logger = LoggerFactory.getLogger(RfmTeamController.class);

	@Autowired
	private RfmTeamRepository rfmTeamRepository;
	
	@RequestMapping(value = "rfmTeams", method = RequestMethod.GET)
	public List<RfmTeam> list()
	{
		logger.info("Inside list method of RfmTeamController");
		return rfmTeamRepository.findAll();
		
	}
	
	@RequestMapping(value = "rfmTeams", method = RequestMethod.POST)
	public RfmTeam create(@RequestBody RfmTeam rfmTeam)
	{
		//logger.info("Inside create method of RfmTeamController"+rfmTeam.getBirthDate());
		return rfmTeamRepository.saveAndFlush(rfmTeam);
	}
	
	@RequestMapping(value = "rfmTeams/{id}", method = RequestMethod.GET)
	public RfmTeam get(@PathVariable Long id)
	{
		logger.info("Inside get method of RfmTeamController");
		return rfmTeamRepository.findOne(id);
	}
	
	@RequestMapping(value = "rfmTeams/{id}", method = RequestMethod.PUT)
	public RfmTeam get(@PathVariable Long id, @RequestBody RfmTeam rfmTeam)
	{
		logger.info("Inside get method of RfmTeamController with two parameters!");
		RfmTeam existingRfmTeam = rfmTeamRepository.findOne(id);
		BeanUtils.copyProperties(rfmTeam, existingRfmTeam);
		return rfmTeamRepository.saveAndFlush(existingRfmTeam);
	}
	
	@RequestMapping(value = "rfmTeams/{id}", method = RequestMethod.DELETE)
	public RfmTeam delete(@PathVariable Long id)
	{
		logger.info("Inside delete method of RfmTeamController!");
		RfmTeam existingRfmTeam = rfmTeamRepository.findOne(id);
		rfmTeamRepository.delete(existingRfmTeam);
		return existingRfmTeam;
	}
	
	
	
}
