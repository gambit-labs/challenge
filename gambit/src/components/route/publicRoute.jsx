import React from 'react'
import { Route, Routes } from 'react-router-dom'

export default function PublicRoute({ element, path }) {
  return (
    <Routes>
      <Route element={element} path={path} exact />
    </Routes>
  )
}
