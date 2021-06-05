package com.warehouse.excetion;

public class ProductSoldOutException extends RuntimeException {

    public ProductSoldOutException(String msg) {
        super(msg);
    }
}
