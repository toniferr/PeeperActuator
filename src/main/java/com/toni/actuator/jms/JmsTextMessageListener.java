package com.toni.actuator.jms;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.toni.actuator.PeeperActuatorApplication;
import com.toni.actuator.domain.Project;
import com.toni.actuator.repositories.ProjectRepository;

@Component
public class JmsTextMessageListener {

	    private ProjectRepository projectRepository;

	    private static final Logger log = LogManager.getLogger(JmsTextMessageListener.class);

	    public JmsTextMessageListener(ProjectRepository projectRepository) {
	        this.projectRepository = projectRepository;
	    }

	    /**
	     * This method is invoked whenever any new message is put in the queue.
	     * See {@link guru.springframework.SpringBootActiveMQApplication} for more details
	     * @param message
	     */
	    @JmsListener(destination = PeeperActuatorApplication.PROJECT_MESSAGE_QUEUE, containerFactory = "jmsFactory")
	    public void receiveMessage(Map<String, String> message) {
	        log.info("Received <" + message + ">");
	        Integer id = Integer.valueOf(message.get("id"));
	        Project project = projectRepository.findById(id).orElse(null);
	        project.setMessageReceived(true);
	        project.setMessageCount(project.getMessageCount() + 1);
	        projectRepository.save(project);
	        log.info("Message processed...");
	    }	    
}