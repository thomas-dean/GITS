package me.tomdean.gits.daos;

import me.tomdean.gits.models.Damage;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("damageDao")
public class DamageDaoImpl extends AbstractDao<Long, Damage> implements DamageDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<Damage> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("damage"));
        return (List<Damage>) crit.list();
    }

    @Override
    public Damage findById(Long id) {
        return getByKey(id);
    }

    @Override
    public Damage findBySeverity(String severity) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("damage", severity));
        return (Damage) crit.uniqueResult();
    }
}
