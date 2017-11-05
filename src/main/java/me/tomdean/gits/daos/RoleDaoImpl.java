package me.tomdean.gits.daos;

import me.tomdean.gits.models.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Long, Role> implements RoleDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("role"));
        return (List<Role>) crit.list();
    }

    @Override
    public Role findByRole(String role) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("role", role));
        return (Role) crit.uniqueResult();
    }

    @Override
    public Role findById(Long id) {
        return getByKey(id);
    }
}
