package com.orive.Supplier.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "supplier")
public class SupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	
	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "web_url")
	private String webUrl;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "gstin")
	private double gstin;
	
	@Column(name = "mobile_no")
	private Long mobileNo;
	
	@Column(name = "pan_number")
	private String panNumber;
	
	@Column(name = "adhar_number")
	private double adharNumber;
	
	@Column(name = "street_address_1")
	private String streetAddress1;
	
	@Column(name = "street_address_2")
	private String streetAddress2;
	
	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private Long zipCode;
	
	@Column(name = "country")
	private String country;
	
    @Column(name = "type_of_address") 
	private String typeOfAddress;
	
    @Column(name = "account_holder_name")
	private String accountHolderName;
    
    @Column(name = "bank_name")
    private String bankName;
    
    @Column(name = "account_branch")
    private String accountBranch;
    
    @Column(name = "bank_account_number")
    private Double bankAccountNumber;
    
    @Column(name = "bank_account_type")
    private String bankAccountType;
    
    @Column(name = "swift_or_bic_code")
    private String swiftOrBicCode;
    
    @Column(name = "bank_routing_or_sort_code")
    private String bankRoutingOrSortCode;
    
    @Column(name = "ifsc_code")
    private String ifscCode;
    
    @Column(name = "micr_number")
    private String micrNumber;
    
    @Column(name = "currency")
    private String currency;
	
    @Column(name = "credit_limit")
    private double creditLimit;
    
    @Column(name = "tax_id")
    private String taxId;
    
    @Column(name = "terms_and_conditions")
    private boolean termsAndConditions;
    
    
    
    
	
    
    
    
    
    
    
    
    
    
    
    
}