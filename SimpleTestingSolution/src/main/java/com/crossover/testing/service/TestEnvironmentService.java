package com.crossover.testing.service;

import java.util.List;

import com.crossover.testing.model.GradingTable;
import com.crossover.testing.model.QuestionDetailsForUser;
import com.crossover.testing.model.TestDescription;
import com.crossover.testing.model.UserDetails;

public interface TestEnvironmentService {

	public UserDetails getUserDetails(String name, String pwd);
	public void updateUserDetails(UserDetails user);
	public List<QuestionDetailsForUser> getQuestions(int testingId);
	public List<GradingTable> getGradingInfo();
	public TestDescription getTestDescription(int testingId);
}