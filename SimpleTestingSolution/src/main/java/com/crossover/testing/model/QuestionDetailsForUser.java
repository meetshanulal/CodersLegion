package com.crossover.testing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="questiondetails")
public class QuestionDetailsForUser {
    
	
	@Column(name="testingid")
	private int testingId;
	@Id
	@Column(name="question")
	private String question;
	
	@Column(name="options")
	private String options;
	
	@Column(name="answer")
	private String answer;
	
	@Column(name="questiontag")
	private String questionTag;
	
	@Column(name="ismultiplechoice")
	private int multipleChoice;
	
	@Transient
	private String userResponse;

	public int getTestingId() {
		return testingId;
	}

	public void setTestingId(int testingId) {
		this.testingId = testingId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(String questionTag) {
		this.questionTag = questionTag;
	}

	public int getMultipleChoice() {
		return multipleChoice;
	}

	public void setMultipleChoice(int multipleChoice) {
		this.multipleChoice = multipleChoice;
	}

	public String getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}
}
