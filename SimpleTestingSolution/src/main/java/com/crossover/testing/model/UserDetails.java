package com.crossover.testing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dao class for Table userdetails
 * @author Nikhil
 *
 */


@Entity
@Table(name="userdetails")
public class UserDetails {
	@Id
    @Column(name="userid")
	private int userId;
	
	@Column(name="fullname")
	private String fullName;

	
	@Column(name="userpwd")
	private String userPwd;
	
	@Column(name="score")
	private String score;
	
	@Column(name="testingid")
	private int testingId;
	
	@Column(name="grade")
	private String grade;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getTestingId() {
		return testingId;
	}

	public void setTestingId(int testingId) {
		this.testingId = testingId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	  @Override
	    public String toString(){
	        return "testingId= "+testingId+", fullName= "+fullName+", score= "+score;
	    }
}
