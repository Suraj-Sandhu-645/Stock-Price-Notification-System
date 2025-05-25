package com.example.stock_price_notifier.repository;

import com.example.stock_price_notifier.entity.WatchlistItemEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistItemRepository extends JpaRepository<WatchlistItemEntity, Long> {
  boolean deleteAllBySymbol(String symbol);

  List<WatchlistItemEntity> findAllBySymbol(String symbol);
}
