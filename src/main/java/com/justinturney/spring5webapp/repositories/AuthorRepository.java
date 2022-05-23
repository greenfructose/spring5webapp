package com.justinturney.spring5webapp.repositories;

import com.justinturney.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
