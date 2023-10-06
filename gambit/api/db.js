
const mysql=require('mysql')
const {host,user,password,database,port}=require('../src/configs/local')
console.log('DB CONNECTION........')
 const DbConnection=mysql.createConnection({host,user,password,database,port})
module.exports=DbConnection

