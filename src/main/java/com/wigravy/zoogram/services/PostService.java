package com.wigravy.zoogram.services;

import com.wigravy.zoogram.entities.Post;
import com.wigravy.zoogram.repositories.PostRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepo postRepo;

    public Optional<Post> findById(Long id){
        return postRepo.findById(id);
    }

    public Page<Post> findAll(PageRequest pageRequest) {
        return postRepo.findAll(pageRequest);
    }
}
