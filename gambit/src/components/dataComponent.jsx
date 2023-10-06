import { useEffect, useState } from 'react'
import axios from 'axios'
import Footer from './footer'
import DisplayResult from './displayResult'
import SearchBox from './common/searchBox'
import { apiUrl, corsUrl } from '../configs/config.json'
import '../assets/styles/styles.css'

const DataComponent = () => {
  const [data, setData] = useState([])
  const [dataContent, setDataContent] = useState([])
  const [searchquery, setSearchquery] = useState()
  const [loadingError, setLoadingError] = useState(false)
  const dataObj = {}

  const fetchData = () => {
    axios
      .get(corsUrl + apiUrl)
      .then((response) => response.text())
      .then((result) => {
        const theDataArr = result.replace(/\n/g, ' ')
        const array = theDataArr.split(' ')
        setData(array)
      })
      .catch((error) => {
        switch (error.response.status) {
          case 403:
            setLoadingError(true)
            console.log(error.message)
          default:
            break
        }
      })
  }

  useEffect(() => {
    fetchData()
    data.forEach((val) => {
      var key = val.split(':')[0]
      var value = val.split(':')[1]
      dataObj[key] = value
    })
    const k = Object.values(dataObj)
    setDataContent(k)
  }, [data, searchquery])

  return (
    <div>
      <header className="header">
        <div>
          <h1 className="logo">TUF-2000M Registers</h1>
        </div>
        <div className="searchBox">
          <SearchBox
            value={searchquery}
            onChange={(e) => setSearchquery(e.target.value)}
          />
        </div>
        <div>
          <p>
            Registery Date:{' '}
            <span className="registryTime">{`${data[0]} ${data[1]} `}</span>
          </p>
        </div>
      </header>
      <main className="main">
        <DisplayResult readingData={dataContent} searchquery={searchquery} />
      </main>
      <footer className="footer">
        <Footer />
      </footer>
    </div>
  )
}

export default DataComponent
