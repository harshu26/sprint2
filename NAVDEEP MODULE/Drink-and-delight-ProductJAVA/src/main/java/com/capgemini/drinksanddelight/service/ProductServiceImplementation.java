package com.capgemini.drinksanddelight.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.capgemini.drinksanddelight.dao.DistributorDetailsDao;
import com.capgemini.drinksanddelight.entities.DistributorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.drinksanddelight.dao.ProductStockDao;
import com.capgemini.drinksanddelight.entities.ProductStockEntity;


@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductStockDao stockDao;

    @Autowired
    private DistributorDetailsDao distributorDao;

    @Override
    public ProductStockEntity save(ProductStockEntity productstockdetails) {
        productstockdetails = stockDao.save(productstockdetails);
        return productstockdetails;
    }


    @Override
    public List<ProductStockEntity> fetchAllStocks() {
        List<ProductStockEntity> stocks = stockDao.findAll();
        return stocks;
    }



    @Override
    public String getProductName(String id) {
        String name = " ";
        Optional<ProductStockEntity> optional = stockDao.findById(id);
        if (optional.isPresent()) {
            ProductStockEntity details = optional.get();
            name = details.getName();
        }
        return name;
    }


    @Override
    public List<DistributorEntity> fetchAllDistributors() {
        List<DistributorEntity> distributorentity = distributorDao.findAll();
        return distributorentity;

    }

    @Override
    public DistributorEntity saveDistributor(DistributorEntity entity) {
        entity = distributorDao.save(entity);
        return entity;
    }

}
