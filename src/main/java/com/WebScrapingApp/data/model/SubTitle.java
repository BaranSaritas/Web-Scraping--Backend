package com.WebScrapingApp.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "subtitle",targetEntity = Product.class,fetch = FetchType.LAZY)
    private List<Product> productList;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="title_id",referencedColumnName = "id")
    private Title title;
}
