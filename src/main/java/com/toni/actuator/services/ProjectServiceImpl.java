package com.toni.actuator.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toni.actuator.domain.Developer;
import com.toni.actuator.domain.Project;
import com.toni.actuator.domain.ProjectCategory;

@Service
public class ProjectServiceImpl implements ProjectService {

	private Map<Integer, Project> projectMap;
	
	public ProjectServiceImpl() {
		loadProjects();
	}	
	
    @Override
    public Project getProject(Integer id) {
        return projectMap.get(id);
    }

    @Override
    public List<Project> listProjects() {
        return new ArrayList<>(projectMap.values());
    }

    private void loadProjects() {

        Developer developer = new Developer();
        developer.setId(1);
        developer.setFirstName("Toni");
        developer.setLastName("Ferreiro");
        developer.setImage("luigi.png");

        ProjectCategory springBoot= new ProjectCategory();
        springBoot.setId(1);
        springBoot.setName("SpringBoot");

        ProjectCategory springmvc= new ProjectCategory();
        springmvc.setId(2);
        springmvc.setName("SpringMVC");
        
        ProjectCategory struts= new ProjectCategory();
        struts.setId(3);
        struts.setName("Struts 2");        

        ProjectCategory java= new ProjectCategory();
        java.setId(4);
        java.setName("Java");
        
        ProjectCategory maven= new ProjectCategory();
        maven.setId(5);
        maven.setName("Maven");

        projectMap = new HashMap<>();

        Project eurosnovos= new Project();
        eurosnovos.setId(1);
        eurosnovos.setName("EurosNovos");
        eurosnovos.setSubtitle("SpringBoot Application");
        eurosnovos.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
        eurosnovos.setDeveloper(developer);
        eurosnovos.setLicense("GNU v.3");
        eurosnovos.setImageUrl("eurosnovos.jpg");        
        eurosnovos.getCategories().add(springBoot);         
        eurosnovos.getCategories().add(maven);           
        projectMap.put(1, eurosnovos);


        Project cryptokit = new Project();
        cryptokit.setId(2);
        cryptokit.setName("Cryptokit");
        cryptokit.setSubtitle("Java Swing with JCA and BouncyCastle");
        cryptokit.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
        cryptokit.setDeveloper(developer);
        cryptokit.setLicense("GNU v.3");
        cryptokit.setImageUrl("cryptokit.jpg");        
        cryptokit.getCategories().add(java);            
        cryptokit.getCategories().add(maven);        
        projectMap.put(2, cryptokit);

        Project setupmakeup = new Project();
        setupmakeup.setId(3);
        setupmakeup.setName("Setup-Makeup");
        setupmakeup.setSubtitle("Spring MVC application (xml conf) and Tiles");
        setupmakeup.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
        setupmakeup.setDeveloper(developer);
        setupmakeup.setLicense("GNU v.3");
        setupmakeup.setImageUrl("setup-makeup.jpg");        
        setupmakeup.getCategories().add(springmvc);          
        setupmakeup.getCategories().add(maven);          
        projectMap.put(3, setupmakeup);


        Project setuptecnorepo = new Project();
        setuptecnorepo.setId(4);
        setuptecnorepo.setName("Setup-Tecnorepo");
        setuptecnorepo.setSubtitle("Struts 2 application");
        setuptecnorepo.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
        setuptecnorepo.setDeveloper(developer);
        setuptecnorepo.setLicense("GNU v.3");
        setuptecnorepo.setImageUrl("setup-tecnorepo.jpg");        
        setuptecnorepo.getCategories().add(struts);               
        setuptecnorepo.getCategories().add(maven);     
        projectMap.put(4, setuptecnorepo);


        Project peeperjava = new Project();
        peeperjava.setId(5);
        peeperjava.setName("Peeperjava");
        peeperjava.setSubtitle("Maven project with multiple Java versions");
        peeperjava.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
        peeperjava.setDeveloper(developer);
        peeperjava.setLicense("Apache");
        peeperjava.setImageUrl("peeperjava.jpg");        
        peeperjava.getCategories().add(java);        
        projectMap.put(5, peeperjava);


        Project peepermaven = new Project();
        peepermaven.setId(6);
        peepermaven.setName("Peepermaven");
        peepermaven.setSubtitle("Maven projects with multiple elements of Maven");
        peepermaven.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
        peepermaven.setDeveloper(developer);
        peepermaven.setLicense("Apache");
        peepermaven.setImageUrl("peepermaven.jpg");        
        peepermaven.getCategories().add(maven);        
        projectMap.put(6, peepermaven);


    }
}