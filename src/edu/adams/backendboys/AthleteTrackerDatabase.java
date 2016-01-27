package edu.adams.backendboys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
 * add character quotes around every string
 * add editEmergencyContact
 * add add/remove Coach
 * add GenerateReport()
 */
public class AthleteTrackerDatabase {
	private Database database;
	private ArrayList<Athlete> lastSearch = new ArrayList<Athlete>();
	
	public AthleteTrackerDatabase(){
		database=new SQLiteDatabase();
	}
	
	public ArrayList<Athlete> searchDatabase(String firstName, String middleInitial, String lastName, 
											String sport, String bodyPart, String injuryType, String activeInjuries,
											Date start, Date end, String StudentID, String Season,
											String gender){
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		//GET LIST OF ATHLETES FROM ATHLETES TABLE THAT MEET ABOVE REQUIREMENTS
		ArrayList<Integer> studentIDs = parseAthleteInfoAndSearch(firstName, middleInitial, lastName, StudentID, gender);
		
		//ATHLETE SPORTS TABLE
		String sportID="";
		if(sport.equalsIgnoreCase("") || sport.equalsIgnoreCase("Any Sport")){
			
		}else{
			sportID="="+getSportID(sport)+"";
			if(!sportID.contains("-1")){
				studentIDs.retainAll(getAthleteIDsFromSportID(sportID));
			}
		}

		//Gets a List of Student IDs that meet the Injury Info passed in. If everything is set to default, then it returns an empty list and we don't limit the results by what is in the Injury Table
		 int bodyPartID=getBodyPartID(bodyPart);
		 ArrayList<Integer> injuryStudentIDs =parseInjuryInfoAndSearch(injuryType, bodyPartID,activeInjuries, start, end, Season);
		 if(!(injuryStudentIDs==null)){
			studentIDs.retainAll(injuryStudentIDs);
		 }
		
		for(Integer studentID : studentIDs){
			athletes.add(getAthleteByID(studentID));
		}
		lastSearch= new ArrayList<Athlete>(athletes);
		return new ArrayList<Athlete>(athletes);
	}
	
	private ArrayList<Integer> getStudentIDsbyInjury(String injuryTypeID,
			String active, String dateString, String season) {
		ArrayList<ArrayList<String>> temp;
		ArrayList<Integer> studentIDs = new ArrayList<Integer>();
		String table="INJURIES";
		String[][] data= {{injuryTypeID},{active},{dateString},{season}};
		temp = database.select(table, data[0]);
		for(int count=1;count<data.length;count++){
			temp.retainAll(database.select(table, data[count]));
		}
		for(ArrayList<String> injury : temp){
			studentIDs.add(Integer.parseInt(injury.get(1)));
		}
		return studentIDs;
	}

	private ArrayList<Integer> getAthleteIDsFromSportID(String sportID) {
		ArrayList<Integer> athleteIDs = new ArrayList<Integer>();
		String table="ATHLETESPORTS";
		String[] data= {"SPORTID="+sportID};
		for(ArrayList<String> athleteSportRelation : database.select(table, data)){
			athleteIDs.add(Integer.parseInt(athleteSportRelation.get(0)));
		}
		return athleteIDs;
	}

	public ArrayList<String> getSports(){
		ArrayList<String> sports= new ArrayList<String>();
		sports.add("Any Sport");
		String[] data = {"SPORTID IS NOT NULL"};
		ArrayList<ArrayList<String>> temp = database.select("SPORTS", data);
		if(temp == null){
			ArrayList<String> empty= new ArrayList<String>();
			empty.add("empty");
			return empty;
		}
		else{
			for(ArrayList<String> pairs : temp){
				sports.add(pairs.get(1));
			}
		return sports;
		}
	}
	
	public int getSportID(String sport){
		String[] data={"SPORTNAME='"+sport+"'"};
		int id=-1;
		for(ArrayList<String> sports : database.select("SPORTS", data)){
			id=Integer.parseInt(sports.get(0));
		}
		return id;
	}
	
	public ArrayList<String> getInjuryTypes(){
		ArrayList<String> injuryTypes= new ArrayList<String>();
		injuryTypes.add("Any");
		String[] data = {"INJURYTYPE IS NOT NULL"};
		ArrayList<ArrayList<String>> temp = database.select("INJURYTYPE", data);
		for(ArrayList<String> pairs : temp){
			injuryTypes.add(pairs.get(2));
		}
		return injuryTypes;
	}
	
