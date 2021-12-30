import { useEffect, useState } from 'react';
import Axios from 'axios';

const API_URL_BY_CATEGORY = 'http://localhost:8080/api/advertisement/category/';
const API_URL_BY_SUBCATEGORY = 'http://localhost:8080/api/advertisement/subcategory/';

export function useAdvertisementByCategory(categoryId) {
    const [advertisement, setAdvertisement] = useState();

    useEffect(() => {
        return Axios.get(API_URL_BY_CATEGORY + categoryId)
            .then(response => response.data)
            .then(data => {
                setAdvertisement(data);
            })
            .catch(e => console.log(e));

    });

    return advertisement;
}

export function useAdvertisementBySubCategory(subCategoryId) {
    const [advertisement, setAdvertisement] = useState();

    useEffect(() => {
        return Axios.get(API_URL_BY_SUBCATEGORY + subCategoryId)
            .then(response => response.data)
            .then(data => {
                setAdvertisement(data);
            })
            .catch(e => console.log(e));

    });

    return advertisement;
}