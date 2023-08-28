package com.orive.InventoryManufacturingJournal.Entity;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coproducts")
public class CoProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coproductId;
	
	@Column(name = "name_of_item")
	private String nameOfItem;
	
	@Column(name = "percentage_of_cost_allocation")
	private double percentageOfCostAllocation;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "amount")
	private double amount;
	
}
