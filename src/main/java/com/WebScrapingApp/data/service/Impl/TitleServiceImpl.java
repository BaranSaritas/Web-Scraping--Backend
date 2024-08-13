package com.WebScrapingApp.data.service.Impl;

import com.WebScrapingApp.data.dto.request.TitleCreateDTO;
import com.WebScrapingApp.data.dto.request.TitleDTO;
import com.WebScrapingApp.data.model.Category;
import com.WebScrapingApp.data.model.Title;
import com.WebScrapingApp.data.repository.TitleRepository;
import com.WebScrapingApp.data.service.CategoryService;
import com.WebScrapingApp.data.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService {
    private final TitleRepository titleRepository;
  //  private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Override
    public List<TitleDTO> getAllTitles() {
        List<Title> titles = titleRepository.findAll();
        return titles.stream()
                .map(title -> modelMapper.map(title, TitleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TitleDTO getTitleById(Long id) {
        Title title = titleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Title not found"));
        return modelMapper.map(title, TitleDTO.class);
    }

    @Override
    public TitleDTO createTitle(TitleCreateDTO titleCreateDTO) {

        Title title = modelMapper.map(titleCreateDTO, Title.class);
        title.setId(null);

        Title savedTitle = titleRepository.save(title);
        return modelMapper.map(savedTitle, TitleDTO.class);
    }

    @Override
    public TitleDTO updateTitle(Long id, TitleCreateDTO titleCreateDTO) {
        Title title = modelMapper.map(titleCreateDTO, Title.class);
        title.setId(id); // Ensure the ID is set for update
        Title updatedTitle = titleRepository.save(title);
        return modelMapper.map(updatedTitle, TitleDTO.class);
    }

    @Override
    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }
}
