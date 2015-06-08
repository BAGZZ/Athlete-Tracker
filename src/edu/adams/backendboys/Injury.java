package edu.adams.backendboys;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

public class Injury {
	private int injuryID;
	private String injuryType, season;
	private Boolean active;
	private Date injuryDate;
	ArrayList<SOAPNotes> soapNotes;
	private String latestSOAPNote;
	private String latestProgressNote;
	private String lasestPhysicianVisit;
	private ArrayList<PhysicianVisit> physicianVisits;
	private ArrayList<InjuryProgress> injuryProgressNotes;
	
	@SuppressWarnings("unused")
	private Injury(){

	}
	
	public Injury(int injuryID, String injuryType, Date injuryDate, Boolean active, String season, ArrayList<SOAPNotes> soapNotes, ArrayList<PhysicianVisit> physicianVisits, ArrayList<InjuryProgress> injuryProgressNotes){
		this.injuryID=injuryID;
		this.injuryType=injuryType;
		this.injuryDate=injuryDate;
		this.active=active;
		this.season=season;
		this.soapNotes=new ArrayList<SOAPNotes>(soapNotes);
		this.physicianVisits=new ArrayList<PhysicianVisit>(physicianVisits);
		this.injuryProgressNotes=new ArrayList<InjuryProgress>(injuryProgressNotes);
		Collections.sort(this.injuryProgressNotes);
		latestProgressNote=this.injuryProgressNotes.get(0).toString();
		Collections.sort(this.soapNotes);
		latestProgressNote=this.soapNotes.get(0).toString();
		Collections.sort(this.physicianVisits);
		latestProgressNote=this.physicianVisits.get(0).toString();
	}
	
	@Override
	public String toString() {
		return "Injury [getInjuryID()=" + getInjuryID() + ", getInjuryType()="
				+ getInjuryType() + ", getSeason()=" + getSeason()
				+ ", getActive()=" + getActive() + ", getInjuryDate()="
				+ getInjuryDate() + ", getSoapNotes()=" + getSoapNotes()
				+ ", getPhysicianVisit()=" + getPhysicianVisit()
				+ ", getInjuryProgressNotes()=" + getInjuryProgressNotes()
				+ "]";
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
	public String getLatestSOAPNote() {
		return latestSOAPNote;
	}

	public String getLatestProgressNote() {
		return latestProgressNote;
	}

	public String getLasestPhysicianVisit() {
		return lasestPhysicianVisit;
	}

	public ArrayList<PhysicianVisit> getPhysicianVisit() {
		return physicianVisits;
	}
	public ArrayList<InjuryProgress> getInjuryProgressNotes() {
		return injuryProgressNotes;
	}
	
	
	
}
