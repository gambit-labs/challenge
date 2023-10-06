import React from 'react'
import TableHeader from './tableHeader'
import TableBody from './tableBody'

const Table = ({ paginatedData, columns, startIndex = 1 }) => {
  return (
    <table className="table">
      <TableHeader columns={columns} />
      <TableBody
        paginatedData={paginatedData}
        columns={columns}
        startIndex={startIndex}
      />
    </table>
  )
}

export default Table
