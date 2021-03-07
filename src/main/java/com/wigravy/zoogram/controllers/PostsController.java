package com.wigravy.zoogram.controllers;

import com.wigravy.zoogram.entities.Post;
import com.wigravy.zoogram.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/v1")
@AllArgsConstructor
public class PostsController {
    private final PostService postService;

    @GetMapping("/posts")
    public Page<Post> getAllPosts(@RequestParam(name = "p", defaultValue = "0") int page,
                                  @RequestParam(name = "s", defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return postService.findAll(pageRequest);
    }
}
