package com.orive.Worker.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Worker.Dto.Worker;
import com.orive.Worker.Service.WorkerService;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
	
	private Logger logger=LoggerFactory.getLogger(WorkerController.class);

	@Autowired
	private WorkerService workerService;
	
	  @PostMapping(value = "/save")
	    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
	        Worker created = workerService.createWorker(worker);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<Worker>> getAllWorker() {
	        List<Worker> workers = workerService.getAllWorker();
	        return new ResponseEntity<>(workers, HttpStatus.OK);
	    }

	    @GetMapping("/get/{workerId}")
	    public ResponseEntity<List<Worker>> getWorkerByIds(@PathVariable List<Long> workerId) {
	        List<Worker> workers = workerService.getWorkerById(workerId);
	        return new ResponseEntity<>(workers, HttpStatus.OK);
	    }

	    @PutMapping("/update/{workerId}")
	    public ResponseEntity<Worker> updateWorker(
	            @PathVariable Long workerId, @RequestBody Worker updatedWorkerDTO) {
	        Worker updated = workerService.updateWorker(workerId, updatedWorkerDTO);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{workerId}")
	    public ResponseEntity<Void> deleteWorker(@PathVariable Long workerId) {
	        workerService.deleteWorker(workerId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
