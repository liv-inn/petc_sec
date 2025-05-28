import LandingPage from '../src/pages/LandingPage.jsx';
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {

  return(
    
    <BrowserRouter>
      <Routes>
        <Route path="/landing_page" element={<LandingPage/>} />
      </Routes>
    </BrowserRouter>
    
  )
  
}

export default App
