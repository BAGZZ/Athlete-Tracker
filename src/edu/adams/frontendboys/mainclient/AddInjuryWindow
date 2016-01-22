package mainclient;
import java.io.IOException;

import edu.adams.backendboys.Athlete;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

	public class AddInjuryWindow extends Window {
	
		public AddInjuryWindow(Athlete currentAthlete){
			Stage stg = new Stage();
			stg.setResizable(false);
			Parent root;
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ADDINJURY.fxml")); 
				root = (Parent)fxmlLoader.load();
				Scene scene = new Scene(root, 800, 600);
				stg.setScene(scene);
				stg.setTitle("Add Injury");
				stg.setResizable(false);
				AddInjuryWindowController controller = fxmlLoader.<AddInjuryWindowController>getController();
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


