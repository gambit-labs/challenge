import React, { Component } from 'react'
import _ from 'lodash'
import { variables } from '../../configs/local'
class TableBody extends Component {
  render() {
    const { paginatedData, startIndex } = this.props
    let index1 = startIndex
    return (
      <tbody>
        {paginatedData.map((value, index) => (
          <tr key={index1}>
            <td>{(index1 = index1 + 1)}</td>
            <td>{value}</td>
            <td>{variables[index1]}</td>
          </tr>
        ))}
      </tbody>
    )
  }
}

export default TableBody
