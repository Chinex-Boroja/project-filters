package com.chinexboroja.projectspaginationfilter.service.contributor;

import com.chinexboroja.projectspaginationfilter.model.Contributor;

import java.util.List;
import java.util.Optional;

public interface ContributorService {

    Long createContributor(Contributor contributor);

    List<Contributor> getAllContributors();

    Optional<Contributor> getContributorById(Long id);
}
