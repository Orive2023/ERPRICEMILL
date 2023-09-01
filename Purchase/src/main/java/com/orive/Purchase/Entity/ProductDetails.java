package com.orive.Purchase.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "productdetails")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "stock_or_quantity")
	private double stockOrQuantity;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	@Column(name = "batch_number")
	private String batchNumber;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "discount_in_percentage")
	private double discountInPercentage;
	
	@Column(name = "discount_value")
	private double discountValue;
	
	@Column(name = "vat_in_percentage")
	private double vatInPercentage;
	
	@Column(name = "vat_value")
	private double vatValue;
	
	@Column(name = "total")
	private double total;
	
	@ManyToOne
	private PurchaseDetails purchaseDetails;
	
	
	
}
