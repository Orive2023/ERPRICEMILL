package com.orive.ProductSummary.Dto;

import java.util.Date;

import jakarta.persistence.Column;
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
public class GodownProduct {

    private Long rawMaterialId;
		
	private String rawMaterialName;

	private Date purchaseDate;
	
	private double rawMaterialQuantity;
}
