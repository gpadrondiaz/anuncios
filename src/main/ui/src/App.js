import './App.css';
import Categories from './components/Categories'
import Advertisements from './components/Advertisements'
import Login from './components/Login'
import Logout from './components/Logout'
import { Route, Routes, BrowserRouter} from 'react-router-dom';

function App() {
  return (
        <BrowserRouter>
          <Routes>
            <Route path="/" exact element={<Login />} />
            <Route path="/login" exact element={<Login />} />
            <Route exact path="/home" element={<Categories />}/>
            <Route path="/advertimentsbycategory/:categoryId" element={<Advertisements />}/>
            <Route path="/advertimentsbysubcategory/:subCategoryId" element={<Advertisements />}/>
            <Route path="/logout" element={<Logout />}/>
          </Routes>
        </BrowserRouter>
  );
}

export default App;
