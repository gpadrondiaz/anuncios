import { useEffect, useState } from 'react';
import Axios from 'axios';

const API_URL = 'http://localhost:8080/api/categories';

export default function useCategory() {
    const [categories, setCategories] = useState();

    useEffect(() => {
        return Axios.get(API_URL)
            .then(response => response.data)
            .then(data => {
                setCategories(data);
            })
            .catch(e => console.log(e));

    });

    return categories;
}