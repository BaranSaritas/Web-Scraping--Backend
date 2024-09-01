package com.WebScrapingApp.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCreateProduct {
    List<ProductCreateDTO> productCreateDTOS;
    Long subtitleId;
}
