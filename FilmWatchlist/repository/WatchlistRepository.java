package com.proje.FilmWatchlist.repository;

import com.proje.FilmWatchlist.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {

    boolean existsByUserIdAndContentId(Long user_id, Long content_id);

    List<Watchlist> findByUserId(Long user_id);

    Optional<Watchlist> findByUserIdAndContentId(Long user_id, Long content_id);

}
