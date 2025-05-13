package com.example.stock_price_notifier.dto;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private List<WatchlistItemDTO> watchlist;

}

