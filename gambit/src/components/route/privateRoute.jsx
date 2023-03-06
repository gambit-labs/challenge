import React from 'react'
import { Route, Navigate, Routes } from 'react-router-dom'
import { getCurrentUser } from './../../services/auth.service'

const useAuth = () => {
  const user = localStorage.getItem('user')
  console.log('user........private', user)
  if (user) {
    return true
  } else {
    return false
  }
}
function PrivateRoute({ element: Component, ...rest }) {
  const auth = useAuth()
  console.log('auth...', auth)

  return (
    <Routes>
      <Route
        render={() =>
          auth ? (
            <div>
              {getCurrentUser().role == 1 && <></>}
              <Component {...rest} />
            </div>
          ) : (
            { component: () => <Navigate to="/login" /> }
          )
        }
      />
    </Routes>
  )
}
export default PrivateRoute