	int getInjuryTypeID(String injuryType, int bodypartID){
		String injuryID= "-1";
		String[] data = {"BODYPARTID="+bodypartID};
		ArrayList<ArrayList<String>> temp = database.select("INJURYTYPE", data);
		for(ArrayList<String> tuple : temp){
			if(tuple.get(2).equalsIgnoreCase(injuryType)){
				injuryID=(tuple.get(0));
			}
		}
		return Integer.parseInt(injuryID);
	}
	
	public ArrayList<String> getInjuryTypeByBodyPart(String bodyPart){
		ArrayList<String> injuryTypes = new ArrayList<String>();
		injuryTypes.add("Any");
		int partID;
		if(bodyPart.equalsIgnoreCase("Any")){
			partID=-1;
		}else{
			partID = getBodyPartID(bodyPart);
		}
		String[] data = {""};
		if(partID==-1){
			data[0]="BODYPARTID IS NOT NULL";
		}else{
			data[0]="BODYPARTID="+partID;
		}
		for(ArrayList<String> injuryType : database.select("INJURYTYPE", data)){
			injuryTypes.add(injuryType.get(2));
		}
		return new ArrayList<String>(injuryTypes);
	}
	
	public int getBodyPartID(String bodyPart){
		int id=-1;
		String[] data = {"BODYPART='"+bodyPart+"'"};
		for(ArrayList<String> part : database.select("BODYPART", data)){
			id=Integer.parseInt(part.get(0));
		}
		return id;
	}
	
	public String getBodyPart(int id){
		String output="";
		String[] data = {"BODYPARTID="+id};
		if(id>=1){
			output=database.select("BODYPART", data).get(0).get(1);
		}
		return output;
	}
	//needs a change
	public ArrayList<String> getAllBodyParts(){
		ArrayList<String> bodyParts = new ArrayList<String>();
		bodyParts.add("Any");
		String[] data ={"BODYPARTID IS NOT NULL"};
		//empty
			ArrayList<String> empty= new ArrayList<String>();
			empty.add("empty");
			return empty;
//		for(ArrayList<String> parts: database.select("BODYPART", data)){
//			bodyParts.add(parts.get(1));
//		}
//		return new ArrayList<String>(bodyParts);
	}
	
