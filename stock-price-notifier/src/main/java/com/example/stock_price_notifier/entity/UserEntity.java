package com.example.stock_price_notifier.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_entity")
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WatchlistItemEntity> watchlist;
}

//@RequiredArgsConstructor
//✅ What it does:
//Generates a constructor for all final fields and fields annotated with @NonNull.

//@AllArgsConstructor
//✅ What it does:
//Generates a constructor with all fields (regardless of final, static, or nullable status).

//@NoArgsConstructor
//✅ What it does:
//Generates a constructor with no arguments (i.e., a default constructor).