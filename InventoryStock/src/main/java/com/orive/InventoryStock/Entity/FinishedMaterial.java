package com.orive.InventoryStock.Entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "finishedmaterial")
public class FinishedMaterial {

	@Id
	@SequenceGenerator(name = "finishedmaterial_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "finishedmaterial_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long finishedMaterialId;
	
	@Column(name = "material_name")
	private String materialName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "quantity_unit")
	private String quantityUnit;
	
	@Column(name = "ware_house")
	private String wareHouse;
}
