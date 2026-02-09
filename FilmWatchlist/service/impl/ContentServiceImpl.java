package com.proje.FilmWatchlist.service.impl;

import com.proje.FilmWatchlist.entity.Content;
import com.proje.FilmWatchlist.entity.ContentType;
import com.proje.FilmWatchlist.repository.ContentRepository;
import com.proje.FilmWatchlist.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentServiceImpl implements IContentService {

    @Autowired
    private ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public Content createContent(String title, ContentType type) {

        Content content = new Content();
        content.setTitle(title);
        content.setType(type);

        return contentRepository.save(content);
    }

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public Content getContentById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content bulunamadı"));
    }
}
