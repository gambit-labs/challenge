import React, { Component } from 'react'
import { useNavigate } from 'react-router-dom'
import Form from 'react-validation/build/form'
import Input from 'react-validation/build/input'
import CheckButton from 'react-validation/build/button'
import AuthService from '../services/auth.service'
import withParamsAndNavigate from './getNavigate'

import Joi from 'joi-browser'
const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    )
  }
}
function WithNavigate(props) {
  let navigate = useNavigate()
  return <Login {...props} navigate={navigate} />
}
class Login extends React.Component {
  schema = {
    username: Joi.string().required().label('Username'),
    password: Joi.string().required().label('Password'),
  }
  constructor(props) {
    super(props)
    this.handleLogin = this.handleLogin.bind(this)
    this.onChangeUsername = this.onChangeUsername.bind(this)
    this.onChangePassword = this.onChangePassword.bind(this)

    this.state = {
      username: '',
      password: '',
      loading: false,
      message: '',
    }
  }

  onChangeUsername(e) {
    this.setState({
      username: e.target.value,
    })
  }

  onChangePassword(e) {
    this.setState({
      password: e.target.value,
    })
  }
  validate = () => {
    const options = { abortEarly: false }
    const { error } = Joi.validate(this.state.data, this.schema, options)
    if (!error) return null

    const errors = {}
    for (let item of error.details) errors[item.path[0]] = item.message
    return errors
  }

  validateProperty = ({ name, value }) => {
    const obj = { [name]: value }
    const schema = { [name]: this.schema[name] }
    const { error } = Joi.validate(obj, schema)
    return error ? error.details[0].message : null
  }

  handleLogin = (e) => {
    e.preventDefault()

    this.setState({
      message: '',
      loading: true,
    })

    this.validate()
    if (this.checkBtn.context._errors.length === 0) {
      console.log('came here on login....')
      const auth = AuthService.login(this.state.username, this.state.password)
      if (auth) {
        this.props.navigate('/display')
        window.location.reload()
      } else {
        const resMessage = 'Invalide credential username or password'

        this.setState({
          loading: false,
          message: resMessage,
        })
      }
    } else {
      this.setState({
        loading: false,
      })
    }
  }

  render() {
    return (
      <div className="login">
        <h1>Login</h1>
        <Form
          onSubmit={this.handleLogin}
          ref={(c) => {
            this.form = c
          }}
        >
          <label htmlFor="username">Username</label>
          <Input
            type="text"
            className="form-control"
            name="username"
            value={this.state.username}
            onChange={this.onChangeUsername}
            validations={[required]}
          />

          <label htmlFor="password">Password</label>
          <Input
            type="password"
            className="form-control"
            name="password"
            value={this.state.password}
            onChange={this.onChangePassword}
            validations={[required]}
          />
          <button
            className="btn btn-primary btn-block"
            disabled={this.state.loading}
          >
            {this.state.loading && (
              <span className="spinner-border spinner-border-sm"></span>
            )}
            <span>Login</span>
          </button>

          {this.state.message && (
            <div className="form-group">
              <div className="alert alert-danger" role="alert">
                {this.state.message}
              </div>
            </div>
          )}
          <CheckButton
            style={{ display: 'none' }}
            ref={(c) => {
              this.checkBtn = c
            }}
          />
        </Form>
      </div>
    )
  }
}

export default withParamsAndNavigate(Login)
