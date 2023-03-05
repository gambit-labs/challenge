import React, { Component } from 'react'
import Table from './common/table'

class DisplayResult extends Component {
  state = {
    sortColumn: { path: 'index', order: 'asc' },

    columns: [
      { path: 'index', label: 'REGISTER INDEX' },
      { path: 'value', label: 'READING VALUE' },
      { path: 'name', label: 'VARIABLE NAME' },
    ],
  }
  handlePageChange = (page) => {
    this.setState({ currentPage: page })
  }

  render() {
    const { readingData } = this.props
    const { columns, sortColumn } = this.state

    if (readingData.length === 0)
      return <p>There are no reading in the database.</p>

    return (
      <div>
        <Table
          columns={columns}
          paginatedData={readingData}
          sortColumn={sortColumn}
        />
      </div>
    )
  }
}

export default DisplayResult
