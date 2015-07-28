package com.crossover.testing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.crossover.testing.model.GradingTable;
import com.crossover.testing.model.QuestionDetailsForUser;
import com.crossover.testing.model.TestDescription;
import com.crossover.testing.model.UserDetails;
@Repository
public class TestEnvironmentImpl implements TestEnvironmentDao{

	private static final Logger logger = LoggerFactory.getLogger(TestEnvironmentImpl.class);
	 
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserDetails getUserDetails(String name, String pwd) {
		// TODO Auto-generated method stub
	    UserDetails usrDetails=null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crt= session.createCriteria(UserDetails.class);
		crt.add(Restrictions.eq("fullName", name));//userPwd
		crt.add(Restrictions.eq("userPwd", pwd));
		try
		{
		usrDetails= (UserDetails) crt.uniqueResult();
		}catch(HibernateException e)
		{
			logger.debug("Exception occured is "+ e.toString());
		}
		
		return usrDetails;
	}

	@Override
	public void updateUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionDetailsForUser> getQuestions(int testingId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crt= session.createCriteria(QuestionDetailsForUser.class);
		crt.add(Restrictions.eq("testingId", new Integer(testingId)));
		
		List<QuestionDetailsForUser> questionDetailsForUser= (List<QuestionDetailsForUser>) crt.list();
		
		for(QuestionDetailsForUser det:questionDetailsForUser)
		{
			logger.info("Question details obj is "+det);
		}
		
		return questionDetailsForUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradingTable> getGradingInfo() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crt= session.createCriteria(GradingTable.class);
		List<GradingTable> gradingDet= (List<GradingTable>) crt.list();
		return gradingDet;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TestDescription getTestDescription(int testingId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crt= session.createCriteria(TestDescription.class);
		crt.add(Restrictions.eq("testingId", testingId));
		TestDescription testDescp = (TestDescription) crt.uniqueResult();
		return testDescp;
	}

}
