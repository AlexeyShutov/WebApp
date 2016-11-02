package com.dms.domain.repository;

import com.dms.domain.model.CurrentPosition;
import com.dms.domain.model.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class CurrentPositionRepositoryImpl implements CurrentPositionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CurrentPosition> getAll() {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        return null;
    }

    @Override
    public CurrentPosition getById(Integer id) {
        return entityManager.find(CurrentPosition.class, id);
    }

    @Override
    public void add(CurrentPosition currentPosition) {
        entityManager.persist(currentPosition);
    }

    @Override
    public void update(CurrentPosition currentPosition) {
        CurrentPosition positionPersistent = getById(currentPosition.getId());

        if (positionPersistent != null) {
            positionPersistent.setName(currentPosition.getName());
            // TODO: Department department = depService.findById(currentPosition.getDepartment().getId());
            positionPersistent.setDepartment(currentPosition.getDepartment());
        }
    }

    @Override
    public void delete(CurrentPosition currentPosition) {
        entityManager.remove(currentPosition);
    }
}
