package com.example.stock_price_notifier.exception;

public class SymbolNotFoundException extends RuntimeException {

  public SymbolNotFoundException(String msg) {
    super(msg);
  }
}
