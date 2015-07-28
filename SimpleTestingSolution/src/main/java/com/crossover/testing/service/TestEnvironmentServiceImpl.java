package com.crossover.testing.service;

import java.util.List;





import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.testing.dao.TestEnvironmentDao;
import com.crossover.testing.model.GradingTable;
import com.crossover.testing.model.QuestionDetailsForUser;
import com.crossover.testing.model.TestDescription;
import com.crossover.testing.model.UserDetails;

@Service
public class TestEnvironmentServiceImpl implements TestEnvironmentService{

	private TestEnvironmentDao testEnvironmentDao;
	
	
	public void setTestEnvironmentDao(TestEnvironmentDao testEnvironmentDao) {
		this.testEnvironmentDao = testEnvironmentDao;
	}

	@Override
	@Transactional
	public UserDetails getUserDetails(String name, String pwd) {
		// TODO Auto-generated method stub
		return this.testEnvironmentDao.getUserDetails(name, pwd);
	}

	@Override
	@Transactional
	public void updateUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		this.testEnvironmentDao.updateUserDetails(user);
	}

	@Override
	@Transactional
	public List<QuestionDetailsForUser> getQuestions(int testingId) {
		// TODO Auto-generated method stub
		return this.testEnvironmentDao.getQuestions(testingId);
	}

	@Override
	@Transactional
	public List<GradingTable> getGradingInfo() {
		// TODO Auto-generated method stub
		return this.testEnvironmentDao.getGradingInfo();
	}

	@Override
	@Transactional
	public TestDescription getTestDescription(int testingId) {
		// TODO Auto-generated method stub
		return this.testEnvironmentDao.getTestDescription(testingId);
	}

}
