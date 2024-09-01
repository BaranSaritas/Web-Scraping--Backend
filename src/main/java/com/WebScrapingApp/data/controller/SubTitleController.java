package com.WebScrapingApp.data.controller;

import com.WebScrapingApp.data.dto.request.SubTitleDTO;
import com.WebScrapingApp.data.model.SubTitle;
import com.WebScrapingApp.data.service.SubTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subtitles")
public class SubTitleController {

    private final SubTitleService subTitleService;


    @PostMapping
    public ResponseEntity<SubTitle> createSubTitle(@RequestBody SubTitleDTO subTitle) {
        SubTitle createdSubTitle = subTitleService.createSubTitle(subTitle);
        return new ResponseEntity<>(createdSubTitle, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubTitle> getSubTitleById(@PathVariable Long id) {
        Optional<SubTitle> subTitle = subTitleService.getSubTitleById(id);
        return subTitle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find")
    public ResponseEntity<Page<SubTitle>> getAllSubTitles(   @RequestParam(required = false, defaultValue = "")  String titleName,Pageable pageable) {
        Page<SubTitle> subTitles = subTitleService.getAllSubTitles(titleName,pageable);
        return new ResponseEntity<>(subTitles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubTitle> updateSubTitle(@PathVariable Long id, @RequestBody SubTitle subTitle) {
        SubTitle updatedSubTitle = subTitleService.updateSubTitle(id, subTitle);
        return new ResponseEntity<>(updatedSubTitle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubTitle(@PathVariable Long id) {
        subTitleService.deleteSubTitle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<SubTitle>> saveAllSubTitles(@RequestBody List<SubTitle> subTitles) {
        List<SubTitle> savedSubTitles = subTitleService.saveAll(subTitles);
        return new ResponseEntity<>(savedSubTitles, HttpStatus.CREATED);
    }
}
