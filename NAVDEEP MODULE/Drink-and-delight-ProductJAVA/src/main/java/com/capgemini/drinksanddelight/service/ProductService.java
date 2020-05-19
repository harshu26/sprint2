package com.capgemini.drinksanddelight.service;

import java.util.List;

import com.capgemini.drinksanddelight.entities.DistributorEntity;
import com.capgemini.drinksanddelight.entities.ProductStockEntity;

public interface ProductService {
	
	
	ProductStockEntity save(ProductStockEntity productstockdetails);

    List<ProductStockEntity> fetchAllStocks();

	String getProductName(String id);

	List<DistributorEntity> fetchAllDistributors();

	DistributorEntity saveDistributor(DistributorEntity entity);

}

