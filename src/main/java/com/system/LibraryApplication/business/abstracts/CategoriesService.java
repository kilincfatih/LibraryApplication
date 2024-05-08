package com.system.LibraryApplication.business.abstracts;

import com.system.LibraryApplication.core.entities.Categories;
import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    List<Categories> findAll();
    Optional<Categories> findById(Long id);
    Categories save(Categories categories);
    void deleteById(Long id);
}
