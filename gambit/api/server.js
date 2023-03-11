const express=require('express')
const cors = require("cors");
const port=process.env.PORT || 8080;
const app=express()
const bodyParser = require("body-parser");
app.use(cors({origin: 'http://localhost:3000'}));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
require("./routes/auth.routes")(app);
require("./routes/user.route")(app);

app.listen(port)
console.log('App listening on port '+port)

