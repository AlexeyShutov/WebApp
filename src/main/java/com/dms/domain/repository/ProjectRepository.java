package com.dms.domain.repository;

import com.dms.domain.model.Project;

import java.util.List;

public interface ProjectRepository {

    Project add(Project project);
    Project update(Project project);
    void delete(Project project);
    // List query(project specification)

}
