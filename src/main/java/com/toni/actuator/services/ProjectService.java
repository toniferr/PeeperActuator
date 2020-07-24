package com.toni.actuator.services;

import java.util.List;

import com.toni.actuator.domain.Project;

public interface ProjectService {

	Project getProject(Integer id);

    List<Project> listProjects();

}
