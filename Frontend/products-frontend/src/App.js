import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ProductList from './components/ProductList'
import ProductDetail from './components/ProductDetail'

function App() {
  return (
    <Router>
      <h1>Welcome to products</h1>
      <Routes>
        <Route path="/" element={<ProductList/>}/>
        <Route path="/product/:id" element={<ProductDetail/>} />
      </Routes>
    </Router>
  )
}
export default App;