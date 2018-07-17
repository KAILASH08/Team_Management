package com.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.RfmTeamController;
import com.boot.model.RfmTeam;
import com.boot.respository.RfmTeamRepository;

public class RfmTeamControllerTest 
{
	@InjectMocks
	private RfmTeamController sc;
	
	@Mock
	private RfmTeamRepository rfmTeamRepository;
	
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRfmTeamGet()
	{
		RfmTeam sw = new RfmTeam();
		sw.setId(1l);
		when(rfmTeamRepository.findOne(1l)).thenReturn(sw);
		
		RfmTeam wreck = sc.get(1L);
		
		verify(rfmTeamRepository).findOne(1l);
		
		
		//assertEquals(1l, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1l));  //Hamcrest Matchers
		
		
	}
}
