package com.orive.Transportation.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "transportation")
public class TransportationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transportationId;
	
	@Column(name = "vechicle_type")
	private String vechicleType;
	
	@Column(name = "vechicle_number")
	private String vechicleNumber;
	
	@Column(name = "owrner_name")
	private String owrnerName;
	
	@Column(name = "driver_name")
	private String driverName;
	
	@Column(name = "driver_pan_number")
	private String driverPanNumber;
	
	@Column(name = "driver_driving_lincense_number")
	private String driverDrivingLincenseNumber;
	
	@Column(name = "vechicle_rc_number")
	private String vechicleRcNumber;
	
	@Column(name = "vechicle_capacity")
	private Long vechicleCapacity;
	
	@Column(name = "vechicle_net_quantity_loaded")
	private double vechicleNetQuantityLoaded;
	
	@Column(name = "vechicle_fuel")
	private String vechicleFuel;
	
	@Column(name = "vechicle_run")
	private Double vechicleRun;
	
	@Column(name = "rate_of_fuel_per_kilometer")
	private Double rateOfFuelPerKilometer;
	
	@Column(name = "fuel_total_rate")
	private Double fuelTotalRate;
	
	@Column(name = "arrival_date")
	private Date arrivalDate;
	
	@Column(name = "reached_date")
	private Date reachedDate;
	
}