	public Athlete getAthleteByID(Integer id){
		String[] idData = {"STUDENTID="+id};
		ArrayList<String> temp=database.select("ATHLETE", idData).get(0);
		int studentID = Integer.parseInt(temp.get(0));
		String firstName = temp.get(1);
		char middleInitial = temp.get(2).charAt(0);
		String lastName = temp.get(3);
		java.sql.Date dateOfBirth = java.sql.Date.valueOf(temp.get(4));
		String cellNumber = temp.get(5);
		
		char gender = temp.get(6).charAt(0);
		String yearAtUniversity = temp.get(7);
		String eligibility = temp.get(8);
		boolean active;
		if(temp.get(9).equalsIgnoreCase("0")){
			active=false;
		}else{
			active=true;
		}
		String allergies = temp.get(10);
		String medications = temp.get(11);
		
		
		
		
		//from AthleteSports and Sports tables
		String sports = "";
		ArrayList<Integer> sportIDs=new ArrayList<Integer>();
		ArrayList<ArrayList<String>> tempStorage = database.select("ATHLETESPORTS", idData);
		for(ArrayList<String> pairs : tempStorage){
			sportIDs.add(Integer.parseInt(pairs.get(1)));
		}
		String[] sportData = {" "};
		for(int count = 0; count<sportIDs.size()-1;count++){
			sportData[0]="SPORTID="+sportIDs.get(count);
			sports+=database.select("SPORTS",sportData ).get(0).get(1)+",";
		}
		sportData[0]="SPORTID="+sportIDs.get(sportIDs.size()-1);
		sports+=database.select("SPORTS",sportData ).get(0).get(1);
		
		
		//From Injury Table
		ArrayList<Injury> injuries = new ArrayList<Injury>();
		tempStorage= new ArrayList<ArrayList<String>>();
		tempStorage= database.select("INJURIES", idData);
		ArrayList<ArrayList<String>> innerTempStorage = new ArrayList<ArrayList<String>>();
		int injuryID;
		String injuryType;
		java.sql.Date injuryDate;
		String season; 
		boolean activeInjury;
		String subjective;
		String objective;
		String assessment;
		java.sql.Date soapDate;
		java.sql.Date visitDate;
		String visitNote;
		for(ArrayList<String> injury : tempStorage){
			injuryID = Integer.parseInt(injury.get(0));
			injuryType = getInjuryType(Integer.parseInt(injury.get(2)));
			injuryDate=java.sql.Date.valueOf(injury.get(3));
			activeInjury=true;
			if(injury.get(4).contains("0")){
				activeInjury=false;
			}
			season = injury.get(5);
			
			//database search for all relevant SOAPnotes
			ArrayList<SOAPNotes> soapNotes = new ArrayList<SOAPNotes>();
			innerTempStorage = new ArrayList<ArrayList<String>>();
			String[] injuryIDData = {"INJURYID="+injuryID};
			innerTempStorage= database.select("SOAPNOTES", injuryIDData);
			for(ArrayList<String> soapNote : innerTempStorage){
				subjective=soapNote.get(1);
				objective=soapNote.get(2);
				assessment= soapNote.get(3);
				String plan= soapNote.get(4);
				soapDate= java.sql.Date.valueOf(soapNote.get(5));
				soapNotes.add(new SOAPNotes(subjective, objective, assessment, plan, soapDate));
			}
			
			//database search for all relevant physician notes
			ArrayList<PhysicianVisit> physicianVisits = new ArrayList<PhysicianVisit>();
			innerTempStorage = new ArrayList<ArrayList<String>>();
			innerTempStorage= database.select("PHYSICIANVISIT", injuryIDData);
			for(ArrayList<String> physicianVisit : innerTempStorage){
				visitDate = java.sql.Date.valueOf(physicianVisit.get(1));
				visitNote = physicianVisit.get(2);
				physicianVisits.add(new PhysicianVisit(visitDate, visitNote));
			}
			

			
			//database for all relevant progress notes
			ArrayList<InjuryProgress> injuryProgressNotes = new ArrayList<InjuryProgress>();
			innerTempStorage = new ArrayList<ArrayList<String>>();
			innerTempStorage= database.select("INJURYPROGRESS", injuryIDData);
			for(ArrayList<String> injuryProgress : innerTempStorage){
				visitDate = java.sql.Date.valueOf(injuryProgress.get(1));
				visitNote = injuryProgress.get(2);
				injuryProgressNotes.add(new InjuryProgress(visitDate, visitNote));
			}
			
			injuries.add(new Injury(injuryID, injuryType, injuryDate, activeInjury, season, soapNotes, physicianVisits, injuryProgressNotes));
		}
		
		//database search to get contacts from db
		tempStorage=new ArrayList<ArrayList<String>>();
		tempStorage= database.select("INJURIES", idData);
		String Contact1Name="";
		String Contact1Phone="";
		String Contact2Name="";
		String Contact2Phone="";
		for(ArrayList<String> contact: tempStorage){
			Contact1Name=contact.get(1);
			Contact1Phone=contact.get(2);
			Contact2Name=contact.get(3);
			Contact2Phone=contact.get(4);
		}
	
		EmergencyContact contacts= new EmergencyContact(Contact1Name, Contact1Phone, Contact2Name, Contact2Phone);
		
		//database search to get insurance Info
		tempStorage=new ArrayList<ArrayList<String>>();
		tempStorage= database.select("INSURANCEINFORMATION", idData);
		String studentSSN="";
		try {
			
			studentSSN = Encryption.decrypt(tempStorage.get(0).get(1));
		} catch (Exception e) {
			studentSSN="Failed to get SSN";
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		String companyName=tempStorage.get(0).get(2);
		String insurancePhone=tempStorage.get(0).get(3);
		String policyID = tempStorage.get(0).get(4);
		String groupNumber = tempStorage.get(0).get(5);
		String address = tempStorage.get(0).get(6);
		java.sql.Date policyEffective = java.sql.Date.valueOf(tempStorage.get(0).get(7));
		java.sql.Date policyExpiration = java.sql.Date.valueOf(tempStorage.get(0).get(8));
		boolean coverAthleticInjury = true;
		if(tempStorage.get(0).get(9).contains("0")){
			coverAthleticInjury=false;
		}
		String preCertPhone = tempStorage.get(0).get(10);
		String policyHolder = tempStorage.get(0).get(11);
		String policyHolderPhone = tempStorage.get(0).get(12);
		String policyHolderAddress = tempStorage.get(0).get(13);
		int limit = Integer.parseInt(tempStorage.get(0).get(14));
		int deductible = Integer.parseInt(tempStorage.get(0).get(15));
		int coPay = Integer.parseInt(tempStorage.get(0).get(16));
		boolean referral = true;
		if(tempStorage.get(0).get(17).contains("0")){
			referral = false;
		}
		String primaryPhysician = tempStorage.get(0).get(17);
		String physicianPhone = tempStorage.get(0).get(18);
		
		
		InsuranceInformation insuranceInfo = new InsuranceInformation(studentSSN, companyName, insurancePhone, policyID, groupNumber, address, policyEffective, policyExpiration, coverAthleticInjury, preCertPhone, policyHolder, policyHolderPhone, policyHolderAddress, limit, deductible, coPay, referral, primaryPhysician, physicianPhone);
		
		
		
		return new Athlete(firstName, middleInitial, lastName, dateOfBirth, cellNumber, studentID, gender, yearAtUniversity, eligibility, active, allergies, medications, sports, injuries, contacts, insuranceInfo);
	}
	
	private String getInjuryType(int injuryTypeID) {
		String[] data = {"INJURYTYPEID="+injuryTypeID};
		return database.select("INJURYTYPE", data).get(0).get(2);
	}
		
	public boolean addBodyPart(String bodyPart){
		String table = "BODYPART";
		String[] data = {"(BODYPART)",""};
		data[1]=bodyPart;
		return database.insert(table, data);
	}
	
	public boolean addInjury(Athlete currentAthlete,Injury injury){
		String table ="INJURIES";
		String activeString="";
		boolean output=true;
		if(injury.getActive()){
			activeString="1";
		}else{
			activeString="0";
		}
		String[] data = {"(STUDENTID,INJURYTYPEID,INJURYDATE,ACTIVE,SEASON)", ""+currentAthlete.getStudentID()+",", ""+getInjuryTypeID(injury.getInjuryType(),injury.getBodyPartID())+",", "'"+injury.getInjuryDate()+"',",activeString+",","'"+injury.getSeason()+"'" };
		/*for(String word : data){
			System.out.print(word+"\t");
		}
		System.out.println();*/
		output = output && database.insert(table, data);
		
		//get injury id
		//String[] searchData={"STUDENTID="+currentAthlete.getStudentID()+",","INJURYTYPEID="+getInjuryTypeID(injury.getInjuryType(),injury.getBodyPartID())+",","INJURYDATE='"+injury.getInjuryDate()+"',","ACTIVE="+activeString+",","SEASON='"+injury.getSeason()+"'"};
		String[][] searchData={{"STUDENTID="+currentAthlete.getStudentID()},{"INJURYTYPEID="+getInjuryTypeID(injury.getInjuryType(),injury.getBodyPartID())},{"INJURYDATE='"+injury.getInjuryDate()+"'"},{"ACTIVE="+activeString},{"SEASON='"+injury.getSeason()+"'"}};
		ArrayList<ArrayList<String>> temp = database.select(table, searchData[0]);
		for(int count =1; count<temp.size();count++){
			temp.retainAll(database.select(table, searchData[count]));
		}
		int injuryID=Integer.parseInt(temp.get(0).get(0));
		String[] soapData = new String[7];
		for(SOAPNotes soap: injury.getSoapNotes()){
			soapData[0]="(INJURYID,SUBJECTIVE,OBJECTIVE,ASSESSMENT,PLAN,DATE)";
			soapData[1]=""+injuryID+",";
			soapData[2]="'"+soap.getSubjective()+"',";
			soapData[3]="'"+soap.getObjective()+"',";
			soapData[4]="'"+soap.getAssessment()+"',";
			soapData[5]="'"+soap.getPlan()+"',";
			soapData[6]="'"+soap.getDate()+"'";
			database.insert("SOAPNOTES", soapData);
		}
		String[] progressData = new String[4];
		for(InjuryProgress progress: injury.getInjuryProgressNotes()){
			progressData[0]="(INJURYID,DATE,NOTE)";
			progressData[1]=""+injuryID+",";
			progressData[2]="'"+progress.getDate()+"',";
			progressData[3]="'"+progress.getNote()+"'";
			database.insert("INJURYPROGRESS", progressData );
		}
		
		String[] doctorData = new String[4];
		for(PhysicianVisit visit: injury.getPhysicianVisit()){
			doctorData[0]="(INJURYID,DATE,NOTE)";
			doctorData[1]=""+injuryID+",";
			doctorData[2]="'"+visit.getDate()+"',";
			doctorData[3]="'"+visit.getNote()+"'";
			database.insert("PHYSICIANVISIT", doctorData );
		}
		return output;
	}
	
	public boolean addSport(String sport){
		String table= "SPORTS";
		String[] data = {"(SPORTNAME)",""};
		data[1]=sport;
		return database.insert(table, data);
	}

	private ArrayList<Integer> parseAthleteInfoAndSearch(String firstName,String middleInitial, String lastName, String studentID, String gender){
		ArrayList<Integer> ids=new ArrayList<Integer>();
		//if anything is empty we pass not null into the search
		//ATHLETE TABLE
		if(firstName.equalsIgnoreCase("")){
			firstName="IS NOT NULL";
		}else{
			firstName="='"+firstName+"'";
		}
		
		if(middleInitial.equalsIgnoreCase("")){
			middleInitial="IS NOT NULL";
		}else{
			middleInitial="='"+middleInitial.toUpperCase().charAt(0)+"'";
		}
		
		if(lastName.equalsIgnoreCase("")){
			lastName="IS NOT NULL";
		}else{
			lastName="='"+lastName+"'";
		}
		
		if(studentID.equalsIgnoreCase("")){
			studentID="IS NOT NULL";
		}else{
			studentID="="+studentID;
		}
		
		if(gender.equalsIgnoreCase("") || (gender.toUpperCase().charAt(0)!='M' && gender.toUpperCase().charAt(0)!='F')){
			gender="IS NOT NULL";
		}else{
			gender="='"+gender.toUpperCase().charAt(0)+"'";
		}
		String[][] data ={{"FIRSTNAME"+firstName}, {"MIDDLEINITIAL"+middleInitial}, {"LASTNAME"+lastName}, {"STUDENTID"+studentID}, {"GENDER"+gender}};
		
		if(firstName.equalsIgnoreCase("IS NOT NULL")){
			data[0][0]="";
		}
		
		if(middleInitial.equalsIgnoreCase("IS NOT NULL")){
			data[1][0]="";
		}
		
		if(lastName.equalsIgnoreCase("IS NOT NULL")){
				data[2][0]="";
		}
		
		if(studentID.equalsIgnoreCase("IS NOT NULL")){
			data[3][0]="";
		}
		
		if(gender.equalsIgnoreCase("IS NOT NULL")){
			data[4][0]="";
		}
				
				
				
		ArrayList<ArrayList<String>> temp = database.select("ATHLETE", data[0]);
		for(int count=1; count<data.length; count++){
			temp.retainAll(database.select("ATHLETE", data[count]));
		}
		for(ArrayList<String> athlete : temp){
			ids.add(Integer.parseInt(athlete.get(0)));
		}
		return new ArrayList<Integer>(ids);
	}
	
	private ArrayList<Integer> parseInjuryInfoAndSearch(String injuryType, int bodyPartID,String activeInjuries,Date start, Date end, String Season){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		String dateString="";
		String injuryTypeID="";
		java.sql.Date startSQL= null;
		java.sql.Date endSQL = null;
		if(injuryType.equalsIgnoreCase("") || injuryType.equalsIgnoreCase("Any")){
			injuryTypeID="";
		}else{
			injuryTypeID="INJURYID='"+getInjuryTypeID(injuryType,bodyPartID)+"'";
		}
		String active="";
		if(activeInjuries.equalsIgnoreCase("Active")){
			active="ACTIVE=1";
		}else if(activeInjuries.equalsIgnoreCase("Inactive")){
			active="ACTIVE=0";
		}else{
			active="";
		}
		
		if(start.compareTo(end)!=-1){
			dateString="";
		}else{
			startSQL= new java.sql.Date(start.getTime());
			endSQL= new java.sql.Date(end.getTime());
			dateString="INJURYDATE BETWEEN '"+startSQL.toString()+"' AND '"+endSQL.toString()+"'";
		}
		if(Season.equalsIgnoreCase("")){
			Season="";
		}else{
			Season="SEASON='"+Season+"'";
		}
		
		if(injuryTypeID.equalsIgnoreCase("") && active.equalsIgnoreCase("") && dateString.equalsIgnoreCase("") && Season.equalsIgnoreCase("")){
			return null;
		}else{
			ids = new ArrayList<Integer>(getStudentIDsbyInjury(injuryTypeID, active, dateString, Season));
			return new ArrayList<Integer>(ids);
		}
		
	}
	
	public ArrayList<String> getAllInjuryStatus(){
		ArrayList<String> output= new ArrayList<String>();
		output.add("Active/Inactive");
		output.add("Active");
		output.add("Inactive");
		return output;
	}
	
	public ArrayList<String> getSeasons(){
		ArrayList<String> output= new ArrayList<String>();
		String[] seasons = {"Fall","Winter","Spring","Summer"};
		int[] years = {Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.YEAR)-1, Calendar.getInstance().get(Calendar.YEAR)-2 };
		for(int year : years){
			for(String season : seasons){
				output.add(season+" "+year);
			}
		}
		return output;
	}
	
	public boolean addAthlete(Athlete player){
		boolean output=true;
		
		//add to Athlete Table
		if(output){
			String activeAthlete = "1";
			if(!player.isActive()){
				activeAthlete="0";
			}
			String[] athleteData= {"(FIRSTNAME, MIDDLEINITIAL, LASTNAME, DATEOFBIRTH, CELLNUMBER, STUDENTID,"
									+ " GENDER, YEARATUNIVERSITY, ELIGIBILITY, ACTIVE, ALLERGIES, MEDICATIONS)","'"+player.getFirstName()+"',",
									"'"+player.getMiddleInitial()+"',","'"+player.getLastName()+"',","'"+player.getDateOfBirth().toString()+"',",
									"'"+player.getCellNumber()+"',",player.getStudentID()+",","'"+player.getGender()+"',","'"+player.getYearAtUniversity()+"',",
									"'"+player.getEligibility()+"',",activeAthlete+",","'"+player.getAllergies()+"',","'"+player.getMedications()+"'"};
			
			
			output=output && database.insert("ATHLETE", athleteData);
		}
			
		//add to AthleteSports Table
		if(output){
			String[] sportsData = {"(STUDENTID,SPORTID)",""+player.getStudentID()+",",""};
			int sportID=-1;
			for(String sport : player.getSports().split(",")){
				sportID=getSportID(sport);
				if(sportID!=-1){
					sportsData[2]=""+sportID;
					output= output && database.insert("ATHLETESPORTS", sportsData);
				}
			}
		}
		//add to emergency contact table
		if(output){
			String[] contactData={"(STUDENTID,CONTACTNAME1, CONTACTPHONE1, CONTACTNAME2, CONTACTPHONE2)",player.getStudentID()+",","'"+player.getContacts().getContact1Name()+"',","'"+player.getContacts().getContact1Phone()+"',","'"+player.getContacts().getContact2Name()+"',","'"+player.getContacts().getContact2Phone()+"'"};
			output= output && database.insert("EMERGENCYCONTACT", contactData);
		}
		
		//add to InsuranceInfo Table
		if(output){
			String encryptedSSN;
			try {
				encryptedSSN = new String ( Encryption.encrypt(player.getInsuranceInfo().getStudentSSN()));
			} catch (Exception e) {
				encryptedSSN="                ";
				e.printStackTrace();
			}
			String referralString = "1";
			if(!player.getInsuranceInfo().getReferral()){
				referralString="0";
			}
			String coverAthleteString="1";
			if(!player.getInsuranceInfo().getCoverAthleticInjury()){
				coverAthleteString="0";
			}
			String[] insuranceData={"(STUDENTID, STUDENTSSN, COMPANYNAME, INSURANCEPHONE, POLICYID, GROUPNUMBER, ADDRESS, POLICYEFFECTIVE,"
					+ "POLICYEXPIRATION, COVERATHLETICINJURY, PRECERTPHONE, POLICYHOLDER, POLICYHOLDERPHONE, POLICYHOLDERADDRESS, POLICYLIMIT,"
					+ "DEDUCTIBLE, COPAY, REFERRAL, PRIMARYPHYSICIAN, PHYSICIANPHONE )",player.getStudentID()+",","'"+encryptedSSN+"',","'"+player.getInsuranceInfo().getCompanyName()+"',","'"+player.getInsuranceInfo().getInsurancePhone()+"',",
					"'"+player.getInsuranceInfo().getPolicyID()+"',","'"+player.getInsuranceInfo().getGroupNummber()+"',","'"+player.getInsuranceInfo().getAddress()+"',","'"+player.getInsuranceInfo().getPolicyEffective()+"',",
					"'"+player.getInsuranceInfo().getPolicyExpiration()+"',",coverAthleteString+",","'"+player.getInsuranceInfo().getPreCertPhone()+"',","'"+player.getInsuranceInfo().getPolicyHolder()+"',",
					"'"+player.getInsuranceInfo().getPolicyHolderPhone()+"',","'"+player.getInsuranceInfo().getPolicyHolderAddress()+"',",player.getInsuranceInfo().getLimit()+",",
					player.getInsuranceInfo().getDeductible()+",",player.getInsuranceInfo().getCoPay()+",",referralString+",","'"+player.getInsuranceInfo().getPrimaryPhysician()+"',",
					"'"+player.getInsuranceInfo().getPhysicianPhone()+"'"};
			output = output && database.insert("INSURANCEINFORMATION", insuranceData);
		}
		return output;
	}

