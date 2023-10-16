import React from 'react'
const SearchBox = ({
  value,
  onChange,
  type = 'text',
  name = 'query',
  placeholder = 'Search using index',
}) => {
  return (
    <input
      type={type}
      name={name}
      placeholder={placeholder}
      value={value}
      onChange={(e) => onChange(e.currentTarget.value)}
      className="form-control my-3"
    />
  )
}

export default SearchBox
