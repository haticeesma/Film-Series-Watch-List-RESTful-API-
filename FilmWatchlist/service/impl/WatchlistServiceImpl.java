package com.proje.FilmWatchlist.service.impl;

import com.proje.FilmWatchlist.entity.Content;
import com.proje.FilmWatchlist.entity.User;
import com.proje.FilmWatchlist.entity.WatchStatus;
import com.proje.FilmWatchlist.entity.Watchlist;
import com.proje.FilmWatchlist.repository.ContentRepository;
import com.proje.FilmWatchlist.repository.UserRepository;
import com.proje.FilmWatchlist.repository.WatchlistRepository;
import com.proje.FilmWatchlist.service.IWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WatchlistServiceImpl implements IWatchlistService {
    @Autowired
    private WatchlistRepository watchlistRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Watchlist addToWatchList(Long userId, Long contentId, Integer score) {

        if (watchlistRepository.existsByUserIdAndContentId(userId, contentId)) {
            throw new RuntimeException("Bu içerik zaten watchlist'te");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User bulunamadı"));

        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("Content bulunamadı"));

        if (score != null && (score < 0 || score > 10)) {
            throw new RuntimeException("Score 0 ile 10 arasında olmalı");
        }

        Watchlist watchList = new Watchlist();
        watchList.setUser(user);
        watchList.setContent(content);
        watchList.setTitle(content.getTitle());
        watchList.setStatus(WatchStatus.TO_WATCH);
        watchList.setScore(score);

        return watchlistRepository.save(watchList);
    }

    @Override
    public List<Watchlist> getUserWatchList(Long userId) {
        return watchlistRepository.findByUserId(userId);
    }

    @Override
    public Watchlist updateStatus(Long watchListId, String status) {

        Watchlist watchList = watchlistRepository.findById(watchListId)
                .orElseThrow(() -> new RuntimeException("WatchList kaydı bulunamadı"));

        WatchStatus watchStatus;
        try {
            watchStatus = WatchStatus.valueOf(status);
        } catch (Exception e) {
            throw new RuntimeException("Geçersiz status");
        }

        watchList.setStatus(watchStatus);
        return watchlistRepository.save(watchList);
    }

    @Override
    public Watchlist updateScore(Long watchListId, Integer score) {

        if (score < 0 || score > 10) {
            throw new RuntimeException("Score 0 ile 10 arasında olmalı");
        }

        Watchlist watchList = watchlistRepository.findById(watchListId)
                .orElseThrow(() -> new RuntimeException("WatchList kaydı bulunamadı"));

        watchList.setScore(score);
        return watchlistRepository.save(watchList);
    }

    @Override
    public void deleteFromWatchList(Long watchListId) {
        watchlistRepository.deleteById(watchListId);
    }
}

