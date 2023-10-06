//const { verifySignUp } = require("../middleware");
const controller = require("../controllers/auth.controller");

module.exports = function (app) {
    console.log('AUTH ROUTES......')
    app.use(function (req, res, next) {
        next();
    });
    app.post("/api/auth/signin", controller.signin);
    app.post("/api/auth/authenticateUser", controller.authenticateUser);
};