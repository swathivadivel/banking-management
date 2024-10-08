
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import ListCustomer from './Components/ListCustomer'
import AddCustomerComponent from './Components/AddCustomerComponent.jsx'
import UpdateCustomerComponent from './Components/UpdateCustomerComponent.jsx'

function App() {


  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route path='/' element={ <ListCustomer /> }></Route>
      <Route path='/customers' element={ <ListCustomer /> }></Route>
      <Route path='/add-customer' element={ <AddCustomerComponent /> }></Route>
      <Route path='/edit-customer/:id' element={ <UpdateCustomerComponent /> }></Route>

    </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
