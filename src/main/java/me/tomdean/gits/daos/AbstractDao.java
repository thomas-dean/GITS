package me.tomdean.gits.daos;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractDao<PK extends Serializable, T> {
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    AbstractDao(){
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }

    void persist(T entity) {
        getSession().persist(entity);
    }

    void delete(T entity) {
        getSession().delete(entity);
    }

    Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
