package me.tomdean.gits.daos;

import me.tomdean.gits.models.Structure;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("structureDao")
public class StructureDaoImpl extends AbstractDao<Long, Structure> implements StructureDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<Structure> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("structure"));
        return (List<Structure>) crit.list();
    }

    @Override
    public Structure findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("structure", type));
        return (Structure) crit.uniqueResult();
    }

    @Override
    public Structure findById(Long id) {
        return getByKey(id);
    }
}
