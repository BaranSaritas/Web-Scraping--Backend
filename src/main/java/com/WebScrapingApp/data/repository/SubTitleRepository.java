package com.WebScrapingApp.data.repository;

import com.WebScrapingApp.data.model.SubTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubTitleRepository extends JpaRepository<SubTitle,Long> {

    @Query("SELECT s FROM SubTitle s WHERE " +
            "(:titleName IS NULL OR LOWER(s.titleName) LIKE LOWER(CONCAT('%', :titleName, '%')))")
    Page<SubTitle> findAllByTitleContaining(@Param("titleName") String titleName, Pageable pageable);
}
