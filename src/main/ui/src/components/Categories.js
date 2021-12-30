import React from "react";
import {
  Box,
  Link
} from "@material-ui/core";
import useCategory from '../data-access/useCategory'
import '../App.css';
import { useNavigate } from "react-router-dom";
import AuthenticationService from '../service/AuthenticationService';

function Categories() {
  const navigate = useNavigate();
  const showAdvertisements = (url) => {
    navigate(url);

  }
  if (!AuthenticationService.isUserLoggedIn) {
    navigate('/login');
  }
  const categories = useCategory();
  if (!categories) {
    return null;
  }
 
  
  return (
    <React.Fragment>
        <Box className="logout" sx={{ paddingTop: 30, paddingLeft: 30}}>
            <Link
                    onClick={() => {
                        AuthenticationService.logout();
                        navigate('/logout');
                    }}

                >
                    LOGOUT
            </Link>
        </Box>
        <div className="app-header">
                {categories.map((cat) => {
                return (
                    <div>
                        <Box sx={{ marginBottom: 10 }}>
                            <Link  
                                index={cat.id}
                                className="app-category-link"
                                onClick={() => {
                                    const url = `/advertimentsbycategory/${cat.id}`;
                                    showAdvertisements(url);
                                }}
                            >
                                {cat.name}
                            </Link>
                        </Box>
                        <Box sx={{ marginBottom: 20, width: 1200 }}>
                        {cat.subCategoryModelList.map((subCat) => {
                            return (
                            <Link 
                                key={subCat.id}
                                className="app-subcategory-link"
                                onClick={() => {
                                    const url = `/advertimentsbysubcategory/${subCat.id}`;
                                    showAdvertisements(url);
                                }}
                                underline="hover"
                            >
                                {subCat.name}
                            </Link>
                            );
                            })}        
                        </Box>
                    </div>
                    );
                })}
        </div>
    </React.Fragment>
  );
}

export default Categories;
