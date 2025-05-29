import LandingPage from '../src/pages/LandingPage.jsx';
import Login from '../src/pages/Login.jsx';
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {

  return(
    
    <BrowserRouter>
      <Routes>
        <Route path="/landing_page" element={<LandingPage/>} />
        <Route path='/login' element={<Login/>} />
      </Routes>
    </BrowserRouter>
    
  )
  
}

export default App
