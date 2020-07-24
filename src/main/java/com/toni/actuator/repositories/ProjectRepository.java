package com.toni.actuator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.toni.actuator.domain.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
