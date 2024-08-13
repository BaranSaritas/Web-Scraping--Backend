package com.WebScrapingApp.data.repository;

import com.WebScrapingApp.data.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Long> {


    Title findByTitleName(String titleName);
}
