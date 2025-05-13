package com.example.stock_price_notifier.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "watchlist_item")
@Builder
@Getter
public class WatchlistItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;

    private Double upperThreshold;

    private Double lowerThreshold;
}
