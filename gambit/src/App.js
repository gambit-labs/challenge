import React, { Component } from 'react';
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';
import GetData from './components/getData';
import Login from './components/login';
import Logout from './components/logout';
import './App.css';

class App extends Component {
  render() {
    return (
      <Router>
        <Routes>
          <Route element={<Login/>} path='/login' exact/>
          <Route element={<Login/>} path='/' exact/>
          <Route element={<GetData/>} path='/display' exact/>
          <Route element={<Logout/>} path='/Logout' exact/> 
        </Routes>
      </Router>
    );
  }
}

export default App;
