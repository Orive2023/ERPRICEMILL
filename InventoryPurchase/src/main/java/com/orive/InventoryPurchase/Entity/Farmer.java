package com.orive.InventoryPurchase.Entity;

import jakarta.persistence.Column;
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
public class Farmer {

     private Long farmerId;
	
	
	private String farmerName;
	
	
	private Long paddyPurchaseId;
	
    
	private String address;
	
	
	private double paddyBalance;
	
	
	private Long mobileNumber;
}
