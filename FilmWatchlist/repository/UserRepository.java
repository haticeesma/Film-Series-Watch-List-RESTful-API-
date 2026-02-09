package com.proje.FilmWatchlist.repository;

import com.proje.FilmWatchlist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
}