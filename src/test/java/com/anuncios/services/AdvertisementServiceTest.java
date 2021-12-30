package com.anuncios.services;

import com.anuncios.entities.Advertisement;
import com.anuncios.entities.Category;
import com.anuncios.entities.SubCategory;
import com.anuncios.model.AdvertisementModel;
import com.anuncios.model.CategoryModel;
import com.anuncios.repositories.AdvertisementRepository;
import com.anuncios.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementServiceTest {
    @Mock
    private AdvertisementRepository advertisementRepository;

    @InjectMocks
    private AdvertisementService advertisementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Advertisement> advertisementList = new ArrayList<>();
        advertisementList.add(new Advertisement(1L, "Toyota", "Malaga", "Buen estadado", 1L,1L));
        advertisementList.add(new Advertisement(2L, "Mazda", "Malaga", "Buen estadado", 2L,1L));

        Mockito.when(advertisementRepository.findByCategoryId(1L)).thenReturn(advertisementList);
        Mockito.when(advertisementRepository.findBySubcategoryId(1L)).thenReturn(advertisementList.subList(0, 1));
    }

    @Test
    public void testGetByCategory() {
        List<AdvertisementModel> advertisementModels = advertisementService.getAdvertisementByCategoryId(1L);

        Assertions.assertEquals(2, advertisementModels.size());
    }

    @Test
    public void testGetBySubCategory() {
        List<AdvertisementModel> advertisementModels = advertisementService.getAdvertisementBySubCategoryId(1L);

        Assertions.assertEquals(1, advertisementModels.size());
        Assertions.assertEquals("Toyota", advertisementModels.get(0).getTitle());
    }

}
