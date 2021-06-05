package com.warehouse.util;

import com.warehouse.dto.ArticleDTO;
import com.warehouse.dto.ArticleEmbededDTO;
import com.warehouse.dto.ProductDTO;
import com.warehouse.entity.Article;
import com.warehouse.entity.ArticleEmbedded;
import com.warehouse.entity.Product;

import java.util.stream.Collectors;

public class WarehouseMapper {

    public static WarehouseMapper INSTANCE = new WarehouseMapper();

    private WarehouseMapper() {
    }

    public Article toEntity(ArticleDTO articleDTO) {
        return Article.builder()
                .id(Long.parseLong(articleDTO.getArt_id()))
                .name(articleDTO.getName())
                .stock(Integer.parseInt(articleDTO.getStock()))
                .build();
    }

    public ArticleDTO toDto(Article article) {
        return ArticleDTO.builder()
                .art_id(String.valueOf(article.getId()))
                .name(article.getName())
                .stock(String.valueOf(article.getStock()))
                .build();
    }

    public ArticleEmbedded toEntity(ArticleEmbededDTO articleEmbededDTO) {
        return ArticleEmbedded.builder()
                .art_id(Long.parseLong(articleEmbededDTO.getArt_id()))
                .stock(Integer.parseInt(articleEmbededDTO.getAmount_of()))
                .build();
    }

    public ArticleEmbededDTO toDto(ArticleEmbedded articleEmbedded) {
        return ArticleEmbededDTO.builder()
                .art_id(String.valueOf(articleEmbedded.getArt_id()))
                .amount_of(String.valueOf(articleEmbedded.getStock()))
                .build();
    }

    public Product toEntity(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .articleSet(productDTO.getContain_articles()
                        .stream()
                        .map(articleEmbededDTO -> WarehouseMapper.INSTANCE.toEntity(articleEmbededDTO))
                        .collect(Collectors.toSet()))
                .build();
    }

    public ProductDTO toDto(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .contain_articles(product.getArticleSet()
                        .stream()
                        .map(articleEmbedded -> WarehouseMapper.INSTANCE.toDto(articleEmbedded))
                        .collect(Collectors.toSet()))
                .build();
    }
}
