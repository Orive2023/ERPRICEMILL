package com.orive.Mandi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Mandi.Mandi;
import com.orive.Mandi.Entity.MandiDetails;

public interface MandiRepositoy extends JpaRepository<MandiDetails, Long>{

}
