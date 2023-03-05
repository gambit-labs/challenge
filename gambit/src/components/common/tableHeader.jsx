import React, { Component } from 'react'
class TableHeader extends Component {
  render() {
    const { columns } = this.props
    return (
      <thead className="tableHeader">
        <tr>
          {columns.map((column) => (
            <th className="clickable" key={column.path || column.key}>
              {column.label}
            </th>
          ))}
        </tr>
      </thead>
    )
  }
}

export default TableHeader
