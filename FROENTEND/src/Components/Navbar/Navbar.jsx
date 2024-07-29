import React, { useContext, useState } from "react";
import "./Navbar.css";
import logo from "../images/foodlogo.jpg";
import cart_icon from "../Assets/cart_icon.png";
import { Link, useNavigate } from "react-router-dom";
import UserContext from "../Context/UserContext";

const Navbar = () => {
  const [menu, setMenu] = useState("home");
  const navigate = useNavigate();
  const { cartCount } = useContext(UserContext);

  return (
    <>
      <div className="container">
        <div className="navbar">
          <div className="nav-logo">
            <img src={logo} alt="Logo" />
            <p>SIVA FOODS</p>
          </div>
          <ul className="nav-menu">
            <li onClick={() => setMenu("home")}>
              <Link to="/home">Home</Link>
              {menu === "home" ? <hr /> : null}
            </li>

            <li onClick={() => setMenu("order-history")}>
              <Link to="/orderhistory">Order History</Link>
              {menu === "order-history" ? <hr /> : null}
            </li>
            <li onClick={() => setMenu("about-us")}>
              <Link to="/about-us">About Us</Link>
              {menu === "about-us" ? <hr /> : null}
            </li>
          </ul>
          <div className="nav-login-cart">
            <Link to="/">
              <button>LoginOut</button>
            </Link>
            <Link to="/cart">
              <img src={cart_icon} alt="Cart Icon" />
            </Link>
            <div className="nav-cart-count">{cartCount}</div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Navbar;
