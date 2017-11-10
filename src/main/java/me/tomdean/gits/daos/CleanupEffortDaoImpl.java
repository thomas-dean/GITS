package me.tomdean.gits.daos;

import me.tomdean.gits.models.CleanupEffort;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cleanupEffortDao")
public class CleanupEffortDaoImpl extends AbstractDao<Long, CleanupEffort> implements CleanupEffortDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<CleanupEffort> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("effort"));
        return (List<CleanupEffort>) crit.list();
    }

    @Override
    public CleanupEffort findByEffort(String effort) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("effort", effort));
        return (CleanupEffort) crit.uniqueResult();
    }

    @Override
    public CleanupEffort findById(Long id) {
        return getByKey(id);
    }
}
