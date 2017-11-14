package me.tomdean.gits.services;

import me.tomdean.gits.models.Image;

import java.util.List;

public interface ImageService {
    void save(Image image);
    Image findById(Long id);
    List<Image> findAll();
}
