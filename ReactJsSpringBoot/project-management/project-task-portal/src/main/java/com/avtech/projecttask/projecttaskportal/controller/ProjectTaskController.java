package com.avtech.projecttask.projecttaskportal.controller;

import com.avtech.projecttask.projecttaskportal.model.ProjectTask;
import com.avtech.projecttask.projecttaskportal.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project-task")
@CrossOrigin
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("/add-or-edit")
    public ResponseEntity<?> addOrEditProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result){

        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
        }

        ProjectTask newPt = projectTaskService.saveOrUpdateProjectTask(projectTask);
        return new ResponseEntity<ProjectTask>(newPt, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ProjectTask> getAllProjectTasks(){
        return projectTaskService.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ProjectTask obj = projectTaskService.getById(id);
        if(obj!=null){
            return new ResponseEntity<ProjectTask>(obj,HttpStatus.OK);
        }
        return new ResponseEntity<String>("Task not present for id: "+id,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        projectTaskService.deleteTask(id);
        return new ResponseEntity<String>("Task deleted for id: "+id,HttpStatus.OK);
    }

}
