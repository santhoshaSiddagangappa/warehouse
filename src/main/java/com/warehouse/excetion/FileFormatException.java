package com.warehouse.excetion;

public class FileFormatException extends RuntimeException{
    public FileFormatException(String msg) {
        super(msg);
    }
}
