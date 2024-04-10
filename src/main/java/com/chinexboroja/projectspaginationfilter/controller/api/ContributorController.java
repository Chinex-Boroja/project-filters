package com.chinexboroja.projectspaginationfilter.controller.api;

import com.chinexboroja.projectspaginationfilter.model.Contributor;
import com.chinexboroja.projectspaginationfilter.service.contributor.ContributorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contributors")
public class ContributorController {

    private final ContributorService contributorService;

    public ContributorController(ContributorService contributorService) {
        this.contributorService = contributorService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<Long> createContributor(@RequestBody final Contributor contributor) {
        try {
            return ResponseEntity.ok(contributorService.createContributor(contributor));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Contributor>> getAllContributors() {
        try {
            return ResponseEntity.ok(contributorService.getAllContributors());
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contributor>> getContributorById(@PathVariable final Long id) {
        try {
            return ResponseEntity.ok(contributorService.getContributorById(id));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
