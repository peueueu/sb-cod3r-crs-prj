package com.peueueu.sbcourseproject.model.repositories;

import com.peueueu.sbcourseproject.model.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
