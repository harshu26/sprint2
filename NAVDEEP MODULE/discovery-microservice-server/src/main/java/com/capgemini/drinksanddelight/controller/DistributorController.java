package com.capgemini.drinksanddelight.controller;

import com.capgemini.drinksanddelight.dto.CreateDistributorRequest;
import com.capgemini.drinksanddelight.entities.DistributorEntity;
import com.capgemini.drinksanddelight.service.ProductService;
import com.capgemini.drinksanddelight.util.DistributorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributors")
public class DistributorController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<DistributorEntity> getDistributors() {
        List<DistributorEntity> list = productService.fetchAllDistributors();
        System.out.println("hi");
        return list;
    }


    @PostMapping("/add")
    public ResponseEntity<DistributorEntity> addDistributor(@RequestBody CreateDistributorRequest requestData) {
        DistributorEntity distributordetails = DistributorUtil.convertToDistributor(requestData);
        distributordetails = productService.saveDistributor(distributordetails);
        ResponseEntity<DistributorEntity> response = new ResponseEntity<>(distributordetails, HttpStatus.OK);
        return response;

    }


}
