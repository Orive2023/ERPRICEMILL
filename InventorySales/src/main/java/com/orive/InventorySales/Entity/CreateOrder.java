package com.orive.InventorySales.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "createorder")
public class CreateOrder {

	@Id
	@SequenceGenerator(name = "farmer_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "farmer_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long createOrderId;
	
	@Column(name = "products")
	private String products;

	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "manufactoring_date")
	private Date manufactoringDate;
	
	@Column(name = "quality_check")
	private String qualityCheck;
	
	@Column(name = "distributor")
	private String distributor;
	
	@Column(name = "estimate_delivery_date")
	private Date estimatedDeliveryDate;
	
	@Column(name = "expairy_date")
	private Date expairyDate;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "price_per_unit")
	private double pricePerUnit;
	
	@Column(name = "unit")
	private String unit;
}
