package com.anuncios.services;

import java.io.IOException;

import com.anuncios.entities.Advertisement;
import com.anuncios.entities.Category;
import com.anuncios.entities.SubCategory;
import com.anuncios.repositories.AdvertisementRepository;
import com.anuncios.repositories.CategoryRepository;
import com.anuncios.repositories.SubCategoryRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScraperService {
    private final static String WEB_SITE_URL = "https://www.milanuncios.com";

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public void scrapeWebSite() {
        try {
            // Here we create a document object and use JSoup to fetch the website
            final Connection.Response response = Jsoup
                    .connect(WEB_SITE_URL).ignoreHttpErrors(true)
                    .ignoreContentType(true).userAgent("Chrome")
                    .method(Connection.Method.GET)
                    .execute();

            final Document doc = response.parse();

            final Elements categories = doc.getElementsByClass("ma-CategoriesCategory");
            for (Element category: categories) {
                final String categoryName =  category.getElementsByClass("ma-MainCategory-mainCategoryNameLink").text();
                final Elements subCategories = category.getElementsByTag("li");
                final Category newCategory = categoryRepository.save(new Category(categoryName));
                for (Element subCategory: subCategories) {
                    final String subCategoryName =  subCategory.text();
                    final String link = subCategory.getElementsByTag("a").get(0).attr("href");
                    final Document advertisementsPerSubC = Jsoup.connect(WEB_SITE_URL + link).ignoreHttpErrors(true)
                            .ignoreContentType(true).userAgent("Chrome").referrer(WEB_SITE_URL).timeout(10000000)
                            .get();
                    final Elements advertisements = advertisementsPerSubC.getElementsByClass("ma-AdCard");
                    final SubCategory newSubCategory = subCategoryRepository.save(new SubCategory(subCategoryName, newCategory.getId()));

                    for (Element adv: advertisements) {
                        final String title = adv.getElementsByClass("ma-AdCard-title-text").first().text();
                        final String location = adv.getElementsByClass("ma-AdLocation-location").first().text();
                        final String description = adv.getElementsByClass("ma-AdCardDescription-text").first().text();
                        advertisementRepository.save(new Advertisement(title, location, description, newSubCategory.getId(), newCategory.getId()));
                    }
                }
            }

            // In case of any IO errors, we want the messages written to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
