package com.example.stock_price_notifier.entity;

import com.example.stock_price_notifier.dto.WatchlistItemDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "user_entity")
@Builder
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

//    private List<WatchlistItemEntity> watchlist;
}
