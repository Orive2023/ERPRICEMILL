package com.orive.PartyFarmer.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "farmer")
public class Farmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long farmerId;
	
	@Column(name = "farmer_name")
	private String farmerName;
	
	@Column(name = "paddy_purchase_id")
	private Long paddyPurchaseId;
	
    @Column(name = "address")
	private String address;
	
	@Column(name = "paddy_balance")
	private double paddyBalance;
	
	@Column(name = "mobile_number")
	private Long mobileNumber;
}
