package com.example.stock_feed_consumer.incomingEvent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class WatchlistItemDTO {

    private Long id;

    private String symbol;

    private Double upperThreshold;

    private Double lowerThreshold;
}
