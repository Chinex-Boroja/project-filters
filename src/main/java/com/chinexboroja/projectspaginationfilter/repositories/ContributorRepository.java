package com.chinexboroja.projectspaginationfilter.repositories;

import com.chinexboroja.projectspaginationfilter.model.Contributor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorRepository extends CrudRepository<Contributor, Long> {
}
