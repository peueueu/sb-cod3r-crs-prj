package com.peueueu.sbcourseproject.dto;

import com.peueueu.sbcourseproject.model.entities.Product;

public record ProductResponse(
        Long id,
        String name,
        String message
) {
    public static ProductResponse success(Product product) {
        return new ProductResponse(product.getId(), product.getName(), "Product created successfully");
    }

    public static ProductResponse error(String errorMessage) {
        return new ProductResponse(null, null, errorMessage);
    }
}
