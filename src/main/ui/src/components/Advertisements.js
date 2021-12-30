import React, { useState } from "react";
import { Box, Link } from "@material-ui/core";
import { useAdvertisementByCategory, useAdvertisementBySubCategory } from '../data-access/useAdvertisement'
import '../App.css';
import { useParams } from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import AuthenticationService from '../service/AuthenticationService';
import SearchBar from "material-ui-search-bar";

function Advertisements() {
    const { categoryId, subCategoryId } = useParams();
    const navigate = useNavigate();
    if (!AuthenticationService.isUserLoggedIn) {
        navigate('/login');
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
          {categoryId && 
          <AdvertisementsByCategory categoryId={categoryId}/>}
          {subCategoryId && 
          <AdvertisementsBySubCategory subCategoryId={subCategoryId}/>}
      </React.Fragment>
    );
  }

  function AdvertisementList({advertisements}) {
    const [searched, setSearched] = useState("");
    const [data, setData] = useState(advertisements);
    const copyData = (a) => {
        return JSON.parse(JSON.stringify(a));
    }

    const onSearch = (searchedVal) => {
        const dataToFilter = copyData(advertisements);
        const val = searchedVal.toLowerCase();
    
        const filteredRows = dataToFilter.filter((row) => {
          return (row.title.toLowerCase().includes(val)
            || row.description.toLowerCase().includes(val));
        });
        setData(filteredRows);
    };
    
    const onCancelSearch = () => {
        setSearched("");
        onSearch(searched);
    };

    return (
      <React.Fragment>
          <Box className="adv-page" >
                <h2>Anuncios</h2>
                <Box sx={{ marginBottom: 20, width: 600 }} >
                    <SearchBar
                        value={searched}
                        onChange={(searchVal) => onSearch(searchVal)}
                        onCancelSearch={() => onCancelSearch()}
                        placeholder="Filtrar por titulo o descripcion"
                    />
                </Box>
                {data.map((adv, index) => {
                return (
                    <Advertisement key={index} title={adv.title} location={adv.location} description={adv.description}/>
                    );
                })}
          </Box>
      </React.Fragment>
    );
  }

  function AdvertisementsBySubCategory({subCategoryId}) {
    const advertisements = useAdvertisementBySubCategory(subCategoryId);
    if (!advertisements) {
      return null;
    }
    return (
        <AdvertisementList advertisements={advertisements} />
    );
  }

  function AdvertisementsByCategory({categoryId}) {
    const advertisements = useAdvertisementByCategory(categoryId);
    if (!advertisements) {
      return null;
    }
    return (
      <AdvertisementList advertisements={advertisements} />
    );
  }

  function Advertisement({title, location, description}) {
    return (
      <React.Fragment>
            <Box  sx={{marginBottom:15, width: 800 }} className="adv-card">
                <Box sx={{marginBottom: 10, alignContent: 'left' }} className="adv-title">
                    <h4>{title}</h4>
                </Box>
                <Box sx={{marginBottom: 5, alignContent: 'left' }} className="adv-loc">
                    <p>{location}</p>
                </Box>
                <Box sx={{marginBottom: 5, alignContent: 'left' }} className="adv-desc">
                    <p>{description}</p>
                </Box>
            </Box>

      </React.Fragment>
    );
  }
  
  export default Advertisements;
  