package com.toni.actuator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.toni.actuator.domain.Developer;

public interface DeveloperRepository extends CrudRepository<Developer, Integer>{

}
