package com.chinexboroja.projectspaginationfilter.controller.api;

import com.chinexboroja.projectspaginationfilter.dto.ProjectFilterRequest;
import com.chinexboroja.projectspaginationfilter.model.Project;
import com.chinexboroja.projectspaginationfilter.service.project.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<Long> createProject(@RequestBody final Project project) {
        try {
            return ResponseEntity.ok(projectService.createProject(project));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        try {
            return ResponseEntity.ok(projectService.getAllProjects());
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Project>> getProjectById(@PathVariable final Long id) {
        try {
            return ResponseEntity.ok(projectService.getProjectById(id));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @PostMapping("/pages")
    public ResponseEntity<Page<Project>> getProjectById(@RequestBody final ProjectFilterRequest filterRequest) {
        try {
            return ResponseEntity.ok(projectService.searchAndFilterProject(filterRequest));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
