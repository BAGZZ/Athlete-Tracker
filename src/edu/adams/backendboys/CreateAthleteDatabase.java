package edu.adams.backendboys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateAthleteDatabase {

	 public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //this needs to be changed when not on my laptop
	      c = DriverManager.getConnection("jdbc:sqlite:C:\\AthleteTracker\\ASUAthleteTracker.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE ATHLETE" +
	                   "(STUDENTID INT8 PRIMARY KEY     NOT NULL," +
	                   " FIRSTNAME      CHAR(32)    NOT NULL, " + 
	                   " MIDDLEINITIAL      CHAR(1)    NOT NULL, " + 
	                   " LASTNAME      CHAR(32)    NOT NULL, " + 
	                   " DATEOFBIRTH      DATE    NOT NULL, " + 
	                   " CELLNUMBER      CHAR(16)    NOT NULL, " + 
	                   " GENDER      CHAR(1)    NOT NULL, " + 
	                   " YEARATUNIVERSITY      CHAR(16)    NOT NULL, " + 
	                   " ELIGIBILITY      CHAR(16)    NOT NULL, " + 
	                   " ACTIVE     BOOLEAN   NOT NULL, " + 
	                   " ALLERGIES      CHAR(128)    NOT NULL, " + 
	                   " MEDICATIONS      CHAR(256)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      
	      sql = "CREATE TABLE ATHLETESPORTS" +
                  "(STUDENTID INT8 NOT NULL," + 
                  " SPORTID      INT8    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	     sql = "CREATE TABLE SPORTS" +
                  "(SPORTID INTEGER PRIMARY KEY     AUTOINCREMENT," +
                  " SPORTNAME      CHAR(32)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE EMERGENCYCONTACT" +
                  "(STUDENTID INT8 NOT NULL," +
                  " CONTACTNAME1     CHAR(64)    NOT NULL, " + 
                  " CONTACTPHONE1      CHAR(16)    NOT NULL, " + 
                  " CONTACTNAME2      CHAR(64)    NOT NULL, " + 
                  " CONTACTPHONE2      CHAR(16)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE INSURANCEINFORMATION" +
                  "(STUDENTID INT8    NOT NULL," +
                  " STUDENTSSN      CHAR(16)    NOT NULL, " + 
                  " COMPANYNAME      CHAR(64)    NOT NULL, " + 
                  " INSURANCEPHONE     CHAR(16)    NOT NULL, " + 
                  " POLICYID     CHAR(32)    NOT NULL, " + 
                  " GROUPNUMBER      CHAR(32)    NOT NULL, " + 
                  " ADDRESS     CHAR(128)    NOT NULL, " + 
                  " POLICYEFFECTIVE     DATE    NOT NULL, " + 
                  " POLICYEXPIRATION      DATE    NOT NULL, " + 
                  " COVERATHLETICINJURY     BOOLEAN   NOT NULL, " + 
                  " PRECERTPHONE      CHAR(32)    NOT NULL, " + 
                  " POLICYHOLDER      CHAR(128)    NOT NULL, " +
                  " POLICYHOLDERPHONE      CHAR(16)    NOT NULL, " +
                  " POLICYHOLDERADDRESS      CHAR(128)    NOT NULL, " +
                  " POLICYLIMIT      INT8    NOT NULL, " +
                  " DEDUCTIBLE      INT8    NOT NULL, " +
                  " COPAY      INT8    NOT NULL, " +
                  " REFERRAL      BOOLEAN    NOT NULL, " +
                  " PRIMARYPHYSICIAN      CHAR(128)    NOT NULL, " +
                  " PHYSICIANPHONE     CHAR(16)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE BODYPART" +
                  "(BODYPARTID INTEGER PRIMARY KEY	AUTOINCREMENT," +
                  " BODYPART    CHAR(32)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      //add new boolean column based on if the injury can happen to a left or a right body part
	      sql = "CREATE TABLE INJURYTYPE" +
                  "(INJURYTYPEID INTEGER PRIMARY KEY	AUTOINCREMENT," +
                  " BODYPARTID      INT8    NOT NULL, " + 
                  " INJURYTYPE    CHAR(64)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	     
	      
	      //add new column that will, given an injury that can happen to the left or right, will determine if it is on the left or right side
	      //once that is added we can tack on Left or Right onto the appropriate injuries type string when Constructed 
	      sql = "CREATE TABLE INJURIES" +
                  "(INJURYID     INTEGER PRIMARY KEY	AUTOINCREMENT, " + 
                  " STUDENTID      INT8    NOT NULL, " + 
                  " INJURYTYPEID      INT8    NOT NULL, " + 
                  " INJURYDATE      DATE    NOT NULL, " +
                  " ACTIVE     BOOLEAN    NOT NULL, " +
                  " SEASON      CHAR(16)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE SOAPNOTES" +
                  "(INJURYID INTEGER NOT NULL," +
                  " SUBJECTIVE     CHAR(256)    NOT NULL, " + 
                  " OBJECTIVE      CHAR(256)    NOT NULL, " + 
                  " ASSESSMENT      CHAR(256)    NOT NULL, " + 
                  " PLAN      CHAR(256)    NOT NULL, " +
                  " DATE      DATE    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE INJURYPROGRESS" +
                  "(INJURYID INTEGER NOT NULL," +
                  " DATE     DATE    NOT NULL, " + 
                  " NOTE      CHAR(256)   NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE PHYSICIANVISIT" +
                  "(INJURYID INTEGER NOT NULL," +
                  " DATE     DATE    NOT NULL, " + 
                  " NOTE      CHAR(256)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE TRAINERS" +
                  "(TRAINERID INTEGER PRIMARY KEY	AUTOINCREMENT," +
                  " FIRSTNAME     CHAR(32)    NOT NULL, " + 
                  " LASTNAME      CHAR(32)    NOT NULL, " + 
                  " USERNAME      CHAR(32)    NOT NULL, " + 
                  " TRAINERPSW      CHAR(64)    NOT NULL, " + 
                  " SALT      INT8    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE COACH" +
                  "(SPORTID INT8 NOT NULL," +
                  " EMAILADDRESS      CHAR(64)    NOT NULL, " + 
                  " FIRSTNAME     CHAR(32)    NOT NULL, " + 
                  " LASTNAME      CHAR(32)    NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	  }
}


