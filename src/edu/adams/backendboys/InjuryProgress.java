package edu.adams.backendboys;

import java.sql.Date;

public class InjuryProgress implements Comparable<InjuryProgress> {
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
		return getDate() + " "+ getNote();
	}

	public Date getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}

	@Override
	public int compareTo(InjuryProgress note) {
		return date.compareTo(note.date);
	}
	
}

	public String getNote() {
		return note;
	}

	@Override
	public int compareTo(InjuryProgress note) {
		return date.compareTo(note.date);
	}
	
}
