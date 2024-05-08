package com.system.LibraryApplication.api.controllers;

import com.system.LibraryApplication.business.abstracts.CategoriesService;
import com.system.LibraryApplication.core.entities.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = categoriesService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoriesById(@PathVariable Long id) {
        Optional<Categories> categories = categoriesService.findById(id);
        return categories.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Categories> createCategories(@RequestBody Categories categories) {
        Categories newCategories = categoriesService.save(categories);
        return new ResponseEntity<>(newCategories, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategories(@PathVariable Long id, @RequestBody Categories categoriesDetails) {
        Optional<Categories> categories = categoriesService.findById(id);
        if (categories.isPresent()) {
            Categories existingCategories = categories.get();
            existingCategories.setCategoryName(categoriesDetails.getCategoryName());
            Categories updatedCategories = categoriesService.save(existingCategories);
            return new ResponseEntity<>(updatedCategories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategories(@PathVariable Long id) {
        if (categoriesService.findById(id).isPresent()) {
            categoriesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
