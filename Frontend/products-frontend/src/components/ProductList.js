import React, {useEffect, useState} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

function ProductList() {
    const [products,setProducts] = useState([]);

    useEffect(()=>{
        console.log("Fetching");
        axios.get(`http://localhost:8080/api/products`)
        .then(response => {
            console.log("Fetched",response.data);
            setProducts(response.data.data);
        })
        .catch(error => {
            console.error('Error fetching products:',error);
        });
        
    },[]);

    return (
        <div style = {{padding:'20px'}}>
            <h2>All Products</h2>
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