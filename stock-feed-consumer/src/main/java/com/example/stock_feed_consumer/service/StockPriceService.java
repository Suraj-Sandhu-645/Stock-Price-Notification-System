package com.example.stock_feed_consumer.service;

import com.example.common_events.dto.StockAlertDTO;
import com.example.stock_feed_consumer.EventPublisher;
import com.example.stock_feed_consumer.incomingEvent.StockPriceUpdateDTO;
import com.example.stock_feed_consumer.incomingEvent.WatchlistItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StockPriceService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    EventPublisher applicationEventPublisher;

    public void processStockPriceUpdateListener(StockPriceUpdateDTO stockPriceUpdateDTO){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StockPriceUpdateDTO> requestEntity = new HttpEntity<>(stockPriceUpdateDTO, headers);

        ResponseEntity<List<WatchlistItemDTO>> responseEntity =
        this.restTemplate.exchange("http://localhost:8080/users/watchlist/" + stockPriceUpdateDTO.getSymbol(),
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<WatchlistItemDTO>>() {});

        List<WatchlistItemDTO> watchlistItemDTOList = responseEntity.getBody();
        for(WatchlistItemDTO watchlistItemDTO : watchlistItemDTOList) {
            if(watchlistItemDTO.getLowerThreshold() < stockPriceUpdateDTO.getPrice()) {
                StockAlertDTO stockAlertDTO = StockAlertDTO.builder()
                        .currentPrice(stockPriceUpdateDTO.getPrice())
                        .thresholdPrice(watchlistItemDTO.getLowerThreshold())
                        .alertType("Price Threshold Alert")
                        .message("Triggered when a stock crosses a user-defined price")
                        .build();
                applicationEventPublisher.sendAlert(stockAlertDTO);
                System.out.println("Need to send Alert & Notification " + stockPriceUpdateDTO.getPrice());
            }
        }
    }
}
