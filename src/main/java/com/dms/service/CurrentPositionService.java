package com.dms.service;

import com.dms.domain.model.CurrentPosition;
import com.dms.domain.repository.CurrentPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CurrentPositionService {

    @Autowired
    private CurrentPositionRepository currentPositionRepository;

    public CurrentPosition getById(Integer id) {
        CurrentPosition currentPosition = currentPositionRepository.getById(id);
        if (currentPosition == null)
            throw new EntityNotFoundException(String.format("Current position with id [%s] is not found", id));
        return currentPosition;
    }
}
