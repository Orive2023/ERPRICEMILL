package com.orive.Gowdown.Entity;

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
@Table(name = "godownproduct")
public class GodownProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rawMaterialId;
	
	@Column(name = "raw_material_name")
	private String rawMaterialName;
	
	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	@Column(name = "raw_material_quantity")
	private double rawMaterialQuantity;
}
