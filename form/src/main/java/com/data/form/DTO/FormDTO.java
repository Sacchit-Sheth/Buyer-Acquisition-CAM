package com.data.form.DTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "formCAM")
public class FormDTO {

	@Id
	private String submissionId;

	private boolean isSubmitted=false;
	private double turnoverLastYear;

	private double turnoverYearBefore;

	private String businessStart;

	private String customerCategory;

	private double currentYearMonthyRunRate;

	private double otherBusinesses;

	private int noOfEmployees;

	private double totalSalarypaid;

	private double defaultedLoanAmount;

	private String nameSupplier1;

	private double amountOfBusiness1;

	private int durationOfBusiness1;

	private String paymentBehaviour1;

	private String delayInstance1;

	private String nameSupplier2;

	private double amountOfBusiness2;

	private int durationOfBusiness2;

	private String paymentBehaviour2;

	private String delayInstance2;

	private String nameNeighbour1;

	private int durationOfNeighbourBusiness1;

	private String generalConduct1;

	private String nameNeighbour2;

	private int durationOfNeighbourBusiness2;

	private String generalConduct2;

	private int numberOfDependents;

	private int numberOfChildren;
	private int numberOfParent;
	private int numberOfJointFamily;

	private double yearlyFeesPaidForChildren;

	private double totalAssetsOwned;

	private double amountOfFourWheelers;
	private double amountOfTwoWheelers;

	private double amountOfProperties;

	private double totalSavingsAmount;
	private double amountOfFD;
	private double amountOfGold;
	private double amountOfChitFunds;
	private double amountOfEquity;
	private double amountOfOther;

	private double totalInsurancePremium;

	private double totalInsuranceTerm;
	private double totalInsuranceLife;
	private double totalInsuranceHealth;
	private double totalInsuranceBusiness;

	private boolean isOwnedspaceResidential = false;

	private int durationOfOwnedspaceResidential;
	private double purchaseAmountOfOwnedspaceResidential;
	private String modeofAcquirementOfOwnedspaceResidential;
	private int yearOfPurchaseOfOwnedspaceResidential;

	private boolean isRentedspaceResidential = false;

	private int durationOfRentedspaceResidential;
	private double purchaseAmountOfRentedspaceResidential;
	private String modeofAcquirementOfRentedspaceResidential;
	private int yearOfPurchaseOfRentedspaceResidential;

	private boolean isOwnedspaceBusiness = false;

	private int durationOfOwnedspaceBusiness;
	private double purchaseAmountOfOwnedspaceBusiness;
	private String modeofAcquirementOfOwnedspaceBusiness;
	private int yearOfPurchaseOfOwnedspaceBusiness;

	private boolean isRentedspaceBusiness = false;

	private int durationOfRentedspaceBusiness;
	private double purchaseAmountOfRentedspaceBusiness;
	private String modeofAcquirementOfRentedspaceBusiness;
	private int yearOfPurchaseOfRentedspaceBusiness;

	private double limitAmountRequired;
	private double lastAmountEligible;

	private double turnoverLastYearLimitEligibility;

	private boolean subvention;

	private double gstTotalPurchase;

	private double gstTotalPurchaseforAssociatedSupplier;

	private double purchaseAmountConsidered;

	private double purchasesasperBankingWithSupplier;

	private double totalPurchaseLimitEligibility;

	private String bureauDefinition;
	private double lastMonthAgeing;
	private double peakAgeinginLast12months;

	private int unsecuredLoansinLast12months;

	private double writeOffAmount;

	private boolean mobileNumberMatched;

	private double peakAging;

	private double numberOfInstancesOfAging;

	private int numberOfLiveLoans;

	private double settledAmount;

	private int numberofEMIBouncingin3months;

	private int numberofEMIBouncingin6months;

	private double averageMonthlyPurchaseinlast12Months;

	private int numberOfOrdersInAYear;

	private int numberOfYearsRelationshipwithSupplier;
	
	private double averageRepaymentTimeInLast12Months;
	
}
