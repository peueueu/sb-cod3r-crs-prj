package com.peueueu.sbcourseproject.controllers;

import com.peueueu.sbcourseproject.dto.ProductRequest;
import com.peueueu.sbcourseproject.dto.ProductResponse;
import com.peueueu.sbcourseproject.model.entities.Product;
import com.peueueu.sbcourseproject.model.repositories.ProductRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ProductResponse createProduct(@RequestParam ProductRequest requestBody) {
        try {
            Product product = new Product();
            product.setName(requestBody.name());
            Product savedProduct = productRepository.save(product);
            return ProductResponse.success(savedProduct);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating product: " + Objects.requireNonNull(e.getRootCause()).getMessage());
        }
    }
}
