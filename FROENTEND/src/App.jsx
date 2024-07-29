import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { UserProvider } from "./Components/Context/UserContext.jsx";
import Login from "./Components/Login/Login.jsx";
import Home from "./Components/Home/Home.jsx";
import Register from "./Components/Register/Register";
import RestaurantMenu from "./Components/RestaurentMenu/RestaurantMenu.jsx";
import Navbar from "./Components/Navbar/Navbar.jsx";
import CartItem from "./Components/Cart/CartItem.jsx";
import CheckOut from "./Components/CheckOut/CheckOut.jsx";
import Footer from "./Components/Footer/Footer.jsx";
import GreetingToUser from "./Components/Greetings/GreetingToUser.jsx";
import OrderHistory from "./Components/OrderHistory/OrderHistory.jsx";

const App = () => {
  return (
    <UserProvider>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/restaurant/:id" element={<RestaurantMenu />} />
          <Route path="/cart" element={<CartItem />} />
          <Route path="/checkout" element={<CheckOut />}></Route>
          <Route path="/orderhistory" element={<OrderHistory />}></Route>
          <Route path="/greetings" element={<GreetingToUser />}></Route>
        </Routes>
        <Footer />
      </Router>
    </UserProvider>
  );
};

export default App;
