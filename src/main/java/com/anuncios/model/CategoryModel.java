package com.anuncios.model;

import java.util.List;

public class CategoryModel {
    private Long id;

    private String name;

    private List<SubCategoryModel> subCategoryModelList;

    public CategoryModel(Long id, String name, List<SubCategoryModel> subCategoryModelList) {
        this.id = id;
        this.name = name;
        this.subCategoryModelList = subCategoryModelList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategoryModel> getSubCategoryModelList() {
        return subCategoryModelList;
    }

    public void setSubCategoryModelList(List<SubCategoryModel> subCategoryModelList) {
        this.subCategoryModelList = subCategoryModelList;
    }
}
