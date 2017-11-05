package me.tomdean.gits.daos;

import me.tomdean.gits.models.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {
    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public User findById(Long id) {
        return getByKey(id);
    }

    @Override
    public User findByUserName(String userName) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("userName", userName));
        return (User) crit.uniqueResult();
    }
}
