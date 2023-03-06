import jwtDecode from "jwt-decode";
import { users } from "../mockData/users";
const tokenKey = "token";

export function login(username, password) {
  if((users.some(a=>a.username===username)) && (users.some(a=>a.password===password))){
    localStorage.setItem(tokenKey, [username,password])
    return true
  }
  else{
    return false
  }
}

export function logout() {
  localStorage.removeItem(tokenKey);
  return null
}

export function getCurrentUser() {
  try {
    const jwt = localStorage.getItem(tokenKey);
    return jwtDecode(jwt);
  } catch (ex) {
    return null;
  }
}

export default {
  login,
  logout,
  getCurrentUser
};
