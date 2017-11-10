package me.tomdean.gits.daos;

import me.tomdean.gits.models.Incident;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("incidentDao")
public class IncidentDaoImpl extends AbstractDao<Long, Incident> implements IncidentDao {
    @Override
    public void save(Incident incident) {
        persist(incident);
    }

    @Override
    public void delete(Incident incident) {
        super.delete(incident);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Incident> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("dateCreated"));
        return (List<Incident>) crit.list();
    }

    @Override
    public Incident findById(Long id) {
        return getByKey(id);
    }
}
