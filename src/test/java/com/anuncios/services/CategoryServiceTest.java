package com.anuncios.services;

import com.anuncios.entities.Category;
import com.anuncios.entities.SubCategory;
import com.anuncios.model.CategoryModel;
import com.anuncios.repositories.CategoryRepository;
import com.anuncios.repositories.SubCategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceTest {
    @Mock
    private SubCategoryRepository subCategoryRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1L, "Autos"));
        categoryList.add(new Category(2L, "Hoteles"));
        categoryList.add(new Category(3L, "Servicios"));

        List<SubCategory> subCategories = new ArrayList<>();
        subCategories.add(new SubCategory(1L, "Camionetas", 1L));
        subCategories.add(new SubCategory(2L, "Motociletas", 1L));
        subCategories.add(new SubCategory(3L, "Posada", 2L));
        subCategories.add(new SubCategory(4L, "Lavanderia", 3L));
        subCategories.add(new SubCategory(5L, "Transporte", 3L));
        subCategories.add(new SubCategory(6L, "Mudanzas", 3L));


        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        Mockito.when(subCategoryRepository.findAll()).thenReturn(subCategories);
    }

    @Test
    public void testGetCategories() throws Exception {
        List<CategoryModel> categoryModel = categoryService.getCategories();

        Assertions.assertEquals(3, categoryModel.size());
        Assertions.assertEquals(2, categoryModel.get(0).getSubCategoryModelList().size());
        Assertions.assertEquals(1, categoryModel.get(1).getSubCategoryModelList().size());
        Assertions.assertEquals(3, categoryModel.get(2).getSubCategoryModelList().size());
    }


}
