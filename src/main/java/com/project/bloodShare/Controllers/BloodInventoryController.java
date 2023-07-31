package com.project.bloodShare.Controllers;

import com.project.bloodShare.Exceptions.ResourceNotFoundException;
import com.project.bloodShare.Payload.response.MessageResponse;
import com.project.bloodShare.Repostories.BloodBankRepository;
import com.project.bloodShare.Repostories.BloodInventoryRepository;
import com.project.bloodShare.model.BloodBank;
import com.project.bloodShare.model.BloodInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/test")
public class BloodInventoryController {
    @Autowired
    BloodInventoryRepository bloodInventoryRepository;

    @Autowired
    BloodBankRepository bloodBankRepository;

    @PostMapping("bloodBank/{id}/bloodInventory")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<?> createBloodInventory(@PathVariable(value = "id") Long bloodBankId,
                                                     @RequestBody BloodInventory bloodInventoryRequest) {
        return bloodBankRepository.findById(bloodBankId).map(bloodBank -> {
            bloodBank.getBloodInventories().add(bloodInventoryRequest);
            bloodInventoryRepository.save(bloodInventoryRequest);
            return ResponseEntity.ok(new MessageResponse("BloodInventory registered successfully!"));
        }).orElseThrow(() -> new ResourceNotFoundException("Not found BloodBank with id = " + bloodBankId));
    }


    @GetMapping("bloodBank/{id}/bloodInventories")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<List<BloodInventory>> getBloodInventories(@PathVariable(value = "id") Long bloodBankid) {
        Optional<BloodBank> optionalBloodBank = bloodBankRepository.findById(bloodBankid);

        if (optionalBloodBank.isEmpty()) {
            throw new ResourceNotFoundException("Not found BloodBank with id = " + bloodBankid);
        }

        BloodBank bloodBank = optionalBloodBank.get();
        Set<BloodInventory> bloodInventories = bloodBank.getBloodInventories();

        if(bloodInventories.isEmpty()){
            throw new ResourceNotFoundException("No BloodInventories Found");
        }

        else {
            return ResponseEntity.ok(new ArrayList<>(bloodInventories));
        }
    }
    @PutMapping("/bloodInventory/{id}")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<BloodInventory> updateBloodInventory(@PathVariable("id") Long id, @RequestBody BloodInventory bloodInventoryRequest) {
        BloodInventory bloodInventory = bloodInventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BloodInventoryId " + id + "not found"));
        bloodInventory.setBloodType(bloodInventoryRequest.getBloodType());
        bloodInventory.setBloodRhFactor(bloodInventoryRequest.getBloodRhFactor());
        bloodInventory.setQuantity(bloodInventoryRequest.getQuantity());

        return new ResponseEntity<>(bloodInventoryRepository.save(bloodInventory), HttpStatus.OK);
    }

    @DeleteMapping("/bloodInventory/{id}")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<Object> deleteBloodInventory(@PathVariable Long id) {

        return bloodInventoryRepository.findById(id).map(bloodInventory -> {
            bloodInventoryRepository.delete(bloodInventory);
            return ResponseEntity.ok().build();

        }).orElseThrow(() ->new ResourceNotFoundException("BloodInventory id" + id + "not found"));
    }

}
