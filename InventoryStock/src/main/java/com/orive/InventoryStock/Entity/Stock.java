package com.orive.InventoryStock.Entity;

import java.time.LocalDateTime;
import java.util.Date;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@SequenceGenerator(name = "stock_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "stock_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long stockId;
	
	@Column(name = "sl_number")
	private Long slNumber;
	
	@Column(name = "name_of_product")
	private String nameOfProduct;
	
	@Column(name = "current_stock")
	private double currentStock;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "name_of_party")
	private String nameOfParty;
	
	@Column(name = "in")
	private Date in;
	
	@Column(name = "out")
	private Date out;
}
