package com.WebScrapingApp.data.dto.request;

import com.WebScrapingApp.data.model.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDto {
    private String categoryName;
    private String categoryUrl;
    private List<TitleCreateDTO> titleIds;
}