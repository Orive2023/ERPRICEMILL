package com.orive.Supplier.Dto;


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
public class Supplier {
	
	private Long supplierId;
	
	private String supplierName;
	
    private String supplierOrganisationName;
	
	private String dist;
	
	private String country;
	
	private String state;
	
	private Long pinCode;
	
	private Long mobileNumber;
}
