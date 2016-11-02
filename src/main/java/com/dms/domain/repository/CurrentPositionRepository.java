package com.dms.domain.repository;

import com.dms.domain.model.CurrentPosition;

import java.util.List;

public interface CurrentPositionRepository {

    List<CurrentPosition> getAll();

    CurrentPosition getById(Integer id);

    void add(CurrentPosition currentPosition);

    void update(CurrentPosition currentPosition);

    void delete(CurrentPosition currentPosition);
}
