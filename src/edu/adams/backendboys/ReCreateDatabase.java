package edu.adams.backendboys;

public class ReCreateDatabase {
	public static void main(String[] args){
		System.out.println("Making the Database");
		CreateAthleteDatabase.main(args);
		
		System.out.println("\nAdding the Sports");
		PopulateSports.main(args);
		
		System.out.println("\nAdding the Body Parts");
		PopulateBodyParts.main(args);
		
		System.out.println("\nAdding InjuryTypes");
		AddInjury.main(args);
		
		System.out.println("DONE");
		
		
	}
}
