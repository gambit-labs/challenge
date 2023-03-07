import React, { Component } from 'react'
import Table from './common/table'
import Pagination from './common/pagination'
import { paginate } from '../utils/paginate'

class DisplayResult extends Component {
  state = {
    currentPage: 1,
    pageSize: 8,
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
    const { pageSize, currentPage, columns, sortColumn } = this.state
    const startIndex = (currentPage - 1) * pageSize
    const paginatedData = paginate(readingData, currentPage, pageSize)

    if (!readingData[0]) {
      return (
        <p className="error">
          No data is feched: <br /> Please check your network or access
          credential
        </p>
      )
    } else {
      return (
        <div>
          <Table
            columns={columns}
            paginatedData={paginatedData}
            startIndex={startIndex}
            sortColumn={sortColumn}
          />
          <div className="table">
            <Pagination
              itemsCount={readingData.length}
              pageSize={pageSize}
              currentPage={currentPage}
              onPageChange={this.handlePageChange}
            />
          </div>
        </div>
      )
    }
  }
}

export default DisplayResult
