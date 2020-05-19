package com.capgemini.drinksanddelight.controller;

import com.capgemini.drinksanddelight.dto.ProductOrderDetails;
import com.capgemini.drinksanddelight.util.ProductOrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.drinksanddelight.dto.CreateProductOrderRequest;
import com.capgemini.drinksanddelight.entities.ProductOrderEntity;
import com.capgemini.drinksanddelight.service.ProductOrderService;
import com.capgemini.drinksanddelight.service.ProductService;

/*
@author NAVDEEP TRIPATHI
*/
@RestController
@RequestMapping("/products/orders")
public class ProductOrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping("/add")
    public ResponseEntity<ProductOrderDetails> addProduct(@RequestBody CreateProductOrderRequest requestData) {
        ProductOrderEntity order = ProductOrderUtil.toOrderEntity(requestData);
        order = productOrderService.save(order);
        ProductOrderDetails details=ProductOrderUtil.toOrderDetails(order);
        ResponseEntity<ProductOrderDetails> response = new ResponseEntity<>(details, HttpStatus.OK);
        return response;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ProductOrderDetails> trackOrder(@PathVariable("id") String id)  {
        ProductOrderEntity order = productOrderService.trackOrder(id);
        ProductOrderDetails details=ProductOrderUtil.toOrderDetails(order);
        return new ResponseEntity<ProductOrderDetails>(details, HttpStatus.OK);
    }


}
