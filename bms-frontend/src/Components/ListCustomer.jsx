
import React, { useEffect, useState } from 'react'
import { listCustomers } from '../Services/CustomerServices';
import { useNavigate } from 'react-router-dom';

const ListCustomer = () => {

    const [customers, setCustomers] = useState([]);  // State to hold customers data
    const navigate = useNavigate();

    // useEffect to fetch customers data on component mount
    useEffect(() => {
        listCustomers().then((response) => {
            console.log(response.data);
            setCustomers(response.data);  // Store the customer data in state
        }).catch(error => {
            console.error(error);  // Handle error
        })
    }, []);  // Empty array to ensure this only runs once on mount

    function handleAddCustomer(){
        navigate('/add-customer');
    }

    function handleUpdateCustomer(){
        navigator(`/edit-customer/$id`);
    }

    function handleDeleteCustomer(){
        navigate('/edit-customer');
    }


  return (
    <div className='container-fluid'>
        <h2 className='text-center'>List of Customers</h2>
        <br />
        <button className='btn btn-info mb-3 ms-3' onClick={handleAddCustomer} >Add Customer</button>
        <br />
        <div className='row'>
            <div className='col'>
                    <table className="table table-striped table-bordered w-100%">
                    <thead>
                    <tr>
                    <th>Customer Id</th>
                    <th>Customer Name</th>
                    <th>Customer Email</th>
                    <th>Actions</th>
                    </tr>    
                </thead>
                <tbody>
                   {customers.map(customer =>(
                    <tr key={customer.customerId}>
                        <td>{customer.customerId}</td>
                        <td>{customer.customerName}</td>
                        <td>{customer.email}</td>
                        <td>
                        <button className='btn btn-info' onClick={handleUpdateCustomer}>Update</button>
                        <button className='btn btn-danger' onClick={handleDeleteCustomer} style={{marginLeft:'10px'}}>Delete</button>
                        </td>
                    </tr>
                   ))}
                </tbody>
            </table>
            </div>
        </div>


    </div>
  )
}

export default ListCustomer