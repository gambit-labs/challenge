const verifyToken = (req, res, next) => {
    console.log('Came on verify token....')
    next();
};

const authJwt = {
    verifyToken: verifyToken
};
module.exports = authJwt;