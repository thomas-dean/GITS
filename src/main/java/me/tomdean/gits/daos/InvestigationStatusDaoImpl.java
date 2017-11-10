package me.tomdean.gits.daos;

import me.tomdean.gits.models.InvestigationStatus;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("investigationStatusDao")
public class InvestigationStatusDaoImpl extends AbstractDao<Long, InvestigationStatus> implements InvestigationStatusDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<InvestigationStatus> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("status"));
        return (List<InvestigationStatus>) crit.list();
    }

    @Override
    public InvestigationStatus findByStatus(String status) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("status", status));
        return (InvestigationStatus) crit.uniqueResult();
    }

    @Override
    public InvestigationStatus findById(Long id) {
        return getByKey(id);
    }
}
