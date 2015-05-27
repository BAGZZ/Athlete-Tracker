package edu.adams.backendboys;

import java.sql.Date;

public class InjuryProgress {
	Date date;
	String note;
	
	@SuppressWarnings("unused")
	private InjuryProgress(){
		
	}
	
	public InjuryProgress(Date date, String note){
		this.date=date;
		this.note=note;
	}
	
	@Override
	public String toString() {
		return "InjuryProgress [getDate()=" + getDate() + ", getNote()="
				+ getNote() + "]";
	}

	public Date getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}
	
}
