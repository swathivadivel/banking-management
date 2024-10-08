import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/customers";

export const listCustomers = () => axios.get(REST_API_BASE_URL);

export const addCustomer = (customer) => axios.post(REST_API_BASE_URL, customer);

export const updateCustomer =(id,customer) => axios.put(REST_API_BASE_URL + '/' + id, customer);