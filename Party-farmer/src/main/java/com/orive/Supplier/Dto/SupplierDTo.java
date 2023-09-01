package com.orive.Supplier.Dto;


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
public class SupplierDTo {
	
	private Long supplierId;
	
	private String supplierName;
	
	private String address;
	
	private String country;
	
	private String state;
	
	private Long zipCode;
	
	private String emailAddress;
	
	private Long phone;
	
	private Long mobileNo;
	
	private String fax;
	
	private String vatNo;
	
	private String city;
}
