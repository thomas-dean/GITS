package me.tomdean.gits.daos;

import me.tomdean.gits.models.Image;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("imageDao")
public class ImageDaoImpl extends AbstractDao<Long, Image> implements ImageDao {
    @Override
    public void save(Image image) {
        persist(image);
    }

    @Override
    public Image findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Image> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("id"));
        return (List<Image>) crit.list();
    }
}
