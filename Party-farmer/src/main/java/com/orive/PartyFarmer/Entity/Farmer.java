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
	@SequenceGenerator(name = "farmer_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "farmer_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long farmerId;
	
	@Column(name = "farmer_name")
	private String farmerName;
	
	
    @Column(name = "address")
	private String address;
	
	@Column(name = "paddy_balance")
	private double paddyBalance;
	
	@Column(name = "mobile_number")
	private Long mobileNumber;
}
