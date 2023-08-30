package com.orive.Mandi.Dto;


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
public class Mandi {
	
	private Long mandiId;
	
	private String mandiName;
	
    private String mandiOwnerName;
	
	private String dist;
	
	private String country;
	
	private String state;
	
	private Long pinCode;
	
	private Long mobileNumber;
}
