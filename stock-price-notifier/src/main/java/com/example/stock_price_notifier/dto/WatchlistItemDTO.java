package com.example.stock_price_notifier.dto;

import lombok.*;

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

