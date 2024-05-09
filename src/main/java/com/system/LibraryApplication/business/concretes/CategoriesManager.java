package com.system.LibraryApplication.business.concretes;

import com.system.LibraryApplication.business.abstracts.CategoriesService;
import com.system.LibraryApplication.entities.concretes.Categories;
import com.system.LibraryApplication.dataAccess.abstracts.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesManager implements CategoriesService {
    private final CategoriesRepository categoriesRepository ;

    @Autowired
    public CategoriesManager(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public Categories save(Categories categories) {
        return categoriesRepository.save(categories);
    }

    @Override
    public void deleteById(Long id) {
        categoriesRepository.deleteById(id);
    }
}
