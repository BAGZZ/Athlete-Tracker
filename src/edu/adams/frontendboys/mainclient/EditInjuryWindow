package mainclient;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import edu.adams.backendboys.Athlete;
import edu.adams.backendboys.Injury;

public class EditInjuryWindow extends Window {

	public EditInjuryWindow(Athlete currentAthlete){
		Stage stg = new Stage();
		stg.setResizable(false);
		Parent root;
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EDITINJURY.fxml"));     

			root = (Parent)fxmlLoader.load();
			Scene scene = new Scene(root, 800, 600);
			stg.setScene(scene);
			stg.setTitle("Edit Injury");
			stg.setResizable(false);
			EditInjuryWindowController controller = fxmlLoader.<EditInjuryWindowController>getController();
			controller.setInformation(currentAthlete);
			
			scene.getStylesheets().add("css/athleteTracker.css");
			
			stg.show();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					

	}
	
}
