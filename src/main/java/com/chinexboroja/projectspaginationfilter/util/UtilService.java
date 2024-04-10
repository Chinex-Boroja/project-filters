package com.chinexboroja.projectspaginationfilter.util;

import com.chinexboroja.projectspaginationfilter.dto.ProjectFilterRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class UtilService {

    public static Pageable getPageable(ProjectFilterRequest filterRequest) {
        String sortBy = filterRequest.getSortBy();
        String direction = filterRequest.getDirection();

        Sort.Direction sortDirection;

        if (filterRequest.getPageNumber() == null || filterRequest.getPageSize() == null) {
            return null;
        }

        if (filterRequest.getSortBy() == null || filterRequest.getSortBy().isBlank()) {
            sortBy = "id";
        }

        if (filterRequest.getDirection() == null || filterRequest.getDirection().isBlank()) {
            direction = "DESC";
        }

        sortDirection = Sort.Direction.fromString(direction);
        return PageRequest.of(filterRequest.getPageNumber(), filterRequest.getPageSize(), sortDirection, sortBy);
    }
}
