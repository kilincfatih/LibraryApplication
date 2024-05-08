package com.system.LibraryApplication.dataAccess;

import com.system.LibraryApplication.core.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
