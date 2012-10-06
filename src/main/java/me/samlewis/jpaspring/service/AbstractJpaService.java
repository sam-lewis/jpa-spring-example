package me.samlewis.jpaspring.service;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractJpaService<T> {
    private EntityManager entityManager;
    private final Class<T> clazz;

    public AbstractJpaService(Class<T> clazz) {
        this.clazz = clazz;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T get(Long id) {
        return getEntityManager().find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Transactional
    public void save(T item) {
        entityManager.persist(item);
    }

    @Transactional
    public void delete(Long id) {
        T entity = entityManager.find(clazz, id);

        entityManager.remove(entity);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
