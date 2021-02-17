package com.wigravy.zoogram.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "image_bytes")
    private byte[] imageBytes;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
