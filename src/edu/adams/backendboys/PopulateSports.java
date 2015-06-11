package edu.adams.backendboys;

public class PopulateSports {

	public static void main(String[] args) {
		Database database = new SQLiteDatabase();
		String table= "SPORTS";
		String[] data = {"(SPORTNAME)","'Football'"};
		database.insert(table, data);
		data[1]="'Mens Cross Country'";
		database.insert(table, data);
		data[1]="'Womens Cross Country'"; 
		database.insert(table, data);
		data[1]="'Volleyball'";
		database.insert(table, data);
		data[1]="'Womens Soccer'";
		database.insert(table, data);
		data[1]="'Mens Soccer'";
		database.insert(table, data);
		data[1]="'Womens Swimming'";
		database.insert(table, data);
		data[1]="'Mens Swimming'";
		database.insert(table, data);
		data[1]="'Mens Basketball'";
		database.insert(table, data);
		data[1]="'Womens Basketball'";
		database.insert(table, data);
		data[1]="'Wrestling'";
		database.insert(table, data);
		data[1]="'Baseball'";
		database.insert(table, data);
		data[1]="'Softball'";
		database.insert(table, data);
		data[1]="'Mens Lacross'";
		database.insert(table, data);
		data[1]="'Womens Lacross'";
		database.insert(table, data);
		data[1]="'Mens Track and Field'";
		database.insert(table, data);
		data[1]="'Womens Track and Field'";
		database.insert(table, data);
		data[1]="'Mens Golf'";
		database.insert(table, data);
		data[1]="'Womens Golf'";
		database.insert(table, data);
		
		AthleteTrackerDatabase trackerDatabase = new AthleteTrackerDatabase();
		for(String sport : trackerDatabase.getSports()){
			System.out.println(trackerDatabase.getSportID(sport)+"\t"+sport);
		}
	}

}
