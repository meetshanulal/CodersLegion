package com.crossover.testing.utils;

import java.util.List;
import java.util.Random;

import com.crossover.testing.model.GradingTable;

public  class TextUtils {

	public  PerformanceSummary calculatePerformance(String userScore,List<GradingTable> gradingInfo)
	{
		String userscore="10";
		if(userScore.isEmpty())
		{
		//userscore=
		Random r = new Random();
		int Low = 5;
		int High = 50;
		int R = r.nextInt(High-Low) + Low;
		userscore= String.valueOf(R);
		}
		
		System.out.println("score is"+ userscore);
		int percent=   (Integer.parseInt(userscore)*2 );
		System.out.println("percent is "+percent);
		
		String grade="";
		String remarks="";
		String hint="";
		/*for(GradingTable grad:gradingInfo)
		{
			String[] split=grad.getScore().split("-");
			System.out.println("splits are "+split);
			if(split.length==1)
			{
				if(percent >=Integer.parseInt(split[0]) && split[0]=="90")
				{
					grade=grad.getGrade();
					remarks=grad.getRemarks();
				}
				if(percent >=Integer.parseInt(split[0]) && split[0]=="50")
				{
					grade=grad.getGrade();
					remarks=grad.getRemarks();
				}
				
			}
			if( percent >=Integer.parseInt(split[0]) && percent <=Integer.parseInt(split[1])  )
			{
				grade=grad.getGrade();
				remarks=grad.getRemarks();
			}
			
			
			
		}*/
		
	   if(percent>=90)
	   {
		   hint="Extremely";
		   grade="A+";
	   }
	   else if(percent<90 && percent>=80)
	   {
		   hint="Subtle";
	   
	       grade="A";
	   }
	   else if(percent>=70 && percent<80)
	   {
		   hint="Skilled";
	       grade="B+";
	   }
	   else if(percent>=60 && percent<70)
	      {
		  hint="Gained";
	       grade="B";
		   
	      }
	   else if(percent>=50 && percent<60) 
	   {
		   hint="Beginner";
	       grade="C";
	   }
	   else if(percent<50)
	   {
		   hint="Sorry";
	       grade="D";
	   }
	   
	   for(GradingTable grad:gradingInfo)
	   {
		   String msg=grad.getRemarks();
		   if(msg.contains(hint))
			   remarks=grad.getRemarks();
	   }
		PerformanceSummary performancSumm= new PerformanceSummary();
		performancSumm.setGrade(grade);
		performancSumm.setRemarks(remarks);
		performancSumm.setScore(String.valueOf(percent));
		return performancSumm;
	}
	
}
