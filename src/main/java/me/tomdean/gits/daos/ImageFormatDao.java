package me.tomdean.gits.daos;

import me.tomdean.gits.models.ImageFormat;

import java.util.List;

public interface ImageFormatDao {
    List<ImageFormat> findAll();
    ImageFormat findById(Long id);
    ImageFormat findByFormat(String format);
}
