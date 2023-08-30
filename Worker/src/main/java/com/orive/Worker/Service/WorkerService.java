package com.orive.Worker.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orive.Worker.Dto.Worker;
import com.orive.Worker.Entity.WorkerDetails;
import com.orive.Worker.Repository.WorkerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	 public Worker createWorker(Worker worker) {
	        WorkerDetails workerDetails = modelMapper.map(worker, WorkerDetails.class);
	        WorkerDetails details = workerRepository.save(workerDetails);
	        return modelMapper.map(details, Worker.class);
	    }
	
	 public List<Worker> getAllWorker() {
	        List<WorkerDetails> workerDetails = workerRepository.findAll();
	        return workerDetails.stream()
	                       .map(worker -> modelMapper.map(worker, Worker.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<Worker> getWorkerById(List<Long> workerId) {
	        List<WorkerDetails> workerDetails = workerRepository.findAllById(workerId);

	        return workerDetails.stream()
	                       .map(worker -> modelMapper.map(worker, Worker.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteWorker(Long workerId) {
	        WorkerDetails workerDetails = workerRepository.findById(workerId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("Worker not found"));

	        workerRepository.deleteById(workerId);
	    }	
	 public Worker updateWorker(Long workerId, Worker updatedWorkerDTO) {
	       WorkerDetails Details = workerRepository.findById(workerId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("Worker not found"));

	        modelMapper.map(updatedWorkerDTO, Details);

	        WorkerDetails updated = workerRepository.save(Details);
	        return modelMapper.map(updated, Worker.class);
	    }
}
