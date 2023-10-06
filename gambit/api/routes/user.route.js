 const { authJwt } = require("../middleware");
const controller = require("../controllers/user.controller");

module.exports = function (app) {
  app.use(function (req, res, next) {
    res.header(
      "Access-Control-Allow-Headers", "x-session",
      "x-access-token, Origin, Content-Type, Accept"
    );
    next();
  });
  app.get("/api/getUsers", [authJwt.verifyToken], controller.getUsers);
  app.get("/api/getUser/:id", [authJwt.verifyToken], controller.getUser);

  app.post("/api/updateUser", [authJwt.verifyToken], controller.updateUser);
  app.post("/api/addUser", [authJwt.verifyToken], controller.addUser);
  app.post("/api/deleteUser", [authJwt.verifyToken], controller.deleteUser);
};
 