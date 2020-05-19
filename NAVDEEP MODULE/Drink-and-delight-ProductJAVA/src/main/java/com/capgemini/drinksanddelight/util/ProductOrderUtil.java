package com.capgemini.drinksanddelight.util;

import com.capgemini.drinksanddelight.dto.CreateProductOrderRequest;
import com.capgemini.drinksanddelight.dto.ProductOrderDetails;
import com.capgemini.drinksanddelight.entities.ProductOrderEntity;
import com.capgemini.drinksanddelight.service.ProductOrderService;

import java.time.LocalDate;

public class ProductOrderUtil {


    public static ProductOrderEntity toOrderEntity(CreateProductOrderRequest requestData) {
        ProductOrderEntity order = new ProductOrderEntity();
        order.setOrderId(requestData.getOrderId());
        order.setName(requestData.getName());
        order.setPricePerUnit(requestData.getPricePerUnit());
        order.setQuantityUnit(requestData.getQuantityUnit());
        order.setQuantityValue(requestData.getQuantityValue());
        order.setSupplierId(requestData.getSupplierId());
        LocalDate deliveryDate=DateUtil.toLocalDate(requestData.getExpectedDeliveryDate());
        order.setExpectedDeliveryDate(deliveryDate);
        order.setLocation(requestData.getLocation());
        order.setTotalPrice(requestData.getTotalPrice());
        return order;
    }

    public static ProductOrderDetails toOrderDetails(ProductOrderEntity entity){
        ProductOrderDetails details=new ProductOrderDetails();
        details.setOrderId(entity.getOrderId());
        LocalDate expectedDeliveryDate=entity.getExpectedDeliveryDate();
        String expectedDeliveryDateText=DateUtil.toString(expectedDeliveryDate);
        details.setExpectedDeliveryDate(expectedDeliveryDateText);
        details.setPricePerUnit(entity.getPricePerUnit());
        details.setName(entity.getName());
        details.setSupplierId(entity.getSupplierId());
        details.setTotalPrice(entity.getTotalPrice());
        details.setQuantityUnit(entity.getQuantityUnit());
        details.setQuantityValue(entity.getQuantityValue());
        return details;
    }


}
