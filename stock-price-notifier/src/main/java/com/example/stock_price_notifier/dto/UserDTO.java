package com.example.stock_price_notifier.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

  private Long id;

  private String name;

  private String email;

  //    private List<WatchlistItemDTO> watchlist;

}
