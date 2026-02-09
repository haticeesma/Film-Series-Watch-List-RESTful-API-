package com.proje.FilmWatchlist.service;

import com.proje.FilmWatchlist.entity.Content;
import com.proje.FilmWatchlist.entity.ContentType;

import java.util.List;

public interface IContentService {
    Content createContent(String title, ContentType type);

    List<Content> getAllContents();

    Content getContentById(Long id);
}
