package com.WebScrapingApp.data.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleName;
    private String titleUrl;
    @OneToMany(mappedBy = "title",targetEntity = SubTitle.class,fetch = FetchType.LAZY)
    private List<SubTitle> subTitleList;
    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName = "id")
    private Category category;

}
