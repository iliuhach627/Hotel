package com.senla.hotel.api.repository;

import com.senla.hotel.model.BaseEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class AbstractDao<ENTITY extends BaseEntity> implements BaseDao<ENTITY> {

    private final Class<ENTITY> persistentClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public ENTITY save(ENTITY entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Collection<ENTITY> findAll() {
        return entityManager.createQuery("Select entity from " + persistentClass.getSimpleName() + " entity",
                persistentClass).getResultList();
    }


    @Override
    public ENTITY findById(UUID id) {
        return entityManager.find(persistentClass, id);
    }

    @Override
    public void delete(UUID id) {
       entityManager.remove(findById(id));
        entityManager.createQuery("Delete from " + persistentClass.getSimpleName() + " entity Where entity.id = :id").setParameter("id", id)
        ;
    }

    @Override
    public void update(ENTITY entity) {
        entityManager.merge(entity);
    }
}
