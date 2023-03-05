import { useEffect, useState } from "react";
import Footer from "./components/footer";
import DisplayResult from "./components/displayResult";
import SearchBox from "./components/common/searchBox";
import LoginForm from "./components/loginForm";
import { getCurrentUser } from "./services/auth.service";
import "./App.css";
const App = () => {

  const [data, setData] = useState([]);
  const [dataContent, setDataContent] = useState([]);
  const dataObj = {};
   
  const fetchData = () => {
    let corsAnywhere = "https://cors-anywhere.herokuapp.com/";
    let gambitlabs = "http://tuftuf.gambitlabs.fi/feed.txt";
    fetch(corsAnywhere + gambitlabs)
      .then((response) => response.text())
      .then((result) => {
        const theDataArr = result.replace(/\n/g, " ");
        const array = theDataArr.split(" ");
        setData(array);
      });
  };

  useEffect(() => {   
    fetchData();
    data.forEach((val) => {
      var key = val.split(":")[0];
      var value = val.split(":")[1];
      dataObj[key] = value;
    });
    const k = Object.values(dataObj);
    setDataContent(k);
  
  }, [data]);

   return (
console.log(dataContent)
  )
}


export default App;
