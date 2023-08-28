package com.orive.PartyFarmer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.orive.PartyFarmer.Entity.Farmer;


public interface FarmerRepository extends JpaRepository<Farmer, Long>{

}
