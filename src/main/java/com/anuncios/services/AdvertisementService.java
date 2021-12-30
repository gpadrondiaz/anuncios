package com.anuncios.services;

import com.anuncios.entities.Advertisement;
import com.anuncios.model.AdvertisementModel;
import com.anuncios.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<AdvertisementModel> getAdvertisementByCategoryId(Long categoryId) {
        final List<Advertisement> advertisementList = advertisementRepository.findByCategoryId(categoryId);
        final List<AdvertisementModel> advertisementModels = advertisementList.stream()
                .map(advertisement -> new AdvertisementModel(advertisement.getId(), advertisement.getTitle(), advertisement.getLocation(), advertisement.getDescription()))
                .collect(Collectors.toList());
        return  advertisementModels;
    }

    public List<AdvertisementModel> getAdvertisementBySubCategoryId(Long subCategoryId) {
        final List<Advertisement> advertisementList = advertisementRepository.findBySubcategoryId(subCategoryId);
        final List<AdvertisementModel> advertisementModels = advertisementList.stream()
                .map(advertisement -> new AdvertisementModel(advertisement.getId(), advertisement.getTitle(), advertisement.getLocation(), advertisement.getDescription()))
                .collect(Collectors.toList());
        return  advertisementModels;
    }
}
