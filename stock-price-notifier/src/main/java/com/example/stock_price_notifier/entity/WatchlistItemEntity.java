package com.example.stock_price_notifier.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "watchlist_item")
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class WatchlistItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;

    private Double upperThreshold;

    private Double lowerThreshold;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
