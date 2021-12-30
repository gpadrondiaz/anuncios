package com.anuncios.services;

import com.anuncios.entities.Category;
import com.anuncios.entities.SubCategory;
import com.anuncios.model.CategoryModel;
import com.anuncios.model.SubCategoryModel;
import com.anuncios.repositories.CategoryRepository;
import com.anuncios.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getCategories() {
        final List<SubCategory> subCategories = subCategoryRepository.findAll();
        final List<Category> categories = categoryRepository.findAll();

        List<CategoryModel> categoryModelList = new ArrayList<>();
        categories.stream().forEach(category -> {
            final List<SubCategoryModel> subCategoryModelList =  subCategories.stream()
                    .filter(subCategory -> subCategory.getCategoryId().equals(category.getId()))
                    .map(subCategory -> new SubCategoryModel(subCategory.getId(), subCategory.getName(), subCategory.getCategoryId()))
                    .collect(Collectors.toList());
            categoryModelList.add(new CategoryModel(category.getId(), category.getName(), subCategoryModelList));
        });

        return categoryModelList;
    }
}
