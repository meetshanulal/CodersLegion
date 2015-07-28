package com.crossover.testing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="testdescription")
public class TestDescription {
    @Id
    @Column(name="testingid")
	private int testingId;
    
    
    public int getTestingId() {
		return testingId;
	}


	public void setTestingId(int testingId) {
		this.testingId = testingId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String Description) {
		description = Description;
	}


	@Column(name="description")
    private String description;
	
	
	@Override
    public String toString(){
        return "testingId= "+testingId+", description= "+description;
    }
	
	
}
