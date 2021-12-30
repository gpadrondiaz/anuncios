package com.anuncios.controller;

import com.anuncios.model.AdvertisementModel;
import com.anuncios.model.CategoryModel;
import com.anuncios.services.AdvertisementService;
import com.anuncios.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class AdvertisementController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AdvertisementService advertisementService;

    // Obtener los anuncios por categoria
    @RequestMapping(path = "advertisement/category/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<List<AdvertisementModel>> getAdvertisementByCategory(@PathVariable("categoryId") Long categoryId) {

        try {
            final List<AdvertisementModel> advertisementModels = advertisementService.getAdvertisementByCategoryId(categoryId);
            return new ResponseEntity(advertisementModels, HttpStatus.OK);
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Obtener los anuncios por subcategoria
    @RequestMapping(path = "advertisement/subcategory/{subCategoryId}", method = RequestMethod.GET)
    public ResponseEntity<List<AdvertisementModel>> getAdvertisementBySubCategory(@PathVariable("subCategoryId") Long subCategoryId) {

        try {
            final List<AdvertisementModel> advertisementModels = advertisementService.getAdvertisementBySubCategoryId(subCategoryId);
            return new ResponseEntity(advertisementModels, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Obtener todas las categorias con sus subcategorias
    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryModel>> getCategories() {

        try {
            final List<CategoryModel> categoryModelList = categoryService.getCategories();
            return new ResponseEntity(categoryModelList, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
