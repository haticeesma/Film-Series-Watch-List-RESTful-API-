package com.proje.FilmWatchlist.service;

import com.proje.FilmWatchlist.entity.Watchlist;

import java.util.List;

public interface IWatchlistService {

    Watchlist addToWatchList(Long user_id, Long content_id, Integer score);

    List<Watchlist> getUserWatchList(Long user_id);

    Watchlist updateStatus(Long watchList_id, String status);

    Watchlist updateScore(Long watchList_id, Integer score);

    void deleteFromWatchList(Long watchList_id);
}