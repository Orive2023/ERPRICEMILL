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
@Table(name = "supplierdetails")
public class SupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private Long zipCode;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "phone")
	private Long phone;
	
	@Column(name = "mobile_no")
	private Long mobileNo;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "vat_no")
	private String vatNo;
	
	@Column(name = "city")
	private String city;
}
