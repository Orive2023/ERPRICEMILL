package com.orive.InventoryPurchase.Entity;




import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "godowndetails")
public class GodownDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "godown_details_id")
	private Long godownDetailsId;
	
	
	@Column(name = "worker_name")
	private String workerName;
	
	@Column(name = "paddy_in_pkts")
	private double paddyInPkts;
	
	@Column(name = "go_down_name")
	private String godownName;
	
	
	
}