	public boolean addSOAPNote(Injury injury, SOAPNotes note){
		String table = "SOAPNOTES";
		String[] data = {"(INJURYID,SUBJECTIVE,OBJECTIVE,ASSESSMENT,PLAN,DATE)",""+injury.getInjuryID()+",","'"+note.getSubjective()+"',","'"+note.getObjective()+"',","'"+note.getAssessment()+"',","'"+note.getSubjective()+"',","'"+note.getDate()+"'"};
		return database.insert(table, data);
	}

	public boolean addProgressNote(Injury injury, InjuryProgress note){
		String table= "INJURYPROGRESS";
		String[] data= {"(INJURYID,DATE,NOTE)",""+injury.getInjuryID()+",","'"+note.getDate()+"',","'"+note.getNote()+"'"};
		return database.insert(table, data);
	}

	public boolean addPhysicianVisit(Injury injury, PhysicianVisit visit){
		String table="PHYSICIANVISIT";
		String[] data= {"(INJURYID,DATE,NOTE)",""+injury.getInjuryID()+",","'"+visit.getDate()+"',",visit.getNote()};
		return database.insert(table, data);
	}

	public boolean addInjuryType(String bodyPart, String injuryType){
		String table="INJURYTYPE";
		String[] data= {"(BODYPARTID,INJURYTYPE)",""+getBodyPartID(bodyPart)+",","'"+injuryType+"'"};
		return database.insert(table, data);
	}

