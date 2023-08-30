package com.orive.Worker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Worker.Entity.WorkerDetails;

public interface WorkerRepository extends JpaRepository<WorkerDetails, Long>{

}
