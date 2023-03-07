import React from 'react'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Joi from 'joi-browser'
import Form from 'react-validation/build/form'
import Input from 'react-validation/build/input'
import CheckButton from 'react-validation/build/button'
import AuthService from '../services/auth.service'
import HeaderPage from './common/headerPage'
import Footer from './footer'
const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    )
  }
}
const Login = () => {
  const [username, setUsername] = useState({ username: '' })
  const [password, setPassword] = useState({ password: '' })
  const [loading, setLoading] = useState({ loading: false })
  const [message, setMessage] = useState()

  const navigate = useNavigate()
  const schema = {
    username: Joi.string().required().label('Username'),
    password: Joi.string().required().label('Password'),
  }

  const onChangeUsername = (e) => {
    setUsername({
      username: e.target.value,
    })
  }

  const onChangePassword = (e) => {
    setPassword({
      password: e.target.value,
    })
  }
  const validate = () => {
    const options = { abortEarly: false }
    const { error } = Joi.validate([username, password], schema, options)
    if (!error) return null

    const errors = {}
    for (let item of error.details) errors[item.path[0]] = item.message
    return errors
  }

  const handleLogin = (e) => {
    e.preventDefault()

    setMessage({ message: '' })
    setLoading({ loading: true })

    validate()
    console.log('came here on login....')
    const auth = AuthService.login(username.username, password.password)
    console.log('auth', auth)
    if (auth) {
      navigate('/display')
      //window.location.reload()
    } else {
      const resMessage = 'Invalide credential username or password'

      setMessage({ message: resMessage })
      setLoading({ loading: false })
    }
  }

  return (
    <div>
      <HeaderPage />
      <div className="login">
        <h1>Login</h1>
        <Form onSubmit={handleLogin}>
          <label htmlFor="username">Username</label>
          <Input
            type="text"
            className="form-control"
            name="username"
            value={username.username}
            onChange={onChangeUsername}
            validations={[required]}
          />

          <label htmlFor="password">Password</label>
          <Input
            type="password"
            className="form-control"
            name="password"
            value={password.password}
            onChange={onChangePassword}
            validations={[required]}
          />
          <button
            className="btn btn-primary btn-block"
            disabled={loading.loading}
          >
            {loading.loading && (
              <span className="spinner-border spinner-border-sm"></span>
            )}
            <span>Login</span>
          </button>

          {message && (
            <div className="form-group">
              <div className="alert alert-danger" role="alert">
                {message.message}
              </div>
            </div>
          )}
        </Form>
      </div>
      <footer className="footer">
        <Footer />
      </footer>
    </div>
  )
}

export default Login
