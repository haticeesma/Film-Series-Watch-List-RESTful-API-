package com.proje.FilmWatchlist.repository;

import com.proje.FilmWatchlist.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {

}