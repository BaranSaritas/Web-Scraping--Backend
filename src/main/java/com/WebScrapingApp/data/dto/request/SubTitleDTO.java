package com.WebScrapingApp.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubTitleDTO {
    private String titleName;
    private String titleUrl;
    private List<ProductDTO> productList;
}
