package com.warehouse.service;

import com.warehouse.dto.ArticleDTO;
import com.warehouse.dto.ProductDTO;
import com.warehouse.entity.Article;
import com.warehouse.entity.Product;
import com.warehouse.excetion.ProductNotFoundException;
import com.warehouse.excetion.ProductSoldOutException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface WarehouseService {

    List<Article> loadArticles(MultipartFile articleFile) throws IOException;

    List<Product> loadProducts(MultipartFile productsFile) throws IOException;

    List<ProductDTO> getAllProducts();

    boolean sellProduct(String productName) throws ProductNotFoundException, ProductSoldOutException;

    List<ProductDTO> searchProduct(String query) throws ProductNotFoundException;

    List<ArticleDTO> getArticleStock();
}
