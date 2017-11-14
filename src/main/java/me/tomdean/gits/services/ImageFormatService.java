package me.tomdean.gits.services;

import me.tomdean.gits.models.ImageFormat;
import org.springframework.http.MediaType;

import java.util.List;

public interface ImageFormatService {
    List<ImageFormat> findAll();
    ImageFormat findById(Long id);
    ImageFormat findByFormat(String format);
    MediaType getMediaType(ImageFormat format);
}
