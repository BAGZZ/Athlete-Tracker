package edu.adams.backendboys;
import java.sql.Date;
import java.util.ArrayList;


public class Athlete {
	private String firstName,lastName,cellNumber,YearAtUniversity,eligibility,sports;
	private char middileInital,gender;
	private Date dateOfBirth;
	private int studentID;
	private boolean active;
	private ArrayList<Injury> injuries;
	private EmergencyContact contacts;
	private InsuranceInformation insuranceInfo;
	
	@SuppressWarnings("unused")
	private Athlete(){
		
	}
	
	public Athlete(String firstName,char middleInital, String lastName, Date dateOfBirth,
					String cellNumber,int studentID,char gender,String yearAtUniversity,
					String eligibility, boolean active, String sports,ArrayList<Injury> injuries,
					EmergencyContact contacts, InsuranceInformation insuranceInfo){
		
		this.firstName=firstName;
		this.middileInital=middleInital;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.cellNumber=cellNumber;
		this.studentID=studentID;
		this.gender=gender;
		this.YearAtUniversity=yearAtUniversity;
		this.sports=sports;
		this.injuries=injuries;
		this.contacts=contacts;
		this.insuranceInfo=insuranceInfo;
		
	}

	@Override
	public String toString() {
		return "Athlete [getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getCellNumber()=" + getCellNumber()
				+ ", getYearAtUniversity()=" + getYearAtUniversity()
				+ ", getEligibility()=" + getEligibility() + ", getSports()="
				+ getSports() + ", getMiddileInital()=" + getMiddileInital()
				+ ", getGender()=" + getGender() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getStudentID()=" + getStudentID()
				+ ", isActive()=" + isActive() + ", getInjuries()="
				+ getInjuries() + ", getContacts()=" + getContacts()
				+ ", getInsuranceInfo()=" + getInsuranceInfo() + "]";
	}



	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public String getYearAtUniversity() {
		return YearAtUniversity;
	}

	public String getEligibility() {
		return eligibility;
	}

	public String getSports() {
		return sports;
	}

	public char getMiddileInital() {
		return middileInital;
	}

	public char getGender() {
		return gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public int getStudentID() {
		return studentID;
	}

	public boolean isActive() {
		return active;
	}

	public ArrayList<Injury> getInjuries() {
		return injuries;
	}

	public EmergencyContact getContacts() {
		return contacts;
	}

	public InsuranceInformation getInsuranceInfo() {
		return insuranceInfo;
	}
	
	
}
