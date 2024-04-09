package com.chinexboroja.projectspaginationfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFilterRequest extends PaginationRequest {

    private String searchText;
    private LocalDate startDate;
    private LocalDate endDate;
}
