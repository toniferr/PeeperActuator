package com.toni.actuator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toni.actuator.services.ProjectService;

@Controller
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping("/project")
    public String getProject(){
        return "redirect:/index";
    }

    @RequestMapping("/project/{id}")
    public String getProjectById(@PathVariable Integer id, Model model){

        model.addAttribute("project", projectService.getProject(id));

        return "project";
    }
}
