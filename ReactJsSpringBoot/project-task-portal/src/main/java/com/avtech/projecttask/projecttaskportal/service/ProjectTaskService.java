package com.avtech.projecttask.projecttaskportal.service;

import com.avtech.projecttask.projecttaskportal.model.ProjectTask;
import com.avtech.projecttask.projecttaskportal.repository.ProjectTaskRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;


    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask){
        if(Strings.isBlank(projectTask.getStatus())){
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll(){
        return projectTaskRepository.findAll();
    }

    public ProjectTask getById(Long id){
        return projectTaskRepository.getById(id);
    }

    public void deleteTask(Long id){
        projectTaskRepository.deleteById(id);
    }
}
