import React from 'react'
import Joi from 'joi-browser'
import Form from './common/form'
import auth from '../services/auth.service'

class LoginForm extends Form {
  state = {
    data: { username: '', password: '' },
    errors: {},
  }

  schema = {
    username: Joi.string().required().label('Username'),
    password: Joi.string().required().label('Password'),
  }

  render() {
    return (
      <div className="login">
        <h1>Login</h1>
        <form onSubmit={this.handleSubmit}>
          {this.renderInput('username', 'Username')}
          {this.renderInput('password', 'Password', 'password')}
          {this.renderButton('Login')}
        </form>
      </div>
    )
  }
}

export default LoginForm
