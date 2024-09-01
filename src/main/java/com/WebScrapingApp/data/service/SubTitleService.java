package com.WebScrapingApp.data.service;

import com.WebScrapingApp.data.dto.request.SubTitleDTO;
import com.WebScrapingApp.data.model.SubTitle;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface SubTitleService {

    SubTitle createSubTitle(SubTitleDTO subTitle);

    Optional<SubTitle> getSubTitleById(Long id);

    Page<SubTitle> getAllSubTitles(String titleName,Pageable pageable);

    SubTitle updateSubTitle(Long id, SubTitle subTitle);

    void deleteSubTitle(Long id);

    List<SubTitle> saveAll(List<SubTitle> subTitles);
}
