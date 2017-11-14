package me.tomdean.gits.daos;

import me.tomdean.gits.models.ImageFormat;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("imageFormatDao")
public class ImageFormatDaoImpl extends AbstractDao<Long, ImageFormat> implements ImageFormatDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<ImageFormat> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("format"));
        return (List<ImageFormat>) crit.list();
    }

    @Override
    public ImageFormat findById(Long id) {
        return getByKey(id);
    }

    @Override
    public ImageFormat findByFormat(String format) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("format", format));
        return (ImageFormat) crit.uniqueResult();
    }
}
