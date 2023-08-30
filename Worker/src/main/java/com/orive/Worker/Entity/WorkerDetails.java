package com.orive.Worker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "worker")
public class WorkerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workerId;
	
	@Column(name = "worker_name")
	private String workerName;
	
	@Column(name = "worker_age")
	private int workerAge;
	
	@Column(name = "worker_mobile_number")
	private Long workerMobileNumber;
	
	@Column(name = "worker_gender")
	private String workerGender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "worker_salery")
	private double workerSalery;
	
	
}
