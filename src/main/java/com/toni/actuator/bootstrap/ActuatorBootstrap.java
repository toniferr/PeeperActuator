//package com.toni.actuator.bootstrap;
//
//import org.apache.commons.collections4.IteratorUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import com.toni.actuator.domain.Developer;
//import com.toni.actuator.domain.Project;
//import com.toni.actuator.domain.Category;
//import com.toni.actuator.repositories.DeveloperRepository;
//import com.toni.actuator.repositories.ProjectCategoryRepository;
//import com.toni.actuator.repositories.ProjectRepository;
//
//@Component
//public class ActuatorBootstrap implements ApplicationListener<ContextRefreshedEvent> {
//
//    private DeveloperRepository developerRepository;
//    private ProjectRepository projectRepository;
//    private ProjectCategoryRepository projectCategoryRepository;
//
//    @Autowired
//	public void setDeveloperRepository(DeveloperRepository developerRepository) {
//		this.developerRepository = developerRepository;
//	}
//
//    @Autowired
//	public void setProjectRepository(ProjectRepository projectRepository) {
//		this.projectRepository = projectRepository;
//	}
//
//    @Autowired
//	public void setProjectCategoryRepository(ProjectCategoryRepository projectCategoryRepository) {
//		this.projectCategoryRepository = projectCategoryRepository;
//	}
//    
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if(IteratorUtils.toList(developerRepository.findAll().iterator()).isEmpty()) {
//			
//			Developer developer = new Developer();
//	        developer.setId(1);
//	        developer.setFirstName("Toni");
//	        developer.setLastName("Ferreiro");
//	        developer.setImage("luigi.png");
//	        
//	        developer = developerRepository.save(developer);
//
//	        Category springBoot= new Category();
//	        springBoot.setId(1);
//	        springBoot.setName("SpringBoot");
//	        
//	        springBoot = projectCategoryRepository.save(springBoot);
//
//	        Category springmvc= new Category();
//	        springmvc.setId(2);
//	        springmvc.setName("SpringMVC");
//	        
//	        springmvc = projectCategoryRepository.save(springmvc);
//	        
//	        Category struts= new Category();
//	        struts.setId(3);
//	        struts.setName("Struts 2");        
//	        
//	        struts = projectCategoryRepository.save(struts);
//
//	        Category java= new Category();
//	        java.setId(4);
//	        java.setName("Java");
//	        
//	        java = projectCategoryRepository.save(java);
//	        
//	        Category maven= new Category();
//	        maven.setId(5);
//	        maven.setName("Maven");
//	        
//	        maven = projectCategoryRepository.save(maven);
//	        Project eurosnovos= new Project();
//	        eurosnovos.setId(1);
//	        eurosnovos.setName("EurosNovos");
//	        eurosnovos.setSubtitle("SpringBoot Application");
//	        eurosnovos.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
//	        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
//	        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
//	        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
//	        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
//	        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
//	        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
//	        eurosnovos.setDeveloper(developer);
//	        eurosnovos.setLicense("GNU v.3");
//	        eurosnovos.setImageUrl("eurosnovos.jpg");        
//	        eurosnovos.getCategories().add(springBoot);         
//	        eurosnovos.getCategories().add(maven);   
//	        
//	        eurosnovos = projectRepository.save(eurosnovos);
//
//	        Project cryptokit = new Project();
//	        cryptokit.setId(2);
//	        cryptokit.setName("Cryptokit");
//	        cryptokit.setSubtitle("Java Swing with JCA and BouncyCastle");
//	        cryptokit.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
//	        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
//	        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
//	        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
//	        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
//	        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
//	        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
//	        cryptokit.setDeveloper(developer);
//	        cryptokit.setLicense("GNU v.3");
//	        cryptokit.setImageUrl("cryptokit.jpg");        
//	        cryptokit.getCategories().add(java);            
//	        cryptokit.getCategories().add(maven);   
//	        
//	        cryptokit = projectRepository.save(cryptokit);
//
//	        Project setupmakeup = new Project();
//	        setupmakeup.setId(3);
//	        setupmakeup.setName("Setup-Makeup");
//	        setupmakeup.setSubtitle("Spring MVC application (xml conf) and Tiles");
//	        setupmakeup.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
//	        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
//	        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
//	        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
//	        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
//	        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
//	        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
//	        setupmakeup.setDeveloper(developer);
//	        setupmakeup.setLicense("GNU v.3");
//	        setupmakeup.setImageUrl("setup-makeup.jpg");        
//	        setupmakeup.getCategories().add(springmvc);          
//	        setupmakeup.getCategories().add(maven); 
//
//	        setupmakeup = projectRepository.save(setupmakeup);
//
//	        Project setuptecnorepo = new Project();
//	        setuptecnorepo.setId(4);
//	        setuptecnorepo.setName("Setup-Tecnorepo");
//	        setuptecnorepo.setSubtitle("Struts 2 application");
//	        setuptecnorepo.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
//	        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
//	        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
//	        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
//	        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
//	        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
//	        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
//	        setuptecnorepo.setDeveloper(developer);
//	        setuptecnorepo.setLicense("GNU v.3");
//	        setuptecnorepo.setImageUrl("setup-tecnorepo.jpg");        
//	        setuptecnorepo.getCategories().add(struts);               
//	        setuptecnorepo.getCategories().add(maven);  
//
//	        setuptecnorepo = projectRepository.save(setuptecnorepo);
//
//	        Project peeperjava = new Project();
//	        peeperjava.setId(5);
//	        peeperjava.setName("Peeperjava");
//	        peeperjava.setSubtitle("Maven project with multiple Java versions");
//	        peeperjava.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
//	        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
//	        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
//	        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
//	        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
//	        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
//	        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
//	        peeperjava.setDeveloper(developer);
//	        peeperjava.setLicense("Apache");
//	        peeperjava.setImageUrl("peeperjava.jpg");        
//	        peeperjava.getCategories().add(java);    
//
//	        peeperjava = projectRepository.save(peeperjava);
//
//	        Project peepermaven = new Project();
//	        peepermaven.setId(6);
//	        peepermaven.setName("Peepermaven");
//	        peepermaven.setSubtitle("Maven projects with multiple elements of Maven");
//	        peepermaven.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed\r\n" + 
//	        		"						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut\r\n" + 
//	        		"						enim ad minim veniam, quis nostrud exercitation ullamco laboris\r\n" + 
//	        		"						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in\r\n" + 
//	        		"						reprehenderit in voluptate velit esse cillum dolore eu fugiat\r\n" + 
//	        		"						nulla pariatur. Excepteur sint occaecat cupidatat non proident,\r\n" + 
//	        		"						sunt in culpa qui officia deserunt mollit anim id est laborum.");
//	        peepermaven.setDeveloper(developer);
//	        peepermaven.setLicense("Apache");
//	        peepermaven.setImageUrl("peepermaven.jpg");        
//	        peepermaven.getCategories().add(maven);  
//
//	        peepermaven = projectRepository.save(peepermaven);
//		}
//		
//	}
//
//}
