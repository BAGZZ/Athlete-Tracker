package edu.adams.backendboys;

import java.sql.Date;
import java.util.ArrayList;

public class Injury {
	private int injuryID;
	private String injuryType, season;
	private Boolean active;
	private Date injuryDate;
	ArrayList<SOAPNotes> soapNotes;
	ArrayList<PhysicianVisit> physicianVisits;
	ArrayList<InjuryProgress> injuryProgressNotes;
	
	@SuppressWarnings("unused")
	private Injury(){

	}
	
	public Injury(int injuryID, String injuryType, Date injuryDate, Boolean active, String season, ArrayList<SOAPNotes> soapNotes, ArrayList<PhysicianVisit> physicianVisits, ArrayList<InjuryProgress> injuryProgressNotes){
		this.injuryID=injuryID;
		this.injuryType=injuryType;
		this.injuryDate=injuryDate;
		this.active=active;
		this.season=season;
		this.soapNotes=soapNotes;
		this.physicianVisits=physicianVisits;
		this.injuryProgressNotes=injuryProgressNotes;
	}
	
	@Override
	public String toString() {
		return getInjuryType();
	}


	public int getInjuryID() {
		return injuryID;
	}
	public String getInjuryType() {
		return injuryType;
	}
	public String getSeason() {
		return season;
	}
	public Boolean getActive() {
		return active;
	}
	public Date getInjuryDate() {
		return injuryDate;
	}
	public ArrayList<SOAPNotes> getSoapNotes() {
		return soapNotes;
	}
	public ArrayList<PhysicianVisit> getPhysicianVisit() {
		return physicianVisits;
	}
	public ArrayList<InjuryProgress> getInjuryProgressNotes() {
		return injuryProgressNotes;
	}
	
	
	
}
