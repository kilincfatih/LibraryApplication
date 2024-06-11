package com.system.LibraryApplication.business.rules;

import com.system.LibraryApplication.business.messages.AuthorsMessages;
import com.system.LibraryApplication.business.messages.CategoriesMessages;
import com.system.LibraryApplication.core.utilities.exceptions.types.BusinessException;
import com.system.LibraryApplication.dataAccess.abstracts.AuthorsRepository;
import com.system.LibraryApplication.dataAccess.abstracts.CategoriesRepository;
import com.system.LibraryApplication.entities.concretes.Authors;
import com.system.LibraryApplication.entities.concretes.Categories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CategoriesBusinessRules {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesBusinessRules(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void idMustExist(Long id) {
        Optional<Categories> existingCategories = categoriesRepository.findById(id);
        if (existingCategories.isEmpty()) {
            throw new BusinessException(CategoriesMessages.idIsNotExists);
        }
    }

}
