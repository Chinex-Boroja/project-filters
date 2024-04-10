package com.chinexboroja.projectspaginationfilter.service.contributor;

import com.chinexboroja.projectspaginationfilter.model.Contributor;
import com.chinexboroja.projectspaginationfilter.repositories.ContributorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContributorServiceImpl implements ContributorService {

    private final ContributorRepository contributorRepository;

    public ContributorServiceImpl(ContributorRepository contributorRepository) {
        this.contributorRepository = contributorRepository;
    }

    @Override
    public Long createContributor(Contributor contributor) {
        return contributorRepository.save(contributor).getId();
    }

    @Override
    public List<Contributor> getAllContributors() {
        return (List<Contributor>) contributorRepository.findAll();
    }

    @Override
    public Optional<Contributor> getContributorById(Long id) {
        return contributorRepository.findById(id);
    }
}
