package edu.adams.backendboys;

import java.sql.Date;

public class SOAPNotes {
	 private String subjective,objective,analysis,plan;
	 private Date date;
	 
	 @SuppressWarnings("unused")
	private SOAPNotes(){
		 
	 }
	 
	 public SOAPNotes(String subjective, String objective, String analysis, String plan, Date date){
		 this.subjective=subjective;
		 this.objective=objective;
		 this.analysis=analysis;
		 this.plan=plan;
		 this.date=date;
	 }
	 
	@Override
	public String toString() {
		return "SOAPNotes [getSubjective()=" + getSubjective()
				+ ", getObjective()=" + getObjective() + ", getAnalysis()="
				+ getAnalysis() + ", getPlan()=" + getPlan() + ", getDate()="
				+ getDate() + "]";
	}

	public String getSubjective() {
		return subjective;
	}

	public String getObjective() {
		return objective;
	}

	public String getAnalysis() {
		return analysis;
	}

	public String getPlan() {
		return plan;
	}

	public Date getDate() {
		return date;
	}

	 
	 
}
