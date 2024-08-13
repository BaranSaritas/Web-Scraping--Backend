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
public class TitleCreateDTO {
    private String titleName;
    private String titleUrl;
    private List<SubTitleDTO> subTitleList;
    private Long categoryId;
}