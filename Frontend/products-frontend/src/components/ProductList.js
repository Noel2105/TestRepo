import React, {useEffect, useState} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

function ProductList() {
    const [products, setProducts] = useState([]);
    const [pageNumber, setPageNumber] = useState(0);
    const [pageSize, setPageSize] = useState(30);

    useEffect(() => {
        axios.get(`http://localhost:8080/api/products/page/${pageNumber}/${pageSize}`)
        .then(response => {
            setProducts(response.data.data.content);
        })
        .catch(error => {
            console.error('Error fetching products:', error);
        });
    }, [pageNumber, pageSize]);

    return (
        <div style={{padding:'20px'}}>
            <h2>All Products</h2>
            <div style={{marginBottom: '16px'}}>
                <button 
                    onClick={() => setPageNumber(prev => Math.max(prev - 1, 0))}
                    disabled={pageNumber === 0}
                >
                    Previous
                </button>
                <span style={{margin: '0 10px'}}>Page {pageNumber}</span>
                <button onClick={() => setPageNumber(prev => prev + 1)}>
                    Next
                </button>
            </div>
            <div style={{display:'flex', flexWrap:'wrap', gap:'20px'}}>
                {products.map(product => (
                    <div key={product.id} style={{
                        border:'1px solid #ccc',
                        borderRadius:'8px',
                        padding:'16px',
                        width:'200px'
                    }}>
                        <h4>{product.name}</h4>
                        <p>Cost:{product.cost}</p>
                        <Link to={`/product/${product.id}`}>
                            View Details
                        </Link>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default ProductList;