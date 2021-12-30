package com.anuncios.controller;

import com.anuncios.services.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("advertisement")
public class ScrapeController {
    @Autowired
    private ScraperService scraperService;

    // Con este endpoint se se hace el scrape de milanuncios.com

    @RequestMapping(value = "/scrape", method = RequestMethod.POST)
    public ResponseEntity<String> scrapeWebSite() {

        try {
            scraperService.scrapeWebSite();
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

