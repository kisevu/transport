package com.ameda.kevin.cabbookdriver.controller;

import com.ameda.kevin.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping("/update")
    public ResponseEntity<?> updatedLocation() throws InterruptedException {
        int range = 100;
        while(range > 0){
            cabLocationService.updateLocation(Math.random()+", "+Math.random());
            Thread.sleep(1000);
            range --;
        }
        return new ResponseEntity<>(Map.of("message","Location updated"), HttpStatus.OK);
    }
}
