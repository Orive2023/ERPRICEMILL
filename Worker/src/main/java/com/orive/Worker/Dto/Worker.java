package com.orive.Worker.Dto;

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
public class Worker {

    private Long workerId;
	
	private String workerName;
	
	private int workerAge;
	
	private Long workerMobileNumber;
	
	private String workerGender;
	
	private String address;
	
	private double workerSalery;

}
