package mainclient;

import java.net.URL;
import java.util.ResourceBundle;

import sun.security.jca.GetInstance;
import edu.adams.backendboys.Athlete;
import edu.adams.backendboys.Injury;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InsuranceWindowController implements Initializable {
	
	private Athlete currentAthlete = null;
	@FXML
	private Button insuranceInformationEditButton,
		insuranceInformationCancelButton;
	@FXML
	private TextField athleteNameInsuranceInformationLabel1,
		dobInsuranceInformationLabel1,
		athleteCellInsuranceInformationLabel1,
		ssnInsuranceInformationLabel1,
		genderInsuranceInformationLabel1,
		sportsInsuranceInformationLabel1,
		allergiesInsuranceInformationLabel1,
		medicationsInsuranceInformationLabel1,
		ecInsuranceInformationLabel11,
		ecPhoneInsuranceInformationLabel11,
		ecInsuranceInformationLabel21,
		ecPhoneInsuranceInformationLabel21,
		insuranceNameInsuranceInformationLabel11,
		insuranceAddressInsuranceInformationLabel1,
		insurancePhoneInsuranceInformationLabel1,
		groupNumberInsuranceInformationLabel1,
		effectiveDateInsuranceInformationLabel1,
		expirationDateInsuranceInformationLabel1,
		coverAthleteInjuryInsuranceInformationLabel1,
		precertificationPhoneInsuranceInformationLabel1,
		policyHolderInsuranceInformationLabel1,
		policyHolderPhoneInsuranceInformationLabel1,
		limitInsuranceInformationLabel1,
		deductibleInsuranceInformationLabel1,
		copayInsuranceInformationLabel1,
		referralInsuranceInformationLabel1,
		primaryPhysicianInsuranceInformationLabel1,
		physicianPhoneInsuranceInformationLabel1;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public void setAthlete(Athlete currentAthlete){
		this.currentAthlete = currentAthlete;
		athleteNameInsuranceInformationLabel1.setText(currentAthlete.getFirstName()+" "+currentAthlete.getMiddleInitial()+" "+currentAthlete.getLastName());
		dobInsuranceInformationLabel1.setText(currentAthlete.getDateOfBirth().toString());
		athleteCellInsuranceInformationLabel1.setText(currentAthlete.getCellNumber());
		ssnInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getStudentSSN());
		genderInsuranceInformationLabel1.setText(String.valueOf(currentAthlete.getGender()));
		sportsInsuranceInformationLabel1.setText(currentAthlete.getSports());
		allergiesInsuranceInformationLabel1.setText(currentAthlete.getAllergies());
		medicationsInsuranceInformationLabel1.setText(currentAthlete.getMedications());
		ecInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Name());
		ecPhoneInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Phone());
		ecInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Name());
		ecPhoneInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Phone());
		insuranceNameInsuranceInformationLabel11.setText(currentAthlete.getInsuranceInfo().getCompanyName());
		insuranceAddressInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getAddress());
		insurancePhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getInsurancePhone());
		groupNumberInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getGroupNummber());
		effectiveDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyEffective().toString());
		expirationDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyExpiration().toString());
		coverAthleteInjuryInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getCoverAthleticInjury().toString());
		precertificationPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPreCertPhone());
		policyHolderInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolder());
		policyHolderPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolderPhone());
		limitInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getLimit());
		deductibleInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getDeductible());
		copayInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getCoPay());
		referralInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getReferral().toString());
		primaryPhysicianInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPrimaryPhysician());
		physicianPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPhysicianPhone());
	
	}
	public void insuranceInformationEditButtonAction(ActionEvent ae){
			ae.consume();
		if(insuranceInformationEditButton.getText().startsWith("Edit"))
		{
			insuranceInformationEditButton.setText("Save");
			
			athleteNameInsuranceInformationLabel1.setEditable(true);
			dobInsuranceInformationLabel1.setEditable(true);
			athleteCellInsuranceInformationLabel1.setEditable(true);
			ssnInsuranceInformationLabel1.setEditable(true);
			genderInsuranceInformationLabel1.setEditable(true);
			sportsInsuranceInformationLabel1.setEditable(true);
			allergiesInsuranceInformationLabel1.setEditable(true);
			medicationsInsuranceInformationLabel1.setEditable(true);
			ecInsuranceInformationLabel11.setEditable(true);
			ecPhoneInsuranceInformationLabel11.setEditable(true);
			ecInsuranceInformationLabel21.setEditable(true);
			ecPhoneInsuranceInformationLabel21.setEditable(true);
			insuranceNameInsuranceInformationLabel11.setEditable(true);
			insuranceAddressInsuranceInformationLabel1.setEditable(true);
			insurancePhoneInsuranceInformationLabel1.setEditable(true);
			groupNumberInsuranceInformationLabel1.setEditable(true);
			effectiveDateInsuranceInformationLabel1.setEditable(true);
			expirationDateInsuranceInformationLabel1.setEditable(true);
			coverAthleteInjuryInsuranceInformationLabel1.setEditable(true);
			precertificationPhoneInsuranceInformationLabel1.setEditable(true);
			policyHolderInsuranceInformationLabel1.setEditable(true);
			policyHolderPhoneInsuranceInformationLabel1.setEditable(true);
			limitInsuranceInformationLabel1.setEditable(true);
			deductibleInsuranceInformationLabel1.setEditable(true);
			copayInsuranceInformationLabel1.setEditable(true);
			referralInsuranceInformationLabel1.setEditable(true);
			primaryPhysicianInsuranceInformationLabel1.setEditable(true);
			physicianPhoneInsuranceInformationLabel1.setEditable(true);
			
			//set css class
			athleteNameInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			dobInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			athleteCellInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			ssnInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			genderInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			sportsInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			allergiesInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			medicationsInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			ecInsuranceInformationLabel11.getStyleClass().add("displayInsuranceEdit");
			ecPhoneInsuranceInformationLabel11.getStyleClass().add("displayInsuranceEdit");
			ecInsuranceInformationLabel21.getStyleClass().add("displayInsuranceEdit");
			ecPhoneInsuranceInformationLabel21.getStyleClass().add("displayInsuranceEdit");
			insuranceNameInsuranceInformationLabel11.getStyleClass().add("displayInsuranceEdit");
			insuranceAddressInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			insurancePhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			groupNumberInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			effectiveDateInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			expirationDateInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			precertificationPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			policyHolderInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			policyHolderPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			limitInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			deductibleInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			copayInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			referralInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			primaryPhysicianInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			physicianPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			
			//reveal cancel button
			insuranceInformationCancelButton.setVisible(true);
			
		}
		
		else
		{
			insuranceInformationEditButton.setText("Edit");
			
			athleteNameInsuranceInformationLabel1.setEditable(false);
			dobInsuranceInformationLabel1.setEditable(false);
			athleteCellInsuranceInformationLabel1.setEditable(false);
			ssnInsuranceInformationLabel1.setEditable(false);
			genderInsuranceInformationLabel1.setEditable(false);
			sportsInsuranceInformationLabel1.setEditable(false);
			allergiesInsuranceInformationLabel1.setEditable(false);
			medicationsInsuranceInformationLabel1.setEditable(false);
			ecInsuranceInformationLabel11.setEditable(false);
			ecPhoneInsuranceInformationLabel11.setEditable(false);
			ecInsuranceInformationLabel21.setEditable(false);
			ecPhoneInsuranceInformationLabel21.setEditable(false);
			insuranceNameInsuranceInformationLabel11.setEditable(false);
			insuranceAddressInsuranceInformationLabel1.setEditable(false);
			insurancePhoneInsuranceInformationLabel1.setEditable(false);
			groupNumberInsuranceInformationLabel1.setEditable(false);
			effectiveDateInsuranceInformationLabel1.setEditable(false);
			expirationDateInsuranceInformationLabel1.setEditable(false);
			coverAthleteInjuryInsuranceInformationLabel1.setEditable(false);
			precertificationPhoneInsuranceInformationLabel1.setEditable(false);
			policyHolderInsuranceInformationLabel1.setEditable(false);
			policyHolderPhoneInsuranceInformationLabel1.setEditable(false);
			limitInsuranceInformationLabel1.setEditable(false);
			deductibleInsuranceInformationLabel1.setEditable(false);
			copayInsuranceInformationLabel1.setEditable(false);
			referralInsuranceInformationLabel1.setEditable(false);
			primaryPhysicianInsuranceInformationLabel1.setEditable(false);
			physicianPhoneInsuranceInformationLabel1.setEditable(false);
			
			athleteNameInsuranceInformationLabel1.getStyleClass().clear();
			dobInsuranceInformationLabel1.getStyleClass().clear();
			athleteCellInsuranceInformationLabel1.getStyleClass().clear();
			ssnInsuranceInformationLabel1.getStyleClass().clear();
			genderInsuranceInformationLabel1.getStyleClass().clear();
			sportsInsuranceInformationLabel1.getStyleClass().clear();
			allergiesInsuranceInformationLabel1.getStyleClass().clear();
			medicationsInsuranceInformationLabel1.getStyleClass().clear();
			ecInsuranceInformationLabel11.getStyleClass().clear();
			ecPhoneInsuranceInformationLabel11.getStyleClass().clear();
			ecInsuranceInformationLabel21.getStyleClass().clear();
			ecPhoneInsuranceInformationLabel21.getStyleClass().clear();
			insuranceNameInsuranceInformationLabel11.getStyleClass().clear();
			insuranceAddressInsuranceInformationLabel1.getStyleClass().clear();
			insurancePhoneInsuranceInformationLabel1.getStyleClass().clear();
			groupNumberInsuranceInformationLabel1.getStyleClass().clear();
			effectiveDateInsuranceInformationLabel1.getStyleClass().clear();
			expirationDateInsuranceInformationLabel1.getStyleClass().clear();
			coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().clear();
			precertificationPhoneInsuranceInformationLabel1.getStyleClass().clear();
			policyHolderInsuranceInformationLabel1.getStyleClass().clear();
			policyHolderPhoneInsuranceInformationLabel1.getStyleClass().clear();
			limitInsuranceInformationLabel1.getStyleClass().clear();
			deductibleInsuranceInformationLabel1.getStyleClass().clear();
			copayInsuranceInformationLabel1.getStyleClass().clear();
			referralInsuranceInformationLabel1.getStyleClass().clear();
			primaryPhysicianInsuranceInformationLabel1.getStyleClass().clear();
			physicianPhoneInsuranceInformationLabel1.getStyleClass().clear();
			
			//set css class
			athleteNameInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			dobInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			athleteCellInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			ssnInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			genderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			sportsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			allergiesInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			medicationsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			ecInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
			ecPhoneInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
			ecInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
			ecPhoneInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
			insuranceNameInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
			insuranceAddressInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			insurancePhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			groupNumberInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			effectiveDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			expirationDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			precertificationPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			policyHolderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			policyHolderPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			limitInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			deductibleInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			copayInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			referralInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			primaryPhysicianInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			physicianPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			
			//hide cancel button
			insuranceInformationCancelButton.setVisible(false);
			
			}
		}

	public void insuranceInformationCancelButtonAction(ActionEvent ae)
	{
		ae.consume();
		
		//hide cancel button
		insuranceInformationCancelButton.setVisible(false);
		
		insuranceInformationEditButton.setText("Edit");
		
		athleteNameInsuranceInformationLabel1.setText(currentAthlete.getFirstName()+" "+currentAthlete.getMiddleInitial()+" "+currentAthlete.getLastName());
		dobInsuranceInformationLabel1.setText(currentAthlete.getDateOfBirth().toString());
		athleteCellInsuranceInformationLabel1.setText(currentAthlete.getCellNumber());
		ssnInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getStudentSSN());
		genderInsuranceInformationLabel1.setText(String.valueOf(currentAthlete.getGender()));
		sportsInsuranceInformationLabel1.setText(currentAthlete.getSports());
		allergiesInsuranceInformationLabel1.setText(currentAthlete.getAllergies());
		medicationsInsuranceInformationLabel1.setText(currentAthlete.getMedications());
		ecInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Name());
		ecPhoneInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Phone());
		ecInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Name());
		ecPhoneInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Phone());
		insuranceNameInsuranceInformationLabel11.setText(currentAthlete.getInsuranceInfo().getCompanyName());
		insuranceAddressInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getAddress());
		insurancePhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getInsurancePhone());
		groupNumberInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getGroupNummber());
		effectiveDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyEffective().toString());
		expirationDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyExpiration().toString());
		coverAthleteInjuryInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getCoverAthleticInjury().toString());
		precertificationPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPreCertPhone());
		policyHolderInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolder());
		policyHolderPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolderPhone());
		limitInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getLimit());
		deductibleInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getDeductible());
		copayInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getCoPay());
		referralInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getReferral().toString());
		primaryPhysicianInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPrimaryPhysician());
		physicianPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPhysicianPhone());
		
		athleteNameInsuranceInformationLabel1.setEditable(false);
		dobInsuranceInformationLabel1.setEditable(false);
		athleteCellInsuranceInformationLabel1.setEditable(false);
		ssnInsuranceInformationLabel1.setEditable(false);
		genderInsuranceInformationLabel1.setEditable(false);
		sportsInsuranceInformationLabel1.setEditable(false);
		allergiesInsuranceInformationLabel1.setEditable(false);
		medicationsInsuranceInformationLabel1.setEditable(false);
		ecInsuranceInformationLabel11.setEditable(false);
		ecPhoneInsuranceInformationLabel11.setEditable(false);
		ecInsuranceInformationLabel21.setEditable(false);
		ecPhoneInsuranceInformationLabel21.setEditable(false);
		insuranceNameInsuranceInformationLabel11.setEditable(false);
		insuranceAddressInsuranceInformationLabel1.setEditable(false);
		insurancePhoneInsuranceInformationLabel1.setEditable(false);
		groupNumberInsuranceInformationLabel1.setEditable(false);
		effectiveDateInsuranceInformationLabel1.setEditable(false);
		expirationDateInsuranceInformationLabel1.setEditable(false);
		coverAthleteInjuryInsuranceInformationLabel1.setEditable(false);
		precertificationPhoneInsuranceInformationLabel1.setEditable(false);
		policyHolderInsuranceInformationLabel1.setEditable(false);
		policyHolderPhoneInsuranceInformationLabel1.setEditable(false);
		limitInsuranceInformationLabel1.setEditable(false);
		deductibleInsuranceInformationLabel1.setEditable(false);
		copayInsuranceInformationLabel1.setEditable(false);
		referralInsuranceInformationLabel1.setEditable(false);
		primaryPhysicianInsuranceInformationLabel1.setEditable(false);
		physicianPhoneInsuranceInformationLabel1.setEditable(false);
		
		//clear css class
		athleteNameInsuranceInformationLabel1.getStyleClass().clear();
		dobInsuranceInformationLabel1.getStyleClass().clear();
		athleteCellInsuranceInformationLabel1.getStyleClass().clear();
		ssnInsuranceInformationLabel1.getStyleClass().clear();
		genderInsuranceInformationLabel1.getStyleClass().clear();
		sportsInsuranceInformationLabel1.getStyleClass().clear();
		allergiesInsuranceInformationLabel1.getStyleClass().clear();
		medicationsInsuranceInformationLabel1.getStyleClass().clear();
		ecInsuranceInformationLabel11.getStyleClass().clear();
		ecPhoneInsuranceInformationLabel11.getStyleClass().clear();
		ecInsuranceInformationLabel21.getStyleClass().clear();
		ecPhoneInsuranceInformationLabel21.getStyleClass().clear();
		insuranceNameInsuranceInformationLabel11.getStyleClass().clear();
		insuranceAddressInsuranceInformationLabel1.getStyleClass().clear();
		insurancePhoneInsuranceInformationLabel1.getStyleClass().clear();
		groupNumberInsuranceInformationLabel1.getStyleClass().clear();
		effectiveDateInsuranceInformationLabel1.getStyleClass().clear();
		expirationDateInsuranceInformationLabel1.getStyleClass().clear();
		coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().clear();
		precertificationPhoneInsuranceInformationLabel1.getStyleClass().clear();
		policyHolderInsuranceInformationLabel1.getStyleClass().clear();
		policyHolderPhoneInsuranceInformationLabel1.getStyleClass().clear();
		limitInsuranceInformationLabel1.getStyleClass().clear();
		deductibleInsuranceInformationLabel1.getStyleClass().clear();
		copayInsuranceInformationLabel1.getStyleClass().clear();
		referralInsuranceInformationLabel1.getStyleClass().clear();
		primaryPhysicianInsuranceInformationLabel1.getStyleClass().clear();
		physicianPhoneInsuranceInformationLabel1.getStyleClass().clear();
		
		//set css class
		athleteNameInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		dobInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		athleteCellInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		ssnInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		genderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		sportsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		allergiesInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		medicationsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		ecInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
		ecPhoneInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
		ecInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
		ecPhoneInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
		insuranceNameInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
		insuranceAddressInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		insurancePhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		groupNumberInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		effectiveDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		expirationDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		precertificationPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		policyHolderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		policyHolderPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		limitInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		deductibleInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		copayInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		referralInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		primaryPhysicianInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		physicianPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
	}
}
