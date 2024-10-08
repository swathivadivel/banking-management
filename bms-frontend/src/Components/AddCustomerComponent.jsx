
import React, { useState } from 'react'
import { addCustomer } from '../Services/CustomerServices';
import { useNavigate } from 'react-router-dom';

const AddCustomerComponent = () => {

  const[customerName, setCustomerName] = useState('')
  const[email, setEmail] = useState('')
 
  

  const navigator = useNavigate()

  function handleCustomerName(e){
    setCustomerName(e.target.value);
  }

  function handleEmail(e){
    setEmail(e.target.value);
    }

  function handleSaveCustomer(e){

    e.preventDefault();

    const customer = {customerName,email};

    addCustomer(customer).then(response =>{
      console.log(customer);
      navigator('/customers')
    }).catch(error =>{
      console.error(error);
    })

    }

    return (
      <div className='container'>
        <div className='card' style={{width:'30rem ',height:'20rem'}}>
          <div className='card-body mb-5'>
            <h2 className='card-title' style={{textAlign:'center'}}>Add Customer Component</h2>
          <form>
          <div className='form-group'> 
          <label className='form-label'>Name:</label>
          <input className='form-control mb-3'
                  type='text'
                 placeholder='Enter your Name'
                 value={customerName}
                 onChange={handleCustomerName} />
          </div>
  
          <div className='form-group'>
          <label className='form-label'>Email:</label>
          <input className='form-control mb-4' 
                  type='text'
                 placeholder='Enter your Email'
                 value={email}
                 onChange={handleEmail} />
          </div>
  
          <button className='btn btn-primary' onClick={handleSaveCustomer}>Add Customer</button>
        </form>
        </div>
        </div>
      </div>
    )
  }
  
  export default AddCustomerComponent

  


 