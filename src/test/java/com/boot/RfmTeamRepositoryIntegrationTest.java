package com.boot;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boot.model.RfmTeam;
import com.boot.respository.RfmTeamRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class RfmTeamRepositoryIntegrationTest {
	
	@Autowired
	private RfmTeamRepository rfmTeamRespository;
	
	
	@Test
	public void testFindAll()
	{
		List<RfmTeam> wrecks = rfmTeamRespository.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
}
