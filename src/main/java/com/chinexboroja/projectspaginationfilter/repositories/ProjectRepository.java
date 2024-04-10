package com.chinexboroja.projectspaginationfilter.repositories;

import com.chinexboroja.projectspaginationfilter.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query("SELECT DISTINCT p FROM Project p LEFT JOIN p.contributors c WHERE " +
            ":lookupText IS NULL " +
            "OR p.projectName LIKE :lookupText " +
            "OR p.description LIKE :lookupText " +
            "OR c.firstName LIKE  :lookupText " +
            "OR c.lastName LIKE :lookupText " +
            "OR c.phoneNumber LIKE :lookupText " +
            "OR c.email LIKE :lookupText " +
            "AND ((:startDate IS NULL AND :endDate IS NULL) OR " +
            "(p.startDate <= :endDate AND p.endDate >= :startDate))")

    Page<Project> search(String lookupText, LocalDate startDate, LocalDate endDate, Pageable pageable);

}
