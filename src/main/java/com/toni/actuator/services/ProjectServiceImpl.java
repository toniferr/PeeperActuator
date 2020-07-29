package com.toni.actuator.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.toni.actuator.PeeperActuatorApplication;
import com.toni.actuator.domain.Project;
import com.toni.actuator.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {


    private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
    
    private ProjectRepository projectRepository;
    private JmsTemplate jmsTemplate;

    @Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository, JmsTemplate jmsTemplate) {
		super();
		this.projectRepository = projectRepository;
		this.jmsTemplate = jmsTemplate;
	}

	@Override
    public Project getProject(Integer id) {
        return projectRepository.findById(id).orElse(null);
    }
	
	@Override
    public List<Project> listProjects() {
        return IteratorUtils.toList(projectRepository.findAll().iterator());
    }
	
    @Override
    public void sendMessage(String id) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("id", id);
        log.info("Sending the index request through queue message");
        jmsTemplate.convertAndSend(PeeperActuatorApplication.PROJECT_MESSAGE_QUEUE, actionmap);
    }

}