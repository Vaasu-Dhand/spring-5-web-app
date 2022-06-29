package com.spring.web.repository;

import com.spring.web.model.Author;
import org.springframework.data.repository.CrudRepository;

// At runtime spring will provide implementations for the methods defined in the CrudRepository Interface
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
