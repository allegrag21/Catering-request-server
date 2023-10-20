package com.allegra.cateringrequestserver.domain.cateringRequest.controllers;

import com.allegra.cateringrequestserver.domain.cateringRequest.models.Client;
import com.allegra.cateringrequestserver.domain.cateringRequest.services.CateringRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/CateringRequest")
@CrossOrigin("*")

public class CateringRequestController {
    private CateringRequestService cateringRequestService;

    @Autowired
    public CateringRequestController(CateringRequestService cateringRequestService) {
        this.cateringRequestService = cateringRequestService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = cateringRequestService.getAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        client = cateringRequestService.create(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") Long id) {
        Client maintenanceRequest = cateringRequestService.getById(id);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody Client clientDetail) {
        clientDetail = cateringRequestService.update(id, clientDetail);
        return new ResponseEntity<>(clientDetail, HttpStatus.ACCEPTED);
    }

    @GetMapping("lookup")
    public ResponseEntity<Client> getByEmail(@RequestParam String email){
        Client client = cateringRequestService.getByEmail(email);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        cateringRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

