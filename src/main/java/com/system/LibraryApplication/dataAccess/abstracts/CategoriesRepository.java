package com.system.LibraryApplication.dataAccess.abstracts;

import com.system.LibraryApplication.entities.concretes.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
