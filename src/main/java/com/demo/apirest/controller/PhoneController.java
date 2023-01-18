package com.demo.apirest.controller;

import com.demo.apirest.model.Phone;
import com.demo.apirest.repository.PhonesRepository;
import com.demo.apirest.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class PhoneController {
    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService){
        this.phoneService = phoneService;
    }

    @PostMapping("/api/v1/Phone")
    private ResponseEntity<Phone> createPhone(@RequestBody Phone phone){
        Phone temp =  phoneService.createPhone(phone);

        try{
            return ResponseEntity.created(new URI("api/v1/user"+ temp.getId())).body(temp);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/api/v1/Phone")
    private ResponseEntity<List<Phone>> ListAllPhones(@RequestBody Phone phone){

        return  ResponseEntity.ok(phoneService.getAllPhone());
    }
    @DeleteMapping("/api/v1/Phone")
    private ResponseEntity<Void> DeletePhone(@RequestBody Phone phone){
        phoneService.deletePhone(phone);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/api/v1/Phone/{id}")
    private ResponseEntity<Void> PutPhone(@PathVariable Long id , @RequestBody Phone phone){
        phoneService.updatePhone(id, phone);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/api/v1/Phone/{id}")
    private ResponseEntity<Optional<Phone>> GetPhone(@PathVariable ("id") Long id){
        return ResponseEntity.ok(phoneService.findById(id));
    }
}
