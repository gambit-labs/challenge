import React, { Component } from 'react';
import { BrowserRouter as Router, Navigate} from 'react-router-dom';
import DataComponent from './components/dataComponent';
import Login from './components/login';
import Logout from './components/logout'
import PublicRoute from './components/route/publicRoute';
import './App.css';;

class App extends Component {
  render() {
    return (
      <Router>
          <PublicRoute element={<Login/>} path='/login' exact/>
          <PublicRoute element={<DataComponent/>} path='/display' exact/>
          <PublicRoute element={<Logout/>} path='/Logout' exact/>  
          <PublicRoute  element={<Navigate replace to="/login" /> } path='' />
      </Router>
    );
  }
}

export default App;
