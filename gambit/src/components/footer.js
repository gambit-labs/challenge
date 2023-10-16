import React from 'react'

const Footer = () => {
  return (
    <>
      <link
        rel="stylesheet"
        href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
        crossOrigin="anonymous"
      ></link>
      <p id="copyright">Copyright © ghh@sample Gambit-labs-challenge</p>
      <ul>
        <li>
          <a href="www.facebook.com">
            <i className="fab fa-facebook-f icon"></i>
          </a>
        </li>
        <li>
          <a href="www.twitter.com">
            <i className="fab fa-twitter icon"></i>
          </a>
        </li>
        <li>
          <a href="www.linkedin.com">
            <i className="fab fa-linkedin-in icon"></i>
          </a>
        </li>
        <li>
          <a href="www.google.com">
            <i className="fab fa-google-plus-g icon"></i>
          </a>
        </li>
      </ul>
    </>
  )
}

export default Footer
