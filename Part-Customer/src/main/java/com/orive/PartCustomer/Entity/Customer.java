package com.orive.PartCustomer.Entity;



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
@Table(name = "customer")
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "customer_id_sequence", strategy = GenerationType.SEQUENCE)
	private Long customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobile_number")
	private Long mobileNumber;

	
	
}
