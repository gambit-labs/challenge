
const _=require('lodash')
const signin = (req, res) => {
const DbConnection=require('../db')
  console.log('REQUEST.......',req.body)
  var connection=DbConnection
  if(!connection._connectCalled ){
    connection.connect();
  }
  const sql="SELECT * from  users where username=? AND password=?"
    connection.query(sql,[req.body.username,req.body.password],(err,rows)=>{
      if(err){
          throw err
      }else {
        if(!_.isEmpty(rows)){
          console.log('data sent...',rows[0].name,rows.role)
          res.status(200).send({username:rows[0].username,role:rows[0].role,id:rows[0].id,userId:rows[0].userId});
        }
        else res.status(400).send({ message:'Invalid credentials! Try again' });
      }
    })
};

const authenticateUser = async (req,res) =>{  
    res.status(404).send({message:'message' || 'User not authenticated.'});
}
module.exports= {signin, authenticateUser}
   
