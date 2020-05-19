package com.capgemini.drinksanddelight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.capgemini.drinksanddelight.dao.DistributorDetailsDao;
import com.capgemini.drinksanddelight.entities.DistributorEntity;
import com.capgemini.drinksanddelight.exception.ProductOrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.drinksanddelight.dao.ProductOrderDao;
import com.capgemini.drinksanddelight.entities.ProductOrderEntity;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private ProductOrderDao productOrderDao;
    @Autowired
    private DistributorDetailsDao distributorDao;

    @Override
    public ProductOrderEntity save(ProductOrderEntity productorderentity) {
        productorderentity = productOrderDao.save(productorderentity);
        return productorderentity;
    }

    @Override
    public ProductOrderEntity placeProductOrder(String orderId, String name, String supplierid, double quantityValue,
                                                double quantityUnit, double pricePerUnit, LocalDate expectedDeliveryDate, double totalPrice) {
        ProductOrderEntity productOrderEntity = new ProductOrderEntity();
        productOrderEntity.setOrderId(orderId);
        productOrderEntity.setName(name);
        productOrderEntity.setSupplierId(supplierid);
        productOrderEntity.setQuantityUnit(quantityUnit);
        productOrderEntity.setPricePerUnit(pricePerUnit);
        productOrderEntity.setQuantityValue(quantityValue);
        productOrderEntity.setExpectedDeliveryDate(expectedDeliveryDate);
        productOrderEntity.setTotalPrice(totalPrice);
        save(productOrderEntity);
        return productOrderEntity;

    }

    public ProductOrderEntity updateTrackOrder(String orderId, String location, LocalDate date) {
        ProductOrderEntity productorderentity = trackOrder(orderId);
        //productorderentity.setOrderId(orderId);
        productorderentity.setLocation(location);
        productorderentity.setExpectedDeliveryDate(date);
        save(productorderentity);
        return productorderentity;
    }

    @Override
    public List<ProductOrderEntity> fetchAll() {
        List<ProductOrderEntity> productorderentity = productOrderDao.findAll();
        return productorderentity;
    }

    @Override
    public ProductOrderEntity trackOrder(String orderId) {
        Optional<ProductOrderEntity> optional = productOrderDao.findById(orderId);
        if (optional.isPresent()) {
            ProductOrderEntity order = optional.get();
            return order;
        }
        throw new ProductOrderNotFoundException("product order not found for id=" + orderId);
    }


}
