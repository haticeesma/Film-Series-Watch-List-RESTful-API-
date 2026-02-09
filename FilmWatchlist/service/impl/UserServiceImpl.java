package com.proje.FilmWatchlist.service.impl;

import com.proje.FilmWatchlist.entity.User;
import com.proje.FilmWatchlist.repository.UserRepository;
import com.proje.FilmWatchlist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(String username) {

        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Bu username zaten kullanılıyor");
        }

        User user = new User();
        user.setUsername(username);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User bulunamadı"));
    }
}
