package com.example.stock_price_notifier.service;

import com.example.stock_price_notifier.dto.UserDTO;
import com.example.stock_price_notifier.dto.WatchlistItemDTO;
import com.example.stock_price_notifier.entity.UserEntity;
import com.example.stock_price_notifier.entity.WatchlistItemEntity;
import com.example.stock_price_notifier.exception.SymbolNotFoundException;
import com.example.stock_price_notifier.exception.UserIdNotFoundException;
import com.example.stock_price_notifier.objectMapper.ObjectMapperConfig;
import com.example.stock_price_notifier.repository.UserRepository;
import com.example.stock_price_notifier.repository.WatchlistItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private ObjectMapperConfig objectMapperConfig;
  @Autowired private UserRepository userRepository;
  @Autowired private WatchlistItemRepository watchlistItemRepository;

  public UserDTO registerUser(UserDTO userDTO) {
    UserEntity userEntity = objectMapperConfig.userDtoToUserEntity(userDTO);
    userEntity = userRepository.save(userEntity);

    return objectMapperConfig.userEntityToUserDto(userEntity);
  }

  public UserDTO userDeatilByUserId(Long userId) {
    Optional<UserEntity> userEntity = userRepository.findById(userId);

    if (userEntity.isPresent()) {
      return objectMapperConfig.userEntityToUserDto(userEntity.get());
    }
    throw new UserIdNotFoundException("User Id is not present in database");
  }

  public WatchlistItemDTO addStockToWatchlist(Long userId, WatchlistItemDTO watchlistItemDTO) {
    WatchlistItemEntity watchlistItemEntity =
        objectMapperConfig.watchlistItemDtoToWatchlistItemEntity(watchlistItemDTO);
    Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
    if (userEntityOptional.isPresent()) {
      List<WatchlistItemEntity> watchlistItemEntityList = new ArrayList<>();
      watchlistItemEntity.setUser(userEntityOptional.get());
      watchlistItemRepository.save(watchlistItemEntity);
      watchlistItemEntityList.add(watchlistItemEntity);

      userEntityOptional.get().setWatchlist(watchlistItemEntityList);

      return objectMapperConfig.watchlistItemEntityToWatchlistItemDTO(watchlistItemEntity);
    }
    throw new UserIdNotFoundException("User Id is not present in database");
  }

  public List<WatchlistItemDTO> getWatchlistByUserId(Long userId) {
    Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
    List<WatchlistItemDTO> watchlistItemDTOList = new ArrayList<>();

    if (userEntityOptional.isPresent()) {

      for (WatchlistItemEntity watchlistItemEntity : userEntityOptional.get().getWatchlist()) {
        WatchlistItemDTO watchlistItemDTO =
            objectMapperConfig.watchlistItemEntityToWatchlistItemDTO(watchlistItemEntity);
        watchlistItemDTOList.add(watchlistItemDTO);
      }
    }
    return watchlistItemDTOList;
  }

  public boolean removeStockFromWatchlist(Long userId, String symbol) {
    Optional<UserEntity> userEntityOptional = userRepository.findById(userId);

    if (userEntityOptional.isPresent()) {
      UserEntity userEntity = userEntityOptional.get();
      userEntity.getWatchlist().removeIf(a -> a.getSymbol().equalsIgnoreCase(symbol));
      userRepository.save(userEntity);
      return true;
    }
    return false;
  }

  public List<WatchlistItemDTO> updateStockDetaiilsFromWatchlistBySymbol(String symbol) {
    List<WatchlistItemEntity> watchlistItemEntityList =
        watchlistItemRepository.findAllBySymbol(symbol);
    if (!watchlistItemEntityList.isEmpty()) {
      List<WatchlistItemDTO> watchlistItemDTOList = new ArrayList<>();
      for (WatchlistItemEntity watchlistItemEntity : watchlistItemEntityList) {
        watchlistItemDTOList.add(
            objectMapperConfig.watchlistItemEntityToWatchlistItemDTO(watchlistItemEntity));
      }
      return watchlistItemDTOList;
    }
    throw new SymbolNotFoundException(
        "Symbol is not present in any stock which added in watchlist");
  }
}
