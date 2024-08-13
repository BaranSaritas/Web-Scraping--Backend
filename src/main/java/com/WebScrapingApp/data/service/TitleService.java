package com.WebScrapingApp.data.service;

import com.WebScrapingApp.data.dto.request.TitleCreateDTO;
import com.WebScrapingApp.data.dto.request.TitleDTO;

import java.util.List;

public interface TitleService {
    List<TitleDTO> getAllTitles();

    TitleDTO getTitleById(Long id);

    TitleDTO createTitle(TitleCreateDTO titleCreateDTO);

    TitleDTO updateTitle(Long id, TitleCreateDTO titleCreateDTO);

    void deleteTitle(Long id);
}
