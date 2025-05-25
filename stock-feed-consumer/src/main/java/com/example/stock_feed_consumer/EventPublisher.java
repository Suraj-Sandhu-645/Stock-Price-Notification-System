package com.example.stock_feed_consumer;


import com.example.common_events.dto.StockAlertDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final KafkaTemplate<String, StockAlertDTO> kafkaTemplate;

    public EventPublisher(KafkaTemplate<String, StockAlertDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAlert(StockAlertDTO alert) {
        kafkaTemplate.send("stock-alert", alert.getSymbol(), alert);
    }
}
