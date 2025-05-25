package com.example.stock_feed_consumer.listener;


import com.example.stock_feed_consumer.incomingEvent.StockPriceUpdateDTO;
import com.example.stock_feed_consumer.service.StockPriceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class StockPriceListener {

    @Autowired private StockPriceService stockPriceService;
    @Autowired private ObjectMapper objectMapper;

    @KafkaListener(topics = "stock-price-feed", groupId = "stock-feed-consumer-group")
    public void processStockPriceUpdateEvent(StockPriceUpdateDTO event) {
        stockPriceService.processStockPriceUpdateListener(event);
    }
}
