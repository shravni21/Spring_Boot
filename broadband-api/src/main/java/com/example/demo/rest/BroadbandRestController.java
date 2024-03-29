package com.example.demo.rest;

import com.example.demo.entity.Broadband;
import com.example.demo.service.BroadbandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BroadbandRestController {
    private BroadbandService broadbandService;

    // inject employee dao (use constructor injection)
    @Autowired
    public  BroadbandRestController (BroadbandService broadbandService){
        this.broadbandService=broadbandService;
    }
    // expose "/broadband" and return a list of broadbands
    @GetMapping("/broadband")
    public List<Broadband> getAllBroadbandConnections() {
        return broadbandService.getAllBroadbandConnections();
    }
    // Add mapping for post
    @PostMapping("/broadband")
    public Broadband saveBroadbandConnection(@RequestBody Broadband broadband) {
        return broadbandService.saveBroadbandConnection(broadband);
    }
    // Add mapping for get by id
    @GetMapping("broadband/{id}")
    public Broadband getBroadbandConnectionById(@PathVariable Integer id) {
        Broadband broadband = broadbandService.getBroadbandConnectionById(id);
        if (broadband == null) {
            throw new RuntimeException("Broadband connection id not found - " + id);
        }
        return broadband;
    }
    // Add mapping for update
    @PutMapping("/broadband/{id}")
    public Broadband updateBroadbandConnection(@PathVariable Integer id, @RequestBody Broadband updatedBroadband) {
        Broadband existingBroadband = broadbandService.getBroadbandConnectionById(id);
        if (existingBroadband == null) {
            throw new RuntimeException("Broadband connection id not found - " + id);
        }
        existingBroadband.setProviderName(updatedBroadband.getProviderName());
        existingBroadband.setPlan(updatedBroadband.getPlan());


        return broadbandService.saveBroadbandConnection(existingBroadband);
    }
    // Add mapping for DELETE
    @DeleteMapping("broadband/{id}")
    public String deleteBroadbandConnection(@PathVariable Integer id) {
        Broadband broadband = broadbandService.getBroadbandConnectionById(id);
        if (broadband == null) {
            throw new RuntimeException("Broadband connection id not found - " + id);
        }
        broadbandService.deleteBroadbandConnection(id);
        return "Deleted broadband connection id: " + id;
    }


}
