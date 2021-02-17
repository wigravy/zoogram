package com.wigravy.zoogram.repositories;

import com.wigravy.zoogram.entities.Post;
import com.wigravy.zoogram.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllByUserOrderByCreatedDesc(User user);

    List<Post> findAllByOrderByCreatedDesc();

    Optional<Post> findByIdAndUser(Long id, User user);
}
