package com.example.stock_feed_consumer.incomingEvent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class StockPriceUpdateDTO  {
    private String symbol;
    private Double price;
    private Long timestamp;
}


//Explanation of Removed Annotations
//@Jacksonized (Lombok + Jackson integration)
//
//Needed if you're using Lombok’s @Builder with Jackson deserialization.
//
//You're not using @Builder, so @Jacksonized is unnecessary.
//
//        implements Serializable
//
//Only needed if you plan to serialize the object to a byte stream (e.g., caching, RMI, etc.).
//
//Not required for Jackson-based JSON (de)serialization or typical Kafka usage.
//
