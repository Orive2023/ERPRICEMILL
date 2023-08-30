package com.orive.Gowdown.Dto;

import java.util.List;

import com.orive.Gowdown.Entity.GodownProductDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Gowdown {

    private Long godownId;
	
	private String godownName;
	
	@OneToMany(targetEntity = GodownProduct.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "godown_product_fk",referencedColumnName = "godownId")
	private List<GodownProductDetails> godownProductsDetails; 
}
