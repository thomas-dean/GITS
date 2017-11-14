package me.tomdean.gits.daos;

import me.tomdean.gits.models.Image;

import java.util.List;

public interface ImageDao {
    void save(Image image);
    Image findById(Long id);
    List<Image> findAll();
}
