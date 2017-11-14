package me.tomdean.gits.services;

import me.tomdean.gits.daos.ImageFormatDao;
import me.tomdean.gits.models.ImageFormat;
import me.tomdean.gits.models.ImageFormatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("imageFormatService")
@Transactional
public class ImageFormatServiceImpl implements ImageFormatService {
    @Autowired
    private ImageFormatDao imageFormatDao;

    @Override
    public List<ImageFormat> findAll() {
        return imageFormatDao.findAll();
    }

    @Override
    public ImageFormat findById(Long id) {
        return imageFormatDao.findById(id);
    }

    @Override
    public ImageFormat findByFormat(String format) {
        /* We always want to use upper case, since our data is stored in all upper case */
        format = format.toUpperCase();
        return imageFormatDao.findByFormat(format);
    }

    @Override
    public MediaType getMediaType(ImageFormat format) {
        /*
         * If we get a null, we return a null.
         * We do this so we can chain a findBy* with a getMediaType
         * and not have it blow up from a null pointer.
         */
        if (format == null) {
            return null;
        }

        String formatString = format.getFormat();
        if (formatString.equals(ImageFormatType.PNG.getFormatType())) {
            return MediaType.IMAGE_PNG;
        } else if (formatString.equals(ImageFormatType.JPG.getFormatType())
                || formatString.equals(ImageFormatType.JPEG.getFormatType())) {
            return MediaType.IMAGE_JPEG;
        } else if (formatString.equals(ImageFormatType.GIF.getFormatType())) {
            return MediaType.IMAGE_GIF;
        }
        return null;
    }
}
