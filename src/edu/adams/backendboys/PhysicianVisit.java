package edu.adams.backendboys;

import java.sql.Date;

public class PhysicianVisit {
	Date date;
	String note;
	
	private PhysicianVisit(){
		
	}
	
	public PhysicianVisit(Date date, String note){
		this.date=date;
		this.note=note;
	}
	
	@Override
	public String toString() {
		return "PhysicianVisit [getDate()=" + getDate() + ", getNote()="
				+ getNote() + "]";
	}

	public Date getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}
	
	
}
