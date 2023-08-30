package com.orive.Transportation.Dto;

import java.util.Date;

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
public class Transportation {

    private Long transportationId;
	
	private String vechicleType;
	
	private String vechicleNumber;
	
	private String owrnerName;
	
	private String driverName;
	
	private String driverPanNumber;
	
	private String driverDrivingLincenseNumber;
	
	private String vechicleRcNumber;
	
	private Long vechicleCapacity;
	
	private double vechicleNetQuantityLoaded;
	
	private String fuel;
	
	private Double vechicleRun;
	
	private Double rateOfFuelPerKilometer;
	
	private Double fuelTotalRate;
	
	private Date arrivalDate;
	
	private Date reachedDate;
}
