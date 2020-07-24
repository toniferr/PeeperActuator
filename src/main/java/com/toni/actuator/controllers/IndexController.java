package com.toni.actuator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toni.actuator.services.ProjectService;

@Controller
public class IndexController {

    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping({"/","index"})
    public String getIndex(Model model){

        model.addAttribute("projects", projectService.listProjects());

        return "index";
    }
    
    @RequestMapping("secured")
    public String secured(){
        return "secured";
    }
}
