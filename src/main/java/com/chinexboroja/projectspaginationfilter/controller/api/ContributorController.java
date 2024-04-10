package com.chinexboroja.projectspaginationfilter.controller.api;

import com.chinexboroja.projectspaginationfilter.model.Contributor;
import com.chinexboroja.projectspaginationfilter.service.contributor.ContributorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contributors")
public class ContributorController {

    private final ContributorService contributorService;

    public ContributorController(ContributorService contributorService) {
        this.contributorService = contributorService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<Long> createContributor(@RequestBody Contributor contributor) {
        try {
            return ResponseEntity.ok(contributorService.createContributor(contributor));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }


}
