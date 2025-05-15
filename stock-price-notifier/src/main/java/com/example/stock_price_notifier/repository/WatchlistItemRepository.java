package com.example.stock_price_notifier.repository;

import com.example.stock_price_notifier.entity.WatchlistItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistItemRepository extends JpaRepository<WatchlistItemEntity, Long> {
    boolean deleteAllBySymbol(String symbol);
}
