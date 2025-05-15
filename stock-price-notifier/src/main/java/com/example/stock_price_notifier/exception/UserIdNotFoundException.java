package com.example.stock_price_notifier.exception;

public class UserIdNotFoundException extends RuntimeException{

    public UserIdNotFoundException(String msg){
        super(msg);
    }
}
