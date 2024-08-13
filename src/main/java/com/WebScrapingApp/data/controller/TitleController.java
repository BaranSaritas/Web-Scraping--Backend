package com.WebScrapingApp.data.controller;

import com.WebScrapingApp.data.dto.request.TitleCreateDTO;
import com.WebScrapingApp.data.dto.request.TitleDTO;
import com.WebScrapingApp.data.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/title")
public class TitleController {

    private final TitleService titleService;

    @GetMapping
    public ResponseEntity<List<TitleDTO>> getAllTitles() {
        List<TitleDTO> titleDTOs = titleService.getAllTitles();
        return ResponseEntity.ok(titleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitleDTO> getTitleById(@PathVariable Long id) {
        TitleDTO titleDTO = titleService.getTitleById(id);
        return ResponseEntity.ok(titleDTO);
    }

    @PostMapping
    public ResponseEntity<TitleDTO> createTitle(@RequestBody TitleCreateDTO titleCreateDTO) {
        TitleDTO titleDTO = titleService.createTitle(titleCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(titleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TitleDTO> updateTitle(@PathVariable Long id, @RequestBody TitleCreateDTO titleCreateDTO) {
        TitleDTO titleDTO = titleService.updateTitle(id, titleCreateDTO);
        return ResponseEntity.ok(titleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Long id) {
        titleService.deleteTitle(id);
        return ResponseEntity.noContent().build();
    }

}
