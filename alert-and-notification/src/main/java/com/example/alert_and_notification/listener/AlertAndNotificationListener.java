package com.example.alert_and_notification.listener;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AlertAndNotificationListener {

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = "stock-alert", groupId = "stock-alert-group")
    public void processStockAlertEvent(com.example.common_events.dto.StockAlertDTO stockAlertDTO) {
        System.out.println("This event is recevied " + stockAlertDTO);
    }
}