	public boolean addTrainer(String firstName, String lastName, String userName, String password){
		String table="TRAINERS";
		long salt = System.currentTimeMillis();
		try{
			String[] data = {"(FIRSTNAME,LASTNAME,PASSWORD,SALT)",firstName+",",lastName+",",userName+",",Encryption.hash(password+salt)+",",""+salt};
			return database.insert(table, data);
		}catch(NoSuchAlgorithmException e){
			return false;
		}
	}
	
	public boolean removeTrainer(String firstName, String lastName, String userName){
		String table="TRAINERS";
		String[] data = {"FIRSTNAME="+firstName+",","LASTNAME="+lastName+",","USERNAME="+userName};
		return database.delete(table, data);
	}
	
	public boolean editPassword(String userName, String newPassword){
		String table="TRAINERS";
		long salt = System.currentTimeMillis();
		try{
			String[] searchData = {"USERNAME="+userName};
			String[] updatedData = {Encryption.hash(newPassword+salt)+",",""+salt};
			return database.update(table, updatedData, searchData);
		}catch(NoSuchAlgorithmException e){
			return false;
		}
	}
	
	public boolean authenticate(String userName, String password){
		String table = "TRAINERS";
		String[] data = {"USERNAME="+userName};
		ArrayList<String> trainer = database.select(table, data).get(0);
		String salt = trainer.get(5);
		try{
			return Encryption.hash(password+salt).equalsIgnoreCase(trainer.get(4));
		}catch(NoSuchAlgorithmException e){
			return false;
		}
	}
	
