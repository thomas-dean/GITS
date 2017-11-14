package me.tomdean.gits.services;

import me.tomdean.gits.daos.ImageDao;
import me.tomdean.gits.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("imageService")
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public void save(Image image) {
        imageDao.save(image);
    }

    @Override
    public Image findById(Long id) {
        return imageDao.findById(id);
    }

    @Override
    public List<Image> findAll() {
        return imageDao.findAll();
    }
}
