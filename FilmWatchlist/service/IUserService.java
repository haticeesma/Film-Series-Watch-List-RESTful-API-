package com.proje.FilmWatchlist.service;

import com.proje.FilmWatchlist.entity.User;

import java.util.List;

public interface IUserService {
    User createUser(String username);

    List<User> getAllUsers();

    User getUserById(Long id);
}
