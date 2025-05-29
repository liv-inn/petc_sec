import LandingPage from '../src/pages/LandingPage.jsx';
import Login from '../src/pages/Login.jsx';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignUp from '../src/pages/SignUp.jsx';
import Home from '../src/pages/Home.jsx';

function App() {

  return(
    
    <BrowserRouter>
      <Routes>
        <Route path="/landing_page" element={<LandingPage/>} />
        <Route path='/login' element={<Login/>} />
        <Route path='/cadastro' element={<SignUp/>} />
        <Route path="/home" element={<Home/>} />
      </Routes>
    </BrowserRouter>
    
  )
  
}

export default App
