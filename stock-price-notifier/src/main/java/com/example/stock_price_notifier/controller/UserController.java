package com.example.stock_price_notifier.controller;

import com.example.stock_price_notifier.dto.UserDTO;
import com.example.stock_price_notifier.dto.WatchlistItemDTO;
import com.example.stock_price_notifier.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserController {

  @Autowired private UserService userService;

  @PostMapping("register")
  @Operation(summary = "Register user details in user table")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
      })
  public ResponseEntity<UserDTO> registerUser(@RequestBody @Validated UserDTO userDTO) {
    userDTO = userService.registerUser(userDTO);
    return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
  }

  @GetMapping("{userId}/")
  @Operation(summary = "Get user details by user id")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
      })
  public ResponseEntity<UserDTO> getUserDetialById(@PathVariable("userId") Long userId) {
    UserDTO userDTO = userService.userDeatilByUserId(userId);
    return new ResponseEntity<>(userDTO, HttpStatus.OK);
  }

  @PostMapping("{userId}/watchlist")
  @Operation(summary = "Add stock details in watchlist table using user id")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
      })
  public ResponseEntity<WatchlistItemDTO> addStockToWatchlist(
      @PathVariable("userId") Long id, @RequestBody @Validated WatchlistItemDTO watchlistItemDTO) {

    watchlistItemDTO = userService.addStockToWatchlist(id, watchlistItemDTO);
    return new ResponseEntity<>(watchlistItemDTO, HttpStatus.CREATED);
  }

  @GetMapping("{userId}/watchlist")
  @Operation(summary = "Get stock details from watchlist table using user id")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
      })
  public ResponseEntity<List<WatchlistItemDTO>> getWatchlistByUserId(
      @PathVariable("userId") Long id) {

    List<WatchlistItemDTO> watchlistItemDTO = userService.getWatchlistByUserId(id);
    return new ResponseEntity<>(watchlistItemDTO, HttpStatus.OK);
  }

  @DeleteMapping("{userId}/watchlist/{symbol}")
  @Operation(summary = "Remove stock details from watchlist table using user id and symbol")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
      })
  public ResponseEntity<Boolean> removeStockFromWatchlist(
      @PathVariable("userId") Long id, @PathVariable("symbol") String symbol) {

    return new ResponseEntity<>(userService.removeStockFromWatchlist(id, symbol), HttpStatus.OK);
  }

  @GetMapping("watchlist/{symbol}")
  @Operation(summary = "Get stocks details from watchlist using symbol")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Symbol found"),
        @ApiResponse(responseCode = "404", description = "Symbol not found")
      })
  public ResponseEntity<List<WatchlistItemDTO>> updateWatchlistBySymbol(
      @PathVariable("symbol") String symbol) {
    List<WatchlistItemDTO> watchlistItemDTOList =
        userService.updateStockDetaiilsFromWatchlistBySymbol(symbol);
    return new ResponseEntity<>(watchlistItemDTOList, HttpStatus.OK);
  }
}
