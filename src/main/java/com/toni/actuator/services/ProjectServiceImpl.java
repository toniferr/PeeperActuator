package com.toni.actuator.services;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toni.actuator.domain.Project;
import com.toni.actuator.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
    public Project getProject(Integer id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> listProjects() {
        return IteratorUtils.toList(projectRepository.findAll().iterator());
    }

}