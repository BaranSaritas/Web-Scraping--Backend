package com.WebScrapingApp.data.service.Impl;

import com.WebScrapingApp.data.dto.request.ListCreateProduct;
import com.WebScrapingApp.data.dto.request.ProductCreateDTO;
import com.WebScrapingApp.data.dto.request.ProductDTO;
import com.WebScrapingApp.data.model.Product;
import com.WebScrapingApp.data.model.SubTitle;
import com.WebScrapingApp.data.repository.ProductRepository;
import com.WebScrapingApp.data.service.ProductService;
import com.WebScrapingApp.data.service.SubTitleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SubTitleService subTitleService;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(Long id,ProductCreateDTO productCreateDTO) {
        SubTitle subTitle = subTitleService.getSubTitleById(id).orElseThrow(IllegalArgumentException::new);
        Product product = modelMapper.map(productCreateDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductCreateDTO productCreateDTO) {
        Product product = modelMapper.map(productCreateDTO, Product.class);
        product.setId(id);
        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> createProducts(ListCreateProduct productCreateDTO) {

        List<Product> createProducts = new ArrayList<>();
        SubTitle subTitle = subTitleService.getSubTitleById(productCreateDTO.getSubtitleId()).get();
        LocalDate today = LocalDate.now();

        for (ProductCreateDTO productDTO : productCreateDTO.getProductCreateDTOS()) {

            boolean exists = productRepository.existsByBrandAndNameAndSubCategoryAndDate(
                    productDTO.getBrand(),
                    productDTO.getName(),
                    productDTO.getSubCategory(),
                    today
            );

            if (!exists) {
                Product product = new Product();
                product.setBrand(productDTO.getBrand());
                product.setName(productDTO.getName());
                product.setSubCategory(productDTO.getSubCategory());
                product.setFavoriteCount(productDTO.getFavoriteCount());
                product.setRatingScore(productDTO.getRatingScore());
                product.setRatingCount(productDTO.getRatingCount());
                product.setPrice(productDTO.getPrice());
                product.setSubtitle(subTitle);
                product.setDate(today);

                createProducts.add(product);
            }
        }

        productRepository.saveAll(createProducts);

        return createProducts.stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand(product.getBrand());
        productDTO.setName(product.getName());
        productDTO.setSubCategory(product.getSubCategory());
        productDTO.setRatingCount(product.getRatingCount());
        productDTO.setFavoriteCount(product.getFavoriteCount());
        productDTO.setRatingScore(product.getRatingScore());
        productDTO.setPrice(product.getPrice());
        productDTO.setTitleId(product.getSubtitle().getId());
        return productDTO;
    }
}
