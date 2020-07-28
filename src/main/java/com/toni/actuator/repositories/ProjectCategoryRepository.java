package com.toni.actuator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.toni.actuator.domain.Category;

public interface ProjectCategoryRepository extends CrudRepository<Category, Integer>{

}
