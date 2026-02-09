package com.proje.FilmWatchlist.controller;

import com.proje.FilmWatchlist.entity.Watchlist;
import com.proje.FilmWatchlist.service.impl.WatchlistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/watchlist")
public class WatchlistController {
    @Autowired
    private WatchlistServiceImpl watchlistService;


    @PostMapping(path = "/add")
    public Watchlist addToWatchList(
            @RequestParam Long userId,
            @RequestParam Long contentId,
            @RequestParam(required = false) Integer score
    ) {
        return watchlistService.addToWatchList(userId, contentId, score);
    }

    @GetMapping("/user/{userId}")
    public List<Watchlist> getUserWatchList(@PathVariable Long userId) {
        return watchlistService.getUserWatchList(userId);
    }

    @PutMapping("/update/{id}/status")
    public Watchlist updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return watchlistService.updateStatus(id, status);
    }

    @PutMapping("/update/{id}/score")
    public Watchlist updateScore(
            @PathVariable Long id,
            @RequestParam Integer score
    ) {
        return watchlistService.updateScore(id, score);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFromWatchList(@PathVariable Long id) {
        watchlistService.deleteFromWatchList(id);
    }
}
