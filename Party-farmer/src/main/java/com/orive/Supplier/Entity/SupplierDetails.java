package com.orive.Supplier.Entity;

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
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "supplier")
public class SupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	@Column(name = "supplier_organisation_name")
    private String supplierOrganisationName;
	
	@Column(name = "dist")
	private String dist;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pin_code")
	private Long pinCode;
	
	
	@Column(name = "mobile_number")
	private Long mobileNumber;
}
