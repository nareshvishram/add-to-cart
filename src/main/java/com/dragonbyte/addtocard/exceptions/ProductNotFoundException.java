package com.dragonbyte.addtocard.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String noProductFound) {
        super(noProductFound);
    }
}
