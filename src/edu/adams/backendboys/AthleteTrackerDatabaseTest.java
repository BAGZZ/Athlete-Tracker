package edu.adams.backendboys;

import java.sql.Date;
import java.util.ArrayList;

public class AthleteTrackerDatabaseTest extends AthleteTrackerDatabase {
	private ArrayList<Athlete> athletes;
	private ArrayList<Injury> injuries;
	private ArrayList<SOAPNotes> notes;
	private ArrayList<InjuryProgress> progressNotes;
	private ArrayList<PhysicianVisit> visits;
	private EmergencyContact contact = new EmergencyContact("Dad", "1-800-555-0101", "Mommy?", "1-900-HO BAGZ");
	@SuppressWarnings("deprecation")
	private InsuranceInformation insuranceInfo = new InsuranceInformation("987654321", "InsuranceCo", "1-800-555-4321", "17", "1234", "123 Bagby Ave, Zach, Colorado, 11111", new Date(1994, 12, 5), new Date(2014, 12, 5), true,"303-555-1111", "Mom", "1-900-HO BAGZ", "123 Bagby Ave, Zach, Colorado, 11111", 10000, 1, 100000, true, "Dr. Munchkin Voice", "1-800-Lollipop Guild");
	private SOAPNotes soapNote = new SOAPNotes("subjective", "objective", "analysis", "plan", new Date(System.currentTimeMillis()));
	private InjuryProgress progress = new InjuryProgress(new Date(System.currentTimeMillis()), "This is a note");
	private PhysicianVisit visit = new PhysicianVisit(new Date(System.currentTimeMillis()), "Doc says Hi");
	AthleteTrackerDatabaseTest(){
		notes.add(soapNote);
		progressNotes.add(progress);
		visits.add(visit);
		injuries.add(new Injury(1, "ACL", new Date(System.currentTimeMillis()), true, "Summer 2015", notes, visits, progressNotes));
		injuries.add(new Injury(2, "Hamstring", new Date(System.currentTimeMillis()), false, "Winter 2009", notes, visits, progressNotes));
		injuries.add(new Injury(3, "Nose", new Date(System.currentTimeMillis()), true, "Summer 2015", notes, visits, progressNotes));
		injuries.add(new Injury(4, "Toe", new Date(System.currentTimeMillis()), false, "Spring 2015", notes, visits, progressNotes));
		athletes.add((new Athlete("Weiner", 'S', "ucker", new Date(2015, 5, 26), "719-330-9702", 9000000, '?', "Freshman", "Senior", true, "Football", injuries, contact, insuranceInfo)));
		athletes.add((new Athlete("Munchkin", 'V', "oice", new Date(1994, 4, 1), "719-330-9702", 9000001, 'M', "Freshman", "Freshman", true, "Field Fairy", injuries, contact, insuranceInfo)));
		athletes.add((new Athlete("IceBankMic", 'e', "Elf", new Date(2000, 12, 25), "719-Snt-Nick", 9000003, 'F', "Junior", "Senior", true, "Track", injuries, contact, insuranceInfo)));
	}
	
	public ArrayList<Athlete> searchDatabase(){
		return athletes;
	}
}
