package com.anuncios.repositories;

import com.anuncios.entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findByCategoryId(Long categoryId);
    List<Advertisement> findBySubcategoryId(Long subCategoryId);
}
