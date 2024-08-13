package com.WebScrapingApp.data.dto.request;

import com.WebScrapingApp.data.model.SubTitle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TitleDTO {
    private Long id;
    private String titleName;
    private String titleUrl;
    private Long categoryId;
    private List<SubTitleDTO> subTitleList;

}