package me.tomdean.gits.daos;

import me.tomdean.gits.models.Crew;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("crewDao")
public class CrewDaoImpl extends AbstractDao<Long, Crew> implements CrewDao {
    @Override
    public void save(Crew crew) {
        persist(crew);
    }

    @Override
    public void delete(Crew crew) {
        super.delete(crew);
    }

    @Override
    public Crew findById(Long id) {
        return getByKey(id);
    }

    @Override
    public Crew findByCrewId(String crewId) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("crewId", crewId));
        return (Crew) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Crew> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("crewId"));
        return (List<Crew>) crit.list();
    }
}
