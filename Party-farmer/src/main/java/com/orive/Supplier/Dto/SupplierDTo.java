package com.orive.Supplier.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTo {
	
	private Long supplierId;
	private String businessName;
	private String bussinessOwnerName;
	private String emailAddress;
	private String gender;
	private String webUrl;
	private String fax;
	private double gstin;
	private Long mobileNo;
	private String panNumber;
	private double adharNumber;
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String state;
	private Long zipCode;
	private String country;
	private String typeOfAddress;
	private String accountHolderName;
    private String bankName;
    private String accountBranch;
    private Double bankAccountName;
    private String bankAccountType;
    private String swiftOrBicCode;
    private String bankRoutingOrSortCode;
    private String ifscCode;
    private String micrNumber;
    private String currency;
    private double creditLimit;
    private String taxId;
    private boolean termsAndConditions;
}
