package com.chinexboroja.projectspaginationfilter.service.project;

import com.chinexboroja.projectspaginationfilter.dto.ProjectFilterRequest;
import com.chinexboroja.projectspaginationfilter.model.Project;
import com.chinexboroja.projectspaginationfilter.repositories.ProjectRepository;
import com.chinexboroja.projectspaginationfilter.util.UtilService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Long createProject(Project project) {
        return projectRepository.save(project).getId();
    }

    @Override
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Page<Project> searchAndFilterProject(ProjectFilterRequest searchRequest) {

        Pageable pageable = UtilService.getPageable(searchRequest);
        String searchText = searchRequest.getSearchText();

        if (searchRequest.getSearchText() != null) {
            searchText = "%" + searchText + "%";
        }

        return projectRepository.search(searchText, searchRequest.getStartDate(), searchRequest.getEndDate(), pageable);
    }
}
