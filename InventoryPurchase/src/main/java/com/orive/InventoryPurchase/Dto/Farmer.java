package com.orive.InventoryPurchase.Dto;

import java.io.Serializable;

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
public class Farmer implements Serializable{
	private Long farmerId;
	private String farmerName;
	private String address;
	private double paddyBalance;
	private Long mobileNumber;
}
