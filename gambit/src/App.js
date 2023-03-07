import React, { Component } from 'react';
import { BrowserRouter as Router, Navigate} from 'react-router-dom';
import DataComponent from './components/dataComponent';
import Login from './components/login';
import Logout from './components/logout'
import RegisterForm from './components/registerForm'
import PublicRoute from './components/route/publicRoute';
import PrivateRoute from './components/route/privateRoute';
import './App.css';;

class App extends Component {
  render() {
    return (
      <Router>
          <PublicRoute element={<Login/>} path='/login' exact/>
          <PublicRoute element={<DataComponent/>} path='/display' exact/>
          <PublicRoute element={<Logout/>} path='/Logout' exact/>  
          <PrivateRoute element={<RegisterForm/>} path='/register' exact />
          <PublicRoute  element={<Navigate replace to="/login" /> } path='' />
      </Router>
    );
  }
}

export default App;
