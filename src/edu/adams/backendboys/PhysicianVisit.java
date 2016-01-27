package edu.adams.backendboys;

import java.sql.Date;

public class PhysicianVisit  implements Comparable<PhysicianVisit>{
	Date date;
	String note;
	
	@SuppressWarnings("unused")
	private PhysicianVisit(){
		
	}
	
	public PhysicianVisit(Date date, String note){
		this.date=date;
		this.note=note;
	}
	
	@Override
	public String toString() {
		return getDate() + " "+ getNote();
	}

	public Date getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}

	@Override
	public int compareTo(PhysicianVisit note) {
		return date.compareTo(note.date);
	}
	
	
}
