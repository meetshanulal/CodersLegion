package com.crossover.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crossover.testing.model.GradingTable;
import com.crossover.testing.model.QuestionDetailsForUser;
import com.crossover.testing.model.QuestionSummary;
import com.crossover.testing.model.UserDetails;
import com.crossover.testing.service.TestEnvironmentService;
import com.crossover.testing.utils.PerformanceSummary;
import com.crossover.testing.utils.TextUtils;
/**
 * Controller for handling client request
 * and managing mvc
 * @author Nikhil
 *
 */
@Controller
public class TestingSolutionController {
	
	private TestEnvironmentService testService;
	
	private UserDetails userDetailSendTo;
	
	private PerformanceSummary performanceSummary;
	
	private List<QuestionDetailsForUser> questions;

	private static final Logger logger = LoggerFactory.getLogger(TestingSolutionController.class);

	@Autowired(required=true)
	@Qualifier(value="testEnvironmentService")
	public void setTestService(TestEnvironmentService testService) {
		this.testService = testService;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		return "home";	
		
	}
	
	@RequestMapping(value="/login/user",method=RequestMethod.POST)
	public String getDescriptionPage(@ModelAttribute("userDetails") UserDetails userDet,Model model,HttpServletRequest request )
	{
		System.out.println("Details recieved in server   name= "+ userDet.getFullName() + " pwd is "+userDet.getUserPwd());
		try{
			
			 userDetailSendTo= (UserDetails) testService.getUserDetails(userDet.getFullName(), userDet.getUserPwd());
			
			 
		}catch(NullPointerException e)
		{
			logger.error("Exception occurred and caught "+ e.toString());
		}
		
		if(userDetailSendTo !=null)
		{
		System.out.println("Testing Id is "+userDetailSendTo.getTestingId() );
		String description=	testService.getTestDescription(userDetailSendTo.getTestingId()).getDescription();
		System.out.println("Test Description is "+ description);
		model.addAttribute("testdesc", description);
		return "testdescription";
		}
		
		else
		{
			String errorTxt="Either full Name or Password is wrong ";
			model.addAttribute("error", errorTxt);
			return "home";
		}
		
		
		
		
	}
	
	@RequestMapping(value="/beginTest/Java",method=RequestMethod.POST)
	public ModelAndView getTestPage(Model model)
	{
		System.out.println("Testing id is "+userDetailSendTo.getTestingId());
		questions = new ArrayList<QuestionDetailsForUser>();
		questions=  (ArrayList<QuestionDetailsForUser>) testService.getQuestions(userDetailSendTo.getTestingId());
	   for(QuestionDetailsForUser quest:questions)
	   {
		   System.out.println("options is " + quest.getOptions());
	   }
		
		QuestionSummary questSummary= new QuestionSummary();
		questSummary.setQuestions(questions);
		//model.addAttribute("questionlist", questSummary);
		
		// return "testpage";
		return new ModelAndView("testpage", "questionlist", questSummary);
		
	}
	
	
	@RequestMapping(value="/submittest",method=RequestMethod.POST)
	public String getResultPage(@ModelAttribute("questionlist") QuestionSummary questionSummary, Model model)
	{
		//ArrayList<QuestionDetailsForUser> questionDetails = (ArrayList<QuestionDetailsForUser>) questionSummary;
		try
		{
		List<QuestionDetailsForUser> questionDetails= (List<QuestionDetailsForUser>) questionSummary.getQuestions();
		
		int count=0;
		for(QuestionDetailsForUser ques:questionDetails)
		{
			System.out.println("Question is "+ques.getQuestion());
		    System.out.println("user response is "+ ques.getUserResponse());
		    System.out.println("answer is  "+ques.getAnswer());
		    QuestionDetailsForUser quesDetail   = (QuestionDetailsForUser)questions.get(count);
		    System.out.println("Inside question object ques is "+ quesDetail.getQuestion()); 
		    System.out.println("Inside question object answer is "+ quesDetail.getAnswer());
		    if(quesDetail.getAnswer()!=null && ques.getUserResponse()!=null)
		    {
		    if(quesDetail.getAnswer().trim().equalsIgnoreCase(ques.getUserResponse().trim()))
		    	 System.out.println("correct answer");
		    else
		    	System.out.println("wrong answer");
		    }
		    
		    count++;
		
		}
		
		List<GradingTable> gradingInfo=  (List<GradingTable>)testService.getGradingInfo();
		for(GradingTable grad:gradingInfo)
		{
			System.out.println("grade "+grad.getGrade() + "remarks "+ grad.getRemarks() + "score "+grad.getScore());
		}
		
		TextUtils textUtils =new TextUtils();
		performanceSummary = textUtils.calculatePerformance("", gradingInfo);
		System.out.println("score" +" grade" + " remarks" + performanceSummary.getScore() +" " + performanceSummary.getGrade()+ " " +performanceSummary.getRemarks());
		model.addAttribute("score", performanceSummary.getScore());
		model.addAttribute("grade", performanceSummary.getGrade());
		model.addAttribute("remarks", performanceSummary.getRemarks());
		
		}catch(NullPointerException e)
		{
			logger.error("Null Pointer Exception is"+e.getMessage());
		}
		
		return "performance";
		
	}
	
	@RequestMapping(value="/finish/results",method=RequestMethod.POST)
	public String reachHome(Model model)
	{
		
		System.out.println("score is "+ performanceSummary.getScore());
		userDetailSendTo.setScore(performanceSummary.getScore());
		userDetailSendTo.setGrade(performanceSummary.getGrade());
		testService.updateUserDetails(userDetailSendTo);		
		
		return "home";
	}
	
	
	
}
