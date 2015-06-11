package edu.adams.backendboys;

public class PopulateBodyParts {

	public static void main(String[] args) {
		Database database = new SQLiteDatabase();
		String table= "BODYPART";
		String[] data = {"(BODYPART)","'Head or Face'"};
		database.insert(table, data);
		data[1]="'Left Ear'";
		database.insert(table, data);
		data[1]="'Right Ear'";
		database.insert(table, data);
		data[1]="'Left Eye'";
		database.insert(table, data);
		data[1]="'Right Eye'";
		database.insert(table, data);
		data[1]="'Cervical Spine or Neck'";
		database.insert(table, data);
		data[1]="'Left Shoulder'";
		database.insert(table, data);
		data[1]="'Right Shoulder'";
		database.insert(table, data);
		data[1]="'Left Upper Arm'";
		database.insert(table, data);
		data[1]="'Right Upper Arm'";
		database.insert(table, data);
		data[1]="'Left Elbow'";
		database.insert(table, data);
		data[1]="'Right Elbow'";
		database.insert(table, data);
		data[1]="'Left Forearm'";
		database.insert(table, data);
		data[1]="'Right Forearm'";
		database.insert(table, data);
		data[1]="'Left Wrist'";
		database.insert(table, data);
		data[1]="'Right Wrist'";
		database.insert(table, data);
		data[1]="'Left Hand or Fingers'";
		database.insert(table, data);
		data[1]="'Right Hand or Fingers'";
		database.insert(table, data);
		data[1]="'Chest or Ribs'";
		database.insert(table, data);
		data[1]="'Thoracic Spine'";
		database.insert(table, data);
		data[1]="'Abdomen'";
		database.insert(table, data);
		data[1]="'Lumbar Spine'";
		database.insert(table, data);
		data[1]="'Left Hip or Groin'";
		database.insert(table, data);
		data[1]="'Right Hip or Groin'";
		database.insert(table, data);
		data[1]="'Sacrum or Pelvis'";
		database.insert(table, data);
		data[1]="'Left Thigh'";
		database.insert(table, data);
		data[1]="'Right Thigh'";
		database.insert(table, data);
		data[1]="'Left Knee'";
		database.insert(table, data);
		data[1]="'Right Knee'";
		database.insert(table, data);
		data[1]="'Left Lower Leg'";
		database.insert(table, data);
		data[1]="'Right Lower Leg'";
		database.insert(table, data);
		data[1]="'Left Ankle'";
		database.insert(table, data);
		data[1]="'Right Ankle'";
		database.insert(table, data);
		data[1]="'Left Foot or Toes'";
		database.insert(table, data);
		data[1]="'Right Foot or Toes'";
		database.insert(table, data);
		
		
		data[1]="'Cardiovascular'";
		database.insert(table, data);		
		data[1]="'Illness'";
		database.insert(table, data);
		data[1]="'Infection Internal'";
		database.insert(table, data);	
		
		AthleteTrackerDatabase tracker = new AthleteTrackerDatabase();
		for(String word : tracker.getAllBodyParts()){
			System.out.println(tracker.getBodyPartID(word)+"\t"+word);
		}
		
	}

}
