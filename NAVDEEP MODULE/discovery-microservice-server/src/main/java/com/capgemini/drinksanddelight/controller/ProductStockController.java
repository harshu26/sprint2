package com.capgemini.drinksanddelight.controller;

import com.capgemini.drinksanddelight.dto.CreateProductRequest;
import com.capgemini.drinksanddelight.dto.ProductStockDetails;
import com.capgemini.drinksanddelight.entities.ProductStockEntity;
import com.capgemini.drinksanddelight.service.ProductOrderService;
import com.capgemini.drinksanddelight.service.ProductService;
import com.capgemini.drinksanddelight.util.ProductStockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductStockController {

    @Autowired
    private ProductService productService;

    private ProductOrderService productOrderService;

    @GetMapping
    public ResponseEntity<List<ProductStockEntity>> getProductStockList() {
        List<ProductStockEntity> list = productService.fetchAllStocks();
        return new ResponseEntity<List<ProductStockEntity>>(list, HttpStatus.OK);
    }


    @GetMapping("/{id}/name")
    public ResponseEntity<String> getProductName(@PathVariable String id) {
        String stockName = productService.getProductName(id);
        return new ResponseEntity<String>(stockName, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductStockDetails> addStock(@RequestBody CreateProductRequest requestData) {
        ProductStockEntity entity = ProductStockUtil.toEntity(requestData);
        entity = productService.save(entity);
        ProductStockDetails details = ProductStockUtil.toDetails(entity);
        ResponseEntity<ProductStockDetails> response = new ResponseEntity<>(details, HttpStatus.OK);
        return response;
    }


}