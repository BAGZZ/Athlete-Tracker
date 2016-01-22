package mainclient;

import java.net.URL;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.panemu.tiwulfx.table.CheckBoxColumn;
import com.panemu.tiwulfx.table.DateColumn;
import com.panemu.tiwulfx.table.TextColumn;

import edu.adams.backendboys.Athlete;
import edu.adams.backendboys.AthleteTrackerDatabase;
import edu.adams.backendboys.AthleteTrackerDatabaseTest;
import edu.adams.backendboys.EmergencyContact;
import edu.adams.backendboys.Injury;
import edu.adams.backendboys.InsuranceInformation;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class MainSceneController implements Initializable {
	private final long REFRESHTIMEOUT = 1000/2;
	AthleteTrackerDatabase atdb = new AthleteTrackerDatabase();
	
	private Athlete currentAthlete = null;
	private Injury currentInjury = null;
	private boolean coverAthlete = true;
	private boolean referral = true;
	
	@FXML
	private TabPane tabPane;
	@FXML
	private ListView<String> sportsAddAthleteListView;
	@FXML
	private ComboBox<String> eligibilityAddAthleteComboBox,
		sportComboBox,
		injuryTypeComboBox,
		bodyPartComboBox,		
		coverAthleteInjuryAddAthleteComboBox,
		referralAddAthleteComboBox,
		activeInjuryComboBox,
		genderAddAthleteComboBox,
		genderComboBox,
		seasonComboBox;
	@FXML
	private ComboBox<Integer>
		yearAddAthleteComboBox;
	@FXML
	private Label generatedLabel,
		displayInsuranceError,
		addInjuryError,
		editAthleteError;
	@FXML
	private MenuButton bodyPartMenuButton;
	@FXML
	private DatePicker dobAddAthletedatePicker,
		effectiveDateDatePicker,
		expirationDateDatePicker,
		startDateDatePicker,
		endDateDatePicker;
	@FXML
	private Tab selectedAthleteTab;
	@FXML
	private Button editAthleteButton, 
		editAthleteCancelButton,
		addAthleteButton;
	@FXML
	//contact information
	private TextField phoneContactText,  
		ecContactText1, 
		ecContactText2, 
		ecPhoneContactText1, 
		ecPhoneContactText2,
		
		//search athlete
		firstNameSearchText,
		middleInitialSearchText,
		lastNameSearchText,
		studentNumberSearchText,
		
		//athlete information
		firstNameAthleteText,
		miAthleteText,
		lastNameAthleteText,
		sportsAthleteText,
		yearAthleteText,
		idAthleteText,
		eligibilityAthleteText,
	
		//add athlete
		firstAddAthleteText,
		miAddAthleteText,
		lastAddAthleteText,
		cellAddAthleteText,
		idAddAthleteText,
		dobAddAthleteText,
		allergiesAddAthleteText,
		medicationsAddAthletText,
		athleteSSNAddAthleteText,
		ecNameAddAthleteText1,
		ecPhoneAddAthleteText1,
		ecNameAddAthleteText2,
		ecPhoneAddAthleteText2,
		insuranceNameAddAthleteText,
		insurancePhoneAddAthleteText,
		IDAddAthleteText,
		groupNumberAddAthleteText,
		companyAddressAddAthleteText,
		preCertificationPhoneAddAthleteText,
		policyHolderAddAthleteText,
		policyHolderPhoneAddAthleteText,
		primaryPhysicianAddAthleteText,
		physicianPhoneAddAthleteText,
		policyHolderAddressAddAthleteText,
		coPayAddAthleteText,
		limitAddAthleteText,
		deductableAddAthleteText;
		
		
	@FXML
	private CheckBox activeCheckBox,
	activeAddAthleteCheckBox;
	
	@FXML
	private TableView<Athlete> searchTableView;
	@FXML
	private TableView<Injury> injuriesTableView;
	
	@FXML
	private ImageView searchImageView;
	
	//Columns for Injury Table
	TextColumn<Injury> columnInjury;
	TextColumn<Injury> columnDate;
	CheckBoxColumn<Injury>columnActiveinj;
	TextColumn<Injury> columnSOAPNotes;
	TextColumn<Injury> columnProgressNotes;
	TextColumn<Injury> columnPhysicianNotes;
	
	//Columns for Search Table	
	TextColumn<Athlete> columnFirstName;
	TextColumn<Athlete> columnLastName;
	TextColumn<Athlete> columnSports;
	TextColumn<Athlete> columnEligibility;
	TextColumn<Athlete> columnInjuries;
	CheckBoxColumn<Athlete> columnAthleteActive;
	CheckBoxColumn<Athlete> columnInjuryActive;
	
	private long previous=0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//do stuff here before viewing
		
		//add information to specific column search table
		columnFirstName = new TextColumn<Athlete>("firstName");
		columnLastName = new TextColumn<Athlete>("lastName");
		columnSports = new TextColumn<Athlete>("sports");
		columnEligibility = new TextColumn<Athlete>("eligibility");
		columnInjuries = new TextColumn<Athlete>("injuries");
		columnAthleteActive = new CheckBoxColumn<Athlete>("active");
		columnInjuryActive = new CheckBoxColumn<Athlete>("activeInjury");
		
		//set width of columns
		columnFirstName.setMaxWidth(154);
		columnLastName.setMaxWidth(154);
		columnSports.setMaxWidth(154);
		columnEligibility.setMaxWidth(154);
		columnInjuries.setMaxWidth(220);
		columnInjuries.setMinWidth(220);
		columnAthleteActive.setMaxWidth(154);
		columnInjuryActive.setMaxWidth(154);
		
		//set columns to non-resizable
		columnFirstName.setResizable(false);
		columnLastName.setResizable(false);
		columnSports.setResizable(false);
		columnEligibility.setResizable(false);
		columnInjuries.setResizable(false);
		columnAthleteActive.setResizable(false);
		columnInjuryActive.setResizable(false);

		//set titles
		columnFirstName.setText("First");
		columnLastName.setText("Last");
		columnSports.setText("Sports");
		columnEligibility.setText("Eligibility");
		columnInjuries.setText("Injuries");
		columnAthleteActive.setText("Athlete Active");
		columnInjuryActive.setText("Injury Active");
		
		//add columns to Search Table
		searchTableView.getColumns().clear();
		searchTableView.getColumns().add(columnFirstName);
		searchTableView.getColumns().add(columnLastName);
		searchTableView.getColumns().add(columnSports);
		searchTableView.getColumns().add(columnEligibility);
		searchTableView.getColumns().add(columnInjuries);
		searchTableView.getColumns().add(columnAthleteActive);
		searchTableView.getColumns().add(columnInjuryActive);
		
		
		//filling in search combo boxssss
		eligibilityAddAthleteComboBox.getItems().add("Freshman");
		eligibilityAddAthleteComboBox.getItems().add("Sophomore");
		eligibilityAddAthleteComboBox.getItems().add("Junior");
		eligibilityAddAthleteComboBox.getItems().add("Senior");
		
		yearAddAthleteComboBox.getItems().add(1);
		yearAddAthleteComboBox.getItems().add(2);
		yearAddAthleteComboBox.getItems().add(3);
		yearAddAthleteComboBox.getItems().add(4);
		yearAddAthleteComboBox.getItems().add(5);
		yearAddAthleteComboBox.getItems().add(6);
		
		genderAddAthleteComboBox.getItems().add("Male");
		genderAddAthleteComboBox.getItems().add("Female");
		
		coverAthleteInjuryAddAthleteComboBox.getItems().add("Yes");
		
		coverAthleteInjuryAddAthleteComboBox.getItems().add("No");
		
		referralAddAthleteComboBox.getItems().add("Yes");
		referralAddAthleteComboBox.getItems().add("No");
		
		genderComboBox.getItems().add("Male");
		genderComboBox.getItems().add("Female");
		genderComboBox.getItems().add("Both");
		
		ArrayList<String> sports = atdb.getSports();
		Collections.sort(sports);
		sportComboBox.getItems().setAll(sports);
		
		ArrayList<String> bodyParts = atdb.getAllBodyParts();
		Collections.sort(bodyParts);
		bodyPartComboBox.getItems().setAll(bodyParts);
		
		activeInjuryComboBox.getItems().add("Active/Inactive");
		activeInjuryComboBox.getItems().add("Active");
		activeInjuryComboBox.getItems().add("Inactive");
	
		injuryTypeComboBox.getItems().add("Select Body Part");

		ArrayList<String> seasons = atdb.getSeasons();
		seasonComboBox.getItems().setAll(seasons);
		
		sportsAddAthleteListView.getItems().setAll(sports);
		sportsAddAthleteListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		Image image = new Image("asuIcon.png");
		searchImageView.setImage(image);
	}
	
	public void editAthleteButtonAction(ActionEvent ae)
	{
		ae.consume();
		if(currentAthlete == null){
			editAthleteError.setText("Please search and double click on an athlete before using this tab.");
			FadeTransition fader = new FadeTransition(Duration.millis(2000), editAthleteError);
			fader.setFromValue(1.0);
			fader.setToValue(0.0);
		    fader.setCycleCount(3);
		    fader.setAutoReverse(false);

		    fader.play();
		}
		else{
			
			if(editAthleteButton.getText().startsWith("Edit"))
			{
				editAthleteButton.setText("Save Athlete");
				
				phoneContactText.setEditable(true);
				ecContactText1.setEditable(true);
				ecContactText2.setEditable(true);
				ecPhoneContactText1.setEditable(true);
				ecPhoneContactText2.setEditable(true);
				
				firstNameAthleteText.setEditable(true);
				miAthleteText.setEditable(true);
				lastNameAthleteText.setEditable(true);
				sportsAthleteText.setEditable(true);
				yearAthleteText.setEditable(true);
				idAthleteText.setEditable(true);
				eligibilityAthleteText.setEditable(true);
				activeCheckBox.setDisable(false);
				
				//set css class
				phoneContactText.getStyleClass().add("selectedAthleteEdit");
				ecContactText1.getStyleClass().add("selectedAthleteEdit");
				ecContactText2.getStyleClass().add("selectedAthleteEdit");
				ecPhoneContactText1.getStyleClass().add("selectedAthleteEdit");
				ecPhoneContactText2.getStyleClass().add("selectedAthleteEdit");
				
				firstNameAthleteText.getStyleClass().add("selectedAthleteEdit");
				miAthleteText.getStyleClass().add("selectedAthleteEdit");
				lastNameAthleteText.getStyleClass().add("selectedAthleteEdit");
				sportsAthleteText.getStyleClass().add("selectedAthleteEdit");
				yearAthleteText.getStyleClass().add("selectedAthleteEdit");
				idAthleteText.getStyleClass().add("selectedAthleteEdit");
				eligibilityAthleteText.getStyleClass().add("selectedAthleteEdit");
				activeCheckBox.getStyleClass().add("selectedAthleteEdit");
				
				//reveal cancel button
				editAthleteCancelButton.setVisible(true);
				
			}
			
			else
			{
				editAthleteButton.setText("Edit Athlete");
				phoneContactText.setEditable(false);
				ecContactText1.setEditable(false);
				ecContactText2.setEditable(false);
				ecPhoneContactText1.setEditable(false);
				ecPhoneContactText2.setEditable(false);
				
				firstNameAthleteText.setEditable(false);
				miAthleteText.setEditable(false);
				lastNameAthleteText.setEditable(false);
				sportsAthleteText.setEditable(false);
				yearAthleteText.setEditable(false);
				idAthleteText.setEditable(false);
				eligibilityAthleteText.setEditable(false);
				activeCheckBox.setDisable(true);
				
				EmergencyContact ec = new EmergencyContact(ecContactText1.getText(), ecPhoneContactText1.getText(), ecContactText2.getText(), ecContactText2.getText());
				
	//			Athlete editedAthlete = new Athlete(firstNameAthleteText.getText(), miAthleteText.getText().charAt(0), lastNameAthleteText.getText(), dobAthleteText.getText(),
	//					phoneContactText.getText(), idAthleteText.getText(), currentAthlete.getGender(), yearAthleteText.getText(), eligibilityAthleteText.getText(),
	//					activeCheckBox.isSelected(), currentAthlete.getAllergies(), currentAthlete.getMedications(), sportsAthleteText.getText(), currentAthlete.getInjuries(), 
	//					ec, currentAthlete.getInsuranceInfo());
				
				//clear css class
				phoneContactText.getStyleClass().clear();
				ecContactText1.getStyleClass().clear();
				ecContactText2.getStyleClass().clear();
				ecPhoneContactText1.getStyleClass().clear();
				ecPhoneContactText2.getStyleClass().clear();
				
				firstNameAthleteText.getStyleClass().clear();
				miAthleteText.getStyleClass().clear();
				lastNameAthleteText.getStyleClass().clear();
				sportsAthleteText.getStyleClass().clear();
				yearAthleteText.getStyleClass().clear();
				idAthleteText.getStyleClass().clear();
				eligibilityAthleteText.getStyleClass().clear();
				
				//set css class
				phoneContactText.getStyleClass().add("selectedAthlete");
				ecContactText1.getStyleClass().add("selectedAthlete");
				ecContactText2.getStyleClass().add("selectedAthlete");
				ecPhoneContactText1.getStyleClass().add("selectedAthlete");
				ecPhoneContactText2.getStyleClass().add("selectedAthlete");
				
				firstNameAthleteText.getStyleClass().add("selectedAthlete");
				miAthleteText.getStyleClass().add("selectedAthlete");
				lastNameAthleteText.getStyleClass().add("selectedAthlete");
				sportsAthleteText.getStyleClass().add("selectedAthlete");
				yearAthleteText.getStyleClass().add("selectedAthlete");
				idAthleteText.getStyleClass().add("selectedAthlete");
				eligibilityAthleteText.getStyleClass().add("selectedAthlete");
				
				//hide cancel button
				editAthleteCancelButton.setVisible(false);
				
			}
		}
	}
	
	public void editAthleteCancelButtonAction(ActionEvent ae)
	{
		ae.consume();
		
		//hide cancel button
		editAthleteCancelButton.setVisible(false);
		
		editAthleteButton.setText("Edit Athlete");
		
		firstNameAthleteText.setText(currentAthlete.getFirstName());
	    miAthleteText.setText(String.valueOf(currentAthlete.getMiddleInitial()));
	    lastNameAthleteText.setText(currentAthlete.getLastName());
	    sportsAthleteText.setText(currentAthlete.getSports());
	    yearAthleteText.setText(currentAthlete.getYearAtUniversity());
	    idAthleteText.setText(String.valueOf(currentAthlete.getStudentID()));
	    eligibilityAthleteText.setText(currentAthlete.getEligibility());
	    activeCheckBox.setSelected(currentAthlete.isActive());
	    
	    phoneContactText.setText(currentAthlete.getCellNumber());
	    ecContactText1.setText(currentAthlete.getContacts().getContact1Name());
	    ecPhoneContactText1.setText(currentAthlete.getContacts().getContact1Phone());
	    ecContactText2.setText(currentAthlete.getContacts().getContact2Name());
	    ecPhoneContactText2.setText(currentAthlete.getContacts().getContact2Phone());
		
		phoneContactText.setEditable(false);
		ecContactText1.setEditable(false);
		ecContactText2.setEditable(false);
		ecPhoneContactText1.setEditable(false);
		ecPhoneContactText2.setEditable(false);
		
		firstNameAthleteText.setEditable(false);
		miAthleteText.setEditable(false);
		lastNameAthleteText.setEditable(false);
		sportsAthleteText.setEditable(false);
		yearAthleteText.setEditable(false);
		idAthleteText.setEditable(false);	
		eligibilityAthleteText.setEditable(false);
		activeCheckBox.setDisable(true);
		
		//clear css class
		phoneContactText.getStyleClass().clear();
		ecContactText1.getStyleClass().clear();
		ecContactText2.getStyleClass().clear();
		ecPhoneContactText1.getStyleClass().clear();
		ecPhoneContactText2.getStyleClass().clear();
		
		firstNameAthleteText.getStyleClass().clear();
		miAthleteText.getStyleClass().clear();
		lastNameAthleteText.getStyleClass().clear();
		sportsAthleteText.getStyleClass().clear();
		yearAthleteText.getStyleClass().clear();
		idAthleteText.getStyleClass().clear();
		eligibilityAthleteText.getStyleClass().clear();
		
		//set css class
		phoneContactText.getStyleClass().add("selectedAthlete");
		ecContactText1.getStyleClass().add("selectedAthlete");
		ecContactText2.getStyleClass().add("selectedAthlete");
		ecPhoneContactText1.getStyleClass().add("selectedAthlete");
		ecPhoneContactText2.getStyleClass().add("selectedAthlete");
		
		firstNameAthleteText.getStyleClass().add("selectedAthlete");
		miAthleteText.getStyleClass().add("selectedAthlete");
		lastNameAthleteText.getStyleClass().add("selectedAthlete");
		sportsAthleteText.getStyleClass().add("selectedAthlete");
		yearAthleteText.getStyleClass().add("selectedAthlete");
		idAthleteText.getStyleClass().add("selectedAthlete");
		eligibilityAthleteText.getStyleClass().add("selectedAthlete");
	}
	
	public void InjuryTypeComboBoxAction(MouseEvent ae){
		if(bodyPartComboBox.getValue() != null){
			ae.consume();
			if((System.currentTimeMillis()-previous)>=REFRESHTIMEOUT){
				previous=System.currentTimeMillis();
				ArrayList<String> injuryTypes = atdb.getInjuryTypeByBodyPart(bodyPartComboBox.getValue());
				Collections.sort(injuryTypes);
				injuryTypeComboBox.getItems().setAll(injuryTypes);
	        }
		}

	}
	
	public void searchButtonAction(ActionEvent ae){
		ae.consume();
		//get athletes from database
		//searchTableView.getItems().setAll(atdb.searchDatabase(atdb.sanitize(firstNameSearchText.getText()), atdb.sanitize(middleInitialSearchText.getText()), atdb.sanitize(lastNameSearchText.getText()), sportComboBox.getValue(), bodyPartComboBox.getValue(), injuryTypeComboBox.getValue(), activeInjuryComboBox.getValue(), java.sql.Date.valueOf("2015-06-09")/*start*/,java.sql.Date.valueOf("2015-06-09") /*end*/, studentNumberSearchText.getText(), seasonComboBox.getValue(), genderComboBox.getValue()));
		//searchTableView.getItems().setAll(atdb.searchDatabase("", "", "", "", "", "", "", new  java.sql.Date(System.currentTimeMillis()), new  java.sql.Date(System.currentTimeMillis()), "", "", ""));
		Date date1;
		if(startDateDatePicker.getValue() !=null){
		LocalDate localDate1 = startDateDatePicker.getValue();
		Instant instant1 = Instant.from(localDate1.atStartOfDay(ZoneId.systemDefault()));
		date1 = Date.from(instant1);
		}
		else{
			date1=new Date();
		}
		Date date2;
		if(endDateDatePicker.getValue()!=null){
		LocalDate localDate2 = endDateDatePicker.getValue();
		Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
		date2 = Date.from(instant2);
		}
		else{
			date2=new Date();
		}
		
		
		
		searchTableView.getItems().setAll(atdb.searchDatabase(atdb.sanitize(firstNameSearchText.getText()), atdb.sanitize(middleInitialSearchText.getText()), atdb.sanitize(lastNameSearchText.getText()),atdb.sanitize(sportComboBox.getValue()), atdb.sanitize(bodyPartComboBox.getValue()), atdb.sanitize(injuryTypeComboBox.getValue()), atdb.sanitize(activeInjuryComboBox.getValue()), date1,date2, atdb.sanitize(studentNumberSearchText.getText()), atdb.sanitize(seasonComboBox.getValue()), atdb.sanitize(genderComboBox.getValue())));
	

	}
	
	public void handlerEnterPressed(KeyEvent e){
		if(e.getCode() == KeyCode.ENTER){
			e.consume();
			//get athletes from database
			//searchTableView.getItems().setAll(atdb.searchDatabase(atdb.sanitize(firstNameSearchText.getText()), atdb.sanitize(middleInitialSearchText.getText()), atdb.sanitize(lastNameSearchText.getText()), sportComboBox.getValue(), bodyPartComboBox.getValue(), injuryTypeComboBox.getValue(), activeInjuryComboBox.getValue(), java.sql.Date.valueOf("2015-06-09")/*start*/,java.sql.Date.valueOf("2015-06-09") /*end*/, studentNumberSearchText.getText(), seasonComboBox.getValue(), genderComboBox.getValue()));
			//searchTableView.getItems().setAll(atdb.searchDatabase("", "", "", "", "", "", "", new  java.sql.Date(System.currentTimeMillis()), new  java.sql.Date(System.currentTimeMillis()), "", "", ""));
			Date date1;
			if(startDateDatePicker.getValue() !=null){
			LocalDate localDate1 = startDateDatePicker.getValue();
			Instant instant1 = Instant.from(localDate1.atStartOfDay(ZoneId.systemDefault()));
			date1 = Date.from(instant1);
			}
			else{
				date1=new Date();
			}
			Date date2;
			if(endDateDatePicker.getValue()!=null){
			LocalDate localDate2 = endDateDatePicker.getValue();
			Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
			date2 = Date.from(instant2);
			}
			else{
				date2=new Date();
			}
			
			
			
			searchTableView.getItems().setAll(atdb.searchDatabase(atdb.sanitize(firstNameSearchText.getText()), atdb.sanitize(middleInitialSearchText.getText()), atdb.sanitize(lastNameSearchText.getText()),atdb.sanitize(sportComboBox.getValue()), atdb.sanitize(bodyPartComboBox.getValue()), atdb.sanitize(injuryTypeComboBox.getValue()), atdb.sanitize(activeInjuryComboBox.getValue()), date1,date2, atdb.sanitize(studentNumberSearchText.getText()), atdb.sanitize(seasonComboBox.getValue()), atdb.sanitize(genderComboBox.getValue())));
			
		}
	}
	
	public void generateReportButtonAction(ActionEvent ae){
		ae.consume();
		Date date1;
		if(startDateDatePicker.getValue() !=null){
		LocalDate localDate1 = startDateDatePicker.getValue();
		Instant instant1 = Instant.from(localDate1.atStartOfDay(ZoneId.systemDefault()));
		date1 = Date.from(instant1);
		}
		else{
			date1=new Date();
		}
		Date date2;
		if(endDateDatePicker.getValue()!=null){
		LocalDate localDate2 = endDateDatePicker.getValue();
		Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
		date2 = Date.from(instant2);
		}
		else{
			date2=new Date();
		}
		atdb.searchDatabase(atdb.sanitize(firstNameSearchText.getText()), atdb.sanitize(middleInitialSearchText.getText()), atdb.sanitize(lastNameSearchText.getText()),atdb.sanitize(sportComboBox.getValue()), atdb.sanitize(bodyPartComboBox.getValue()), atdb.sanitize(injuryTypeComboBox.getValue()), atdb.sanitize(activeInjuryComboBox.getValue()), date1,date2, atdb.sanitize(studentNumberSearchText.getText()), atdb.sanitize(seasonComboBox.getValue()), atdb.sanitize(genderComboBox.getValue()));
		atdb.generateReport();
		
		generatedLabel.setText("Report has been generated\nand file sent to your desktop.");
		FadeTransition fader = new FadeTransition(Duration.millis(8000), generatedLabel);
		fader.setFromValue(1.0);
		fader.setToValue(0.0);
	    fader.setCycleCount(1);
	    fader.setAutoReverse(false);

	    fader.play();
		
	}
	
	public void searchTableViewMousePressed(MouseEvent me){
		 if (me.getClickCount() >= 2) {
	        currentAthlete = (searchTableView.getSelectionModel().getSelectedItem()); 
	           
			//Populate Selected Athlete Tab
			firstNameAthleteText.setText(currentAthlete.getFirstName());
			miAthleteText.setText(String.valueOf(currentAthlete.getMiddleInitial()));
			lastNameAthleteText.setText(currentAthlete.getLastName());
			sportsAthleteText.setText(currentAthlete.getSports());
		//	dobAthleteText.setText(currentAthlete.getDateOfBirth().toString());
			yearAthleteText.setText(currentAthlete.getYearAtUniversity());
			idAthleteText.setText(String.valueOf(currentAthlete.getStudentID()));
			eligibilityAthleteText.setText(currentAthlete.getEligibility());
			activeCheckBox.setSelected(currentAthlete.isActive());
			   
			phoneContactText.setText(currentAthlete.getCellNumber());
			ecContactText1.setText(currentAthlete.getContacts().getContact1Name());
			ecPhoneContactText1.setText(currentAthlete.getContacts().getContact1Phone());
			ecContactText2.setText(currentAthlete.getContacts().getContact2Name());
			ecPhoneContactText2.setText(currentAthlete.getContacts().getContact2Phone());
			   
			//add columns of injuries of current athlete
			   
			//injury table
			columnInjury = new TextColumn<Injury>("injuryType");
			columnDate = new TextColumn<Injury>("injuryDate");
			columnActiveinj = new CheckBoxColumn<Injury>("active");
			columnSOAPNotes = new TextColumn<Injury>("soapNotes");
			columnProgressNotes = new TextColumn<Injury>("injuryProgressNotes");
			columnPhysicianNotes = new TextColumn<Injury>("physicianVisit");
			
			//injury width
			columnInjury.setMinWidth(200);
			columnDate.setMinWidth(20);
			columnActiveinj.setMinWidth(20);
			columnSOAPNotes.setMinWidth(200);
			columnProgressNotes.setMinWidth(200);
			columnPhysicianNotes.setMinWidth(200);
			
			columnInjury.setResizable(false);
			columnDate.setResizable(false);
			columnActiveinj.setResizable(false);
			columnSOAPNotes.setResizable(false);
			columnProgressNotes.setResizable(false);
			columnPhysicianNotes.setResizable(false);
			
			//set titles
			columnInjury.setText("Injury");
			columnDate.setText("Date");
			columnActiveinj.setText("Active");
			columnSOAPNotes.setText("SOAP Notes");
			columnProgressNotes.setText("Progress Notes");
			columnPhysicianNotes.setText("Physician Visit");
			
			//add columns to injury table
			injuriesTableView.getColumns().clear();
			injuriesTableView.getColumns().add(columnInjury);
			injuriesTableView.getColumns().add(columnDate);
			injuriesTableView.getColumns().add(columnActiveinj);
			injuriesTableView.getColumns().add(columnSOAPNotes);
			injuriesTableView.getColumns().add(columnProgressNotes);
			injuriesTableView.getColumns().add(columnPhysicianNotes);
				
			injuriesTableView.getItems().setAll(currentAthlete.getInjuryList());
			   
			//changes tab to selected Athlete
			tabPane.getSelectionModel().select(selectedAthleteTab);
			
		 }
	}
	
	public void injuriesTableViewMousePressed(MouseEvent ml){
		 if (ml.getClickCount() >= 2) { 
			
			 currentAthlete.setCurrentInjury(injuriesTableView.getSelectionModel().getSelectedItem()); 
			// System.out.println(currentAthlete.getCurrentInjury()==null);
			 new EditInjuryWindow(currentAthlete);
		 }
	}
	
	
	
	public void displayInsuranceButtonAction(ActionEvent ae)
	{
		ae.consume();
		if(currentAthlete == null){
			displayInsuranceError.setText("Please search and double click on an athlete\nbefore using this tab.");
			FadeTransition fader = new FadeTransition(Duration.millis(2000), displayInsuranceError);
			fader.setFromValue(1.0);
			fader.setToValue(0.0);
		    fader.setCycleCount(3);
		    fader.setAutoReverse(false);

		    fader.play();
		}
		else{
			new InsuranceWindow(currentAthlete);
		}
	}	
	
	public void addAthleteButtonAction(ActionEvent ae)
	{
		ae.consume();
		
		LocalDate localDate = dobAddAthletedatePicker.getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date datedob = Date.from(instant);
		
		LocalDate lDate = effectiveDateDatePicker.getValue();
		Instant it = Instant.from(lDate.atStartOfDay(ZoneId.systemDefault()));
		Date dateeff = Date.from(it);
		LocalDate lolDate = expirationDateDatePicker.getValue();
		Instant ins = Instant.from(lolDate.atStartOfDay(ZoneId.systemDefault()));
		Date dateexp = Date.from(ins);
		
		String sports="";
		
		ObservableList<String> selectedItems =  sportsAddAthleteListView.getSelectionModel().getSelectedItems();
		for(int count=0;count<selectedItems.size()-1;count++){
			sports+=selectedItems.get(count)+",";
		}
		if(!selectedItems.isEmpty()){
			sports+=selectedItems.get(selectedItems.size()-1);
		}
		
		if(coverAthleteInjuryAddAthleteComboBox.getValue().equalsIgnoreCase("yes")){
			coverAthlete=true;
		}
		else{
			coverAthlete=false;
		}
		
		if(referralAddAthleteComboBox.getValue().equalsIgnoreCase("yes")){
			referral=true;	
		}
		else{
			referral=false;
		}
		
		EmergencyContact contacts = new EmergencyContact(ecNameAddAthleteText1.getText(), 
			ecPhoneAddAthleteText1.getText(), ecNameAddAthleteText2.getText(), ecPhoneAddAthleteText2.getText());
		InsuranceInformation insuranceInformation = new InsuranceInformation(athleteSSNAddAthleteText.getText(), 
			insuranceNameAddAthleteText.getText(), insurancePhoneAddAthleteText.getText(), IDAddAthleteText.getText(), 
			groupNumberAddAthleteText.getText(), companyAddressAddAthleteText.getText(), new java.sql.Date(dateeff.getTime()), 
			new java.sql.Date(dateexp.getTime()),coverAthlete, preCertificationPhoneAddAthleteText.getText(), 
			policyHolderAddAthleteText.getText(),policyHolderPhoneAddAthleteText.getText(), policyHolderAddressAddAthleteText.getText(),
			Integer.parseInt(limitAddAthleteText.getText()), Integer.parseInt(deductableAddAthleteText.getText()),
			Integer.parseInt(coPayAddAthleteText.getText()), referral,
			primaryPhysicianAddAthleteText.getText(), physicianPhoneAddAthleteText.getText());
		Athlete athlete = new Athlete(firstAddAthleteText.getText(), miAddAthleteText.getText().charAt(0), 
			lastAddAthleteText.getText(),new java.sql.Date(datedob.getTime()), cellAddAthleteText.getText(), 
			Integer.parseInt(idAddAthleteText.getText()), genderAddAthleteComboBox.getValue().charAt(0), ""+yearAddAthleteComboBox.getValue(), 
			eligibilityAddAthleteComboBox.getValue(), activeAddAthleteCheckBox.isSelected(), allergiesAddAthleteText.getText(), 
			medicationsAddAthletText.getText(),sports , new ArrayList<Injury>(), contacts, insuranceInformation);
			atdb.addAthlete(athlete);
		
	}
	
	public void addInjuryButtonAction(ActionEvent ae)
	{
		if(currentAthlete == null){
			addInjuryError.setText("Please search and double click on an athlete\nbefore using this tab.");
			FadeTransition fader = new FadeTransition(Duration.millis(2000), addInjuryError);
			fader.setFromValue(1.0);
			fader.setToValue(0.0);
		    fader.setCycleCount(3);
		    fader.setAutoReverse(false);

		    fader.play();
		}
		else{
			new AddInjuryWindow(currentAthlete);
		}
	}
	public Athlete getCurrentAthlete(){
		return currentAthlete;
	}

}
