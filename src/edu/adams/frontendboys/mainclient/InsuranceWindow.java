package mainclient;

import java.io.IOException;

import edu.adams.backendboys.Athlete;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class InsuranceWindow extends Window {
	
	public InsuranceWindow(Athlete currentAthlete){
		Stage stg = new Stage();
		stg.setResizable(false);
		Parent root;
		try {
		//	root = FXMLLoader.load(getClass().getResource("/fxml/DISPLAYINSURANCE.fxml"));
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DISPLAYINSURANCE.fxml"));     

			root = (Parent)fxmlLoader.load();
			Scene scene = new Scene(root, 800, 600);
			stg.setScene(scene);
			stg.setTitle("Athlete Insurance");
			stg.setResizable(false);
			InsuranceWindowController controller = fxmlLoader.<InsuranceWindowController>getController();
			controller.setAthlete(currentAthlete);
			
			scene.getStylesheets().add("css/athleteTracker.css");
			
			stg.show();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					

	}
	
}