	public boolean removeAthleteFromSport(Athlete currentAthlete, String sport){
		int sportID = getSportID(sport);
		String table = "ATHLETESPORTS";
		String[] data = {"STUDENTID="+currentAthlete.getStudentID()+",","SPORTID="+sportID};
		return database.delete(table, data);
		
	}

	public boolean addAthleteToSport(Athlete currentAthlete, String sport){
		int sportID = getSportID(sport);
		String table = "ATHLETESPORTS";
		String[] data = {"(STUDENTID,SPORTID)",+currentAthlete.getStudentID()+",",""+sportID};
		return database.insert(table, data);
	}
	
	public boolean editAthlete(Athlete oldAthlete, Athlete newAthlete ){
		String table = "ATHLETE";
		String activeString="1";
		if(!newAthlete.isActive()){
			activeString="0";
		}
		String[] searchData = {"STUDENTID="+oldAthlete.getStudentID()};
		String[] updatedData ={"STUDENTID="+newAthlete.getStudentID()+",","FIRSTNAME='"+newAthlete.getFirstName()+"',","MIDDLEINITIAL='"+newAthlete.getMiddleInitial()+"',","LASTNAME='"+newAthlete.getLastName()+"',","DATEOFBIRTH='"+newAthlete.getDateOfBirth()+"',","CELLNUMBER='"+newAthlete.getCellNumber()+"',","GENDER='"+newAthlete.getGender()+"',","YEARATUNIVERSITY='"+newAthlete.getYearAtUniversity()+"',","ELIGIBILITY='"+newAthlete.getEligibility()+"',","ACTIVE='"+activeString+"',","ALLERGIES='"+newAthlete.getAllergies()+"',","MEDICATIONS='"+newAthlete.getMedications()+"'"};
		
		return database.update(table, updatedData, searchData);
	}
	
