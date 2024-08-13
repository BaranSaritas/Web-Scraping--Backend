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
public class SubTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleName;
    private String titleUrl;
    @OneToMany(mappedBy = "subtitle",targetEntity = Product.class,fetch = FetchType.LAZY)
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name="title_id",referencedColumnName = "id")
    private Title title;
}
