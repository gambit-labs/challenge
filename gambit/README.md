
# Create UI for showing the data for user
This project is a code challenge task named ad Gambit-challenge 
The folling are scripts and links how to operate it.
## Technology
### Frontend: React with JavaScript
All the compontes, configs services utils for the task is bulid using react with JavaScrip to display the TUF-2000M energy meter reading.  
### Backend: nodejs
The 'api' folder hold the nodjs files for authentication user login. User information is saved in MySql. Controllers, middleware, routes are defined 
### mysql database
Users info(username, password, name ...) are saved in MySql.

How to run the app
1. npm start  form the src
Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.
2. node server.js
3. open Mysql and put sample data
for creating users Table in demodb database
CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` int NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `city` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4681 DEFAULT CHARSET=utf8mb3;
SELECT * FROM demodb.users;

### Version control: git
used for version control and communicate with gitHub

## Getting Started with Create React App
Run the script in windows explorer or set the security of your browser
For test the project you can see the local saved password in 

In the project directory, you can run:
../mockData/users.jsx # temporary username and password are saved there.

N.b: this project is not build 
### `npm run build`
Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

About development [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**



