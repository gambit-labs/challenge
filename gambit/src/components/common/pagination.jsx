import React from 'react'
import PropTypes from 'prop-types'
import _ from 'lodash'

const Pagination = (props) => {
  const { itemsCount, pageSize, currentPage, onPageChange } = props
  const pageCount = Math.ceil(itemsCount / pageSize)
  if (pageCount === 1) return null
  const pages = _.range(1, pageCount + 1)

  return (
    <div className="pagination">
      <nav aria-label="navigation">
        <ul className="pagination">
          {pages.map((page) => (
            <li
              key={page}
              className={
                currentPage === page ? 'page-item active' : 'page-item'
              }
            >
              <a
                href="#"
                className="page-link"
                onClick={() => onPageChange(page)}
              >
                {page}
              </a>
            </li>
          ))}
        </ul>
      </nav>
    </div>
  )
}
Pagination.propTypes = {
  itemsCount: PropTypes.number.isRequired,
  pageSize: PropTypes.number.isRequired,
  currentPage: PropTypes.number.isRequired,
  onPageChange: PropTypes.func.isRequired,
}

export default Pagination
