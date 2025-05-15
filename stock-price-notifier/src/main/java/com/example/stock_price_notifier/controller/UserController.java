package com.example.stock_price_notifier.controller;

import com.example.stock_price_notifier.dto.UserDTO;
import com.example.stock_price_notifier.dto.WatchlistItemDTO;
import com.example.stock_price_notifier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired private UserService userService;

    @PostMapping("register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Validated UserDTO userDTO){
        userDTO = userService.registerUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("{userId}/")
    public ResponseEntity<UserDTO> getUserDetialById(@PathVariable("userId") Long userId){
        UserDTO userDTO = userService.userDeatilByUserId(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("{userId}/watchlist")
    public ResponseEntity<WatchlistItemDTO> addStockToWatchlist(
            @PathVariable("userId") Long id,
            @RequestBody @Validated WatchlistItemDTO watchlistItemDTO){

        watchlistItemDTO = userService.addStockToWatchlist(id, watchlistItemDTO);
        return new ResponseEntity<>(watchlistItemDTO, HttpStatus.CREATED);
    }

    @GetMapping("{userId}/watchlist")
    public ResponseEntity<List<WatchlistItemDTO>> getWatchlistByUserId(
            @PathVariable("userId") Long id){

        List<WatchlistItemDTO> watchlistItemDTO = userService.getWatchlistByUserId(id);
        return new ResponseEntity<>(watchlistItemDTO, HttpStatus.OK);
    }

    @DeleteMapping("{userId}/watchlist/{symbol}")
    public ResponseEntity<Boolean> removeStockFromWatchlist(
            @PathVariable("userId") Long id, @PathVariable("symbol") String symbol) {

        return new ResponseEntity<>(userService.removeStockFromWatchlist(id,symbol), HttpStatus.OK);
//        return ResponseEntity.ok();
    }



}
