package com.orive.ProductSummary.Dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Inventory {

    private Long productSummaryId;
	
	private Date productManufacturingDate;
	
	private Date productDeliveryDate;
	
	private Date productPurchaseDate;
	
	 private Long godownId;
		
     private String godownName;
		
     private List<GodownProduct> godownProducts; 
}
