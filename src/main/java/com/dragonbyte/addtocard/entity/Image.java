package com.dragonbyte.addtocard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Blob;

@Entity
@Data
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private Blob image;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
