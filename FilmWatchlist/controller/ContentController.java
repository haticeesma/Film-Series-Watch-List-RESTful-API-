package com.proje.FilmWatchlist.controller;

import com.proje.FilmWatchlist.entity.Content;
import com.proje.FilmWatchlist.entity.ContentType;
import com.proje.FilmWatchlist.service.impl.ContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contents")
public class ContentController {
    @Autowired
    private ContentServiceImpl contentService;

    @PostMapping(path = "/create")
    public Content createContent(@RequestParam String title, @RequestParam ContentType type){
        return contentService.createContent(title, type);
    }

    @GetMapping(path = "/get")
    public List<Content> getAllContent(){
        return contentService.getAllContents();
    }

    @GetMapping(path = "/get/{id}")
    public Content getContentById(@PathVariable Long id){
        return contentService.getContentById(id);
    }
}
