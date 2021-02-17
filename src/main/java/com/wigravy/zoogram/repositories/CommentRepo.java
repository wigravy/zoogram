package com.wigravy.zoogram.repositories;

import com.wigravy.zoogram.entities.Comment;
import com.wigravy.zoogram.entities.Post;
import com.wigravy.zoogram.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);

    Optional<Comment> findByIdAndUser(Long id, User user);
}
