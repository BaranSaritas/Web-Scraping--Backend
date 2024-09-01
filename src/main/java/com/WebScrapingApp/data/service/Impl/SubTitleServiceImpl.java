package com.WebScrapingApp.data.service.Impl;

import com.WebScrapingApp.data.dto.request.SubTitleDTO;
import com.WebScrapingApp.data.model.SubTitle;
import com.WebScrapingApp.data.repository.SubTitleRepository;
import com.WebScrapingApp.data.service.SubTitleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubTitleServiceImpl implements SubTitleService {

    private final SubTitleRepository repository;
    private final ModelMapper mapper;

    @Override
    public SubTitle createSubTitle(SubTitleDTO subTitledto) {
        SubTitle subTitle = mapper.map(subTitledto,SubTitle.class);
        subTitle.setId(null);
        return repository.save(subTitle);
    }

    @Override
    public Optional<SubTitle> getSubTitleById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<SubTitle> getAllSubTitles(String titleName, Pageable pageable) {
        return repository.findAllByTitleContaining(titleName,pageable);
    }

    @Override
    public SubTitle updateSubTitle(Long id, SubTitle subTitle) {
        if (repository.existsById(id)) {
            subTitle.setId(id);
            return repository.save(subTitle);
        }
        throw new RuntimeException("Subtitle not found with id " + id);
    }

    @Override
    public void deleteSubTitle(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<SubTitle> saveAll(List<SubTitle> subTitles) {
        return repository.saveAll(subTitles);
    }
}



