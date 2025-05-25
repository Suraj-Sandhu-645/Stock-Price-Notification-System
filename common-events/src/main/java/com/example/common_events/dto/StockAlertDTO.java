package com.example.common_events.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Jacksonized
public class StockAlertDTO{

    private String symbol;
    private Double currentPrice;
    private Double thresholdPrice;
    private Instant timestamp;
    private String alertType;
    private String message;
}
