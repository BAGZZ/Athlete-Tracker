package edu.adams.backendboys;

public class EmergencyContact {
	private String Contact1Name, Contact1Phone, Contact2Name, Contact2Phone;
	
	@SuppressWarnings("unused")
	private EmergencyContact(){
		
	}
	
	public EmergencyContact(String Contact1Name,String Contact1Phone,String Contact2Name,String Contact2Phone){
		this.Contact1Name=Contact1Name;
		this.Contact1Phone=Contact1Phone;
		this.Contact2Name=Contact2Name;
		this.Contact2Phone=Contact1Phone;
	}
	
	@Override
	public String toString() {
		return "EmergencyContact [getContact1Name()=" + getContact1Name()
				+ ", getContact1Phone()=" + getContact1Phone()
				+ ", getContact2Name()=" + getContact2Name()
				+ ", getContact2Phone()=" + getContact2Phone() + "]";
	}

	public String getContact1Name() {
		return Contact1Name;
	}

	public String getContact1Phone() {
		return Contact1Phone;
	}

	public String getContact2Name() {
		return Contact2Name;
	}

	public String getContact2Phone() {
		return Contact2Phone;
	}
	
	
}
