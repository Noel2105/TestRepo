import React, {useEffect, useState} from 'react'
import axios from 'axios'
import { useParams, Link } from 'react-router-dom'

function ProductDetail() {
    const {id} = useParams();
    const [product, setProduct] = useState(null);

    useEffect(()=>{
        axios.get(`http://localhost:8080/api/products/${id}`)
        .then(response=>{
            setProduct(response.data.data);
        })
        .catch(error=>{
            console.error('Error fetching product:',error);
        });
    },[id]);

    if(!product) return <p>Loading....</p> 

    return (
        <div style={{padding:'20px'}}>
            <h2>{product.name}</h2>
            <p><strong>Price:</strong>{product.cost}</p>
            <p><strong>Category:</strong>{product.category}</p>
            <p><strong>Brand:</strong>{product.brand}</p>
            <p><strong>Retail Price:</strong>{product.retailPrice}</p>
            
            <Link to="/">Back to product List</Link>

        </div>
    );
}
export default ProductDetail;