package com.example.stock_price_notifier.objectMapper;

import com.example.stock_price_notifier.dto.UserDTO;
import com.example.stock_price_notifier.dto.WatchlistItemDTO;
import com.example.stock_price_notifier.entity.UserEntity;
import com.example.stock_price_notifier.entity.WatchlistItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperConfig {

    public UserEntity userDtoToUserEntity(UserDTO userDTO){
        return UserEntity.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .build();
    }

    public UserDTO userEntityToUserDto(UserEntity userEntity){
        return UserDTO.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .build();
    }

    public WatchlistItemDTO watchlistItemDtoToWatchlistItemEntity(WatchlistItemEntity watchlistItemEntity){
        return WatchlistItemDTO.builder()
                .id(watchlistItemEntity.getId())
                .symbol(watchlistItemEntity.getSymbol())
                .lowerThreshold(watchlistItemEntity.getLowerThreshold())
                .upperThreshold(watchlistItemEntity.getUpperThreshold())
                .build();
    }

    public WatchlistItemEntity watchlistItemEntityToWatchlistItemDTO(WatchlistItemDTO watchlistItemDTO){
        return WatchlistItemEntity.builder()
                .symbol(watchlistItemDTO.getSymbol())
                .lowerThreshold(watchlistItemDTO.getLowerThreshold())
                .upperThreshold(watchlistItemDTO.getUpperThreshold())
                .build();
    }
}
