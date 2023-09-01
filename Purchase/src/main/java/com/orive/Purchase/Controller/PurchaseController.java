package com.orive.Purchase.Controller;

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
import com.orive.Purchase.Dto.PurchaseDto;
import com.orive.Purchase.Service.PurchaseService;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {

	private Logger logger=LoggerFactory.getLogger(PurchaseController.class);
	
	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping(value = "/save")
    public ResponseEntity<PurchaseDto> createGowdown(@RequestBody PurchaseDto gowdown) {
        PurchaseDto created = purchaseService.createPurchase(gowdown);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<PurchaseDto>> getAllGowdown() {
        List<PurchaseDto> gowdowns = purchaseService.getAllGowdown();
        return new ResponseEntity<>(gowdowns, HttpStatus.OK);
    }

    @GetMapping("/get/{purchaseId}")
    public ResponseEntity<List<PurchaseDto>> getGowdownByIds(@PathVariable List<Long> purchaseId) {
        List<PurchaseDto> gowdowns = purchaseService.getGodownById(purchaseId);
        return new ResponseEntity<>(gowdowns, HttpStatus.OK);
    }

    @PutMapping("/update/{purchaseId}")
    public ResponseEntity<PurchaseDto> updateGowdown(
            @PathVariable Long purchaseId, @RequestBody PurchaseDto updatedDTO) {
        PurchaseDto updated = purchaseService.updateGowdown(purchaseId, updatedDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{purchaseId}")
    public ResponseEntity<Void> deleteGowdown(@PathVariable Long purchaseId) {
        purchaseService.deleteGodown(purchaseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
