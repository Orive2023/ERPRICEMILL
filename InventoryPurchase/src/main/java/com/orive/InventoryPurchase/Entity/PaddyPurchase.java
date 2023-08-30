package com.orive.InventoryPurchase.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "paddypurchase")
public class PaddyPurchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paddyPurchaseId;
	
	@Column(name = "rst_number")
	private String rstNumber;
	
	@Column(name = "rst_details")
	private String rstDetails;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "created_at")
    private LocalDateTime createdAt;
	
	@Column(name = "party")
	private String party;
	
	@Column(name = "mobile_number")
	private Long mobileNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column(name = "gross_weight")
	private double grossWeight;
	
	@Column(name = "tare_weight")
	private double tareWeight;
	
	@Column(name = "net_weight")
	private double netWeight;
	
	@Column(name = "old")
	private double old;
	
	@Column(name = "pkt")
	private double pkt;
	
	@Column(name = "p_pkt")
	private double pPkt;
	
	@Column(name = "rejectd")
	private double rejected;
	
	@Column(name = "total_no_of_gunny")
	private double totalNoOfGunny;
	
	@Column(name = "avg_wt_pkt")
	private double avgWtPkt;
	
	@OneToMany(targetEntity = PaddyDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "paddy_purchase_paddy_details_fk",referencedColumnName = "paddyPurchaseId")
	private List<PaddyDetails> paddyDetails;
	
	@Column(name = "total_no_of_pkts")
	private double totalNoOfPkts;
	
	public double calculateTotalNoOfPkts()
	{
		totalNoOfPkts=paddyDetails.stream().mapToDouble(PaddyDetails::getNoOfPkts).sum();
		return totalNoOfPkts;
	}
	
	public void calculateNetWeight()
	{
		netWeight=grossWeight+tareWeight;
	}
	
	public void calculateTotalNoOfGunny()
	{
		totalNoOfGunny=pkt+pPkt;
	}
	
	public double calculateAvgWtPerPkt()
	{
		avgWtPkt=netWeight/totalNoOfGunny;
		return avgWtPkt;
	}
	
	public void calculateTotalAmount()
	{
		totalAmount=ratePerKg*finalWt;
	}
	
	public void calculateTotal()
	{
		totalPkt=godownDetails.stream().mapToDouble(GodownDetails::getPaddyInPkts).sum();
	}
	
	public void calculateLabourCharge()
	{
		labourCharge=labourAmount*noOfLabourPresent;
	}
	
	@Column(name = "total_gunny_wt")
	private double totalGunnyWt;
	
	@Column(name = "total_mc_cutting")
	private double totalMcCutting;
	
	@Column(name = "total_qc_cutting")
	private double totalQcCutting;
	
	@Column(name = "find_wt")
	private double finalWt;
	
	@Column(name = "rate_per_kg")
	private double ratePerKg;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "labour_amount")
	private double labourAmount;
	
	@Column(name = "no_of_labour_present")
	private Long noOfLabourPresent;

	@OneToMany(targetEntity = GodownDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "pg_fk",referencedColumnName = "paddyPurchaseId")
	private List<GodownDetails> godownDetails;
	
	@Column(name = "total_pkt")
	private double totalPkt;
	
	@Column(name = "labour_charge")
	private double labourCharge;
	
    @Transient
	private Farmer farmer;
	
	
}