	public boolean editInsurance(Athlete player, InsuranceInformation newInsuranceInfo){
		String table = "INSURANCEINFORMATION";
		String[] searchData = {"STUDENTID="+player.getStudentID()};
		String encryptedSSN;
		try {
			encryptedSSN = new String (Encryption.encrypt(newInsuranceInfo.getStudentSSN()));
		} catch (Exception e) {
			encryptedSSN="                ";
			e.printStackTrace();
		}
		String referralString ="1";
		if(!newInsuranceInfo.getReferral()){
			referralString="0";
		}
		String coverAthleteString ="1";
		if(!newInsuranceInfo.getCoverAthleticInjury()){
			coverAthleteString="0";
		}
		String[] insuranceData={"STUDENTID="+player.getStudentID()+",","STUDENTSSN='"+encryptedSSN+"',","COMPANYNAME='"+newInsuranceInfo.getCompanyName()+"',","INSURANCEPHONE='"+newInsuranceInfo.getInsurancePhone()+"',",
				"POLICYID='"+newInsuranceInfo.getPolicyID()+"',","GROUPNUMBER='"+newInsuranceInfo.getGroupNummber()+"',","ADDRESS='"+newInsuranceInfo.getAddress()+"',","POLICYEFFECTIVE='"+newInsuranceInfo.getPolicyEffective()+"',",
				"POLICYEXPIRATION='"+newInsuranceInfo.getPolicyExpiration()+"',","COVERATHLETICINJURY="+coverAthleteString+",","PRECERTPHONE='"+newInsuranceInfo.getPreCertPhone()+"',","POLICYHOLDER='"+newInsuranceInfo.getPolicyHolder()+"',",
				"POLICYHOLDERPHONE='"+newInsuranceInfo.getPolicyHolderPhone()+"',","POLICYHOLDERADDRESS='"+newInsuranceInfo.getPolicyHolderAddress()+"',","POLICYLIMIT="+newInsuranceInfo.getLimit()+",",
				"DEDUCTIBLE="+newInsuranceInfo.getDeductible()+",","COPAY="+newInsuranceInfo.getCoPay()+",","REFERRAL="+referralString+",","PRIMARYPHYSICIAN='"+newInsuranceInfo.getPrimaryPhysician()+"',",
				"PHYSICIANPHONE='"+newInsuranceInfo.getPhysicianPhone()+"'"};

		return database.update(table, insuranceData, searchData);

	}
	
	public String sanitize(String input){
		String accepted="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,/";
		String output="";
		if(input!=null){
			for(int count=0;count<input.length();count++){
				if(accepted.contains(""+input.charAt(count))){
					output+=""+input.charAt(count);
				}
				
			}
		}
		return output;
	}
	
	public void generateReport(){
		if(!lastSearch.isEmpty()){
			boolean first=true;
			try {
				PrintWriter reportFile = new PrintWriter(System.getProperty("user.home")+"\\Desktop\\Injury Report "+new File(new java.sql.Date(System.currentTimeMillis()).toString()+".csv"));
				reportFile.println("First Name, Middle Initial, Last Name, Injury Type, Progress Note, Physician Visit ");
				for(Athlete athlete : lastSearch){
					first=true;
					reportFile.print(athlete.getFirstName()+","+athlete.getMiddleInitial()+","+athlete.getLastName()+",");
					if(!athlete.getInjuryList().isEmpty() && athlete.getActiveInjury()){
						for(Injury injury : athlete.getInjuryList()){
							if(injury.getActive()){
								if(!first){
									reportFile.print(" , , ,");
								}
								reportFile.println(injury.getInjuryType()+","+injury.getLatestProgressNote()+","+injury.getLatestPhysicianVisit());
								first=false;
							}
						}
					}else{
						reportFile.println(" , , ");
					}
				}
				reportFile.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		//AthleteTrackerDatabase database = new AthleteTrackerDatabase();
		///String input = "@#$H^&(*E)!::;LL-=||||||@!`O";
		//System.out.println(database.sanitize(input));
		///AddInjuryToAthlete.main(args);
		//THIS MAIN METHOD DOES ABSOLUTELY NOTHING, I PROMISE
		
	}
}
