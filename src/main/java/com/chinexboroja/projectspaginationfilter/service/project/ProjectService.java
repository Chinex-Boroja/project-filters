package com.chinexboroja.projectspaginationfilter.service.project;

import com.chinexboroja.projectspaginationfilter.dto.ProjectFilterRequest;
import com.chinexboroja.projectspaginationfilter.model.Project;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Long createProject(Project project);

    List<Project> getAllProjects();

    Optional<Project> getProjectById(Long id);

    Page<Project> searchAndFilterProject(ProjectFilterRequest searchRequest);
}
