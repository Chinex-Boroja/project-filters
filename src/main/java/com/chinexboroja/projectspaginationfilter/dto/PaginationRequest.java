package com.chinexboroja.projectspaginationfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaginationRequest {

    private Integer pageNumber;
    private Integer pageSize;
    private String sortBy;
    private String direction;
}
