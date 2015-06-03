package edu.adams.backendboys;

import java.sql.Date;

public class InsuranceInformation {
	private String studentSSN, companyName, insurancePhone, policyID, groupNummber, address, preCertPhone, policyHolder, policyHolderPhone, policyHolderAddress, primaryPhysician, physicianPhone;
	private Date policyEffective, policyExpiration;
	private Boolean coverAthleticInjury, referral;
	private int limit, deductible, coPay;
	
	@SuppressWarnings("unused")
	private InsuranceInformation(){
		
	}
	public InsuranceInformation(String studentSSN, String companyName, String insurancePhone, String policyID, String groupNumber, String address, Date policyEffective, Date policyExpiration, Boolean coverAthleticInjury, String preCertPhone, String policyHolder, String policyHolderPhone, String policyHolderAddress, int limit, int deductible, int coPay, Boolean referral, String primaryPhysician, String physicianPhone){
		this.studentSSN=studentSSN;
		this.companyName=companyName;
		this.insurancePhone=insurancePhone;
		this.policyID=policyID;
		this.groupNummber=groupNumber;
		this.address=address;
		this.policyEffective=policyEffective;
		this.policyExpiration=policyExpiration;
		this.coverAthleticInjury=coverAthleticInjury;
		this.preCertPhone=preCertPhone;
		this.policyHolder=policyHolder;
		this.policyHolderPhone=policyHolderPhone;
		this.policyHolderAddress=policyHolderAddress;
		this.limit=limit;
		this.deductible=deductible;
		this.coPay=coPay;
		this.referral=referral;
		this.primaryPhysician=primaryPhysician;
		this.physicianPhone=physicianPhone;
		
	}
	
	@Override
	public String toString() {
		return "InsuranceInformation [getStudentSSN()=" + getStudentSSN()
				+ ", getCompanyName()=" + getCompanyName()
				+ ", getInsurancePhone()=" + getInsurancePhone()
				+ ", getPolicyID()=" + getPolicyID() + ", getGroupNummber()="
				+ getGroupNummber() + ", getAddress()=" + getAddress()
				+ ", getPreCertPhone()=" + getPreCertPhone()
				+ ", getPolicyHolder()=" + getPolicyHolder()
				+ ", getPolicyHolderPhone()=" + getPolicyHolderPhone()
				+ ", getPolicyHolderAddress()=" + getPolicyHolderAddress()
				+ ", getPrimaryPhysician()=" + getPrimaryPhysician()
				+ ", getPhysicianPhone()=" + getPhysicianPhone()
				+ ", getPolicyEffective()=" + getPolicyEffective()
				+ ", getPolicyExpiration()=" + getPolicyExpiration()
				+ ", getCoverAthleticInjury()=" + getCoverAthleticInjury()
				+ ", getReferral()=" + getReferral() + ", getLimit()="
				+ getLimit() + ", getDeductible()=" + getDeductible()
				+ ", getCoPay()=" + getCoPay() + "]";
	}
	public String getStudentSSN() {
		return studentSSN;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getInsurancePhone() {
		return insurancePhone;
	}
	public String getPolicyID() {
		return policyID;
	}
	public String getGroupNummber() {
		return groupNummber;
	}
	public String getAddress() {
		return address;
	}
	public String getPreCertPhone() {
		return preCertPhone;
	}
	public String getPolicyHolder() {
		return policyHolder;
	}
	public String getPolicyHolderPhone() {
		return policyHolderPhone;
	}
	public String getPolicyHolderAddress() {
		return policyHolderAddress;
	}
	public String getPrimaryPhysician() {
		return primaryPhysician;
	}
	public String getPhysicianPhone() {
		return physicianPhone;
	}
	public Date getPolicyEffective() {
		return policyEffective;
	}
	public Date getPolicyExpiration() {
		return policyExpiration;
	}
	public Boolean getCoverAthleticInjury() {
		return coverAthleticInjury;
	}
	public Boolean getReferral() {
		return referral;
	}
	public int getLimit() {
		return limit;
	}
	public int getDeductible() {
		return deductible;
	}
	public int getCoPay() {
		return coPay;
	}
	
	
}
