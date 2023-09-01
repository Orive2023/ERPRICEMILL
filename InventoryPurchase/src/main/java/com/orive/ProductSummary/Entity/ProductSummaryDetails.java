package com.orive.ProductSummary.Entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "productSummary")
public class ProductSummaryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productSummaryId;
	
	@OneToMany
	private List<GowdownDetails> gowdownDetails;
	
}
