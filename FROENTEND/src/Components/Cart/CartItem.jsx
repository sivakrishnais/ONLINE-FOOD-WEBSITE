import React, { useContext, useEffect, useState } from "react";
import UserContext from "../Context/UserContext";
import "./CartItem.css";
import remove_icon from "../Assets/cart_cross_icon.png";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const CartItem = () => {
  const {
    addToCart,
    removeFromCart,
    cartItems,
    getTotalCartAmount,
    allMenuItems,
    cartDetails,
    setCartCount,
  } = useContext(UserContext);
  const navigate = useNavigate();
  const [checkoutvalues, setCheckoutValues] = useState([]);

  useEffect(() => {
    const updatedMenuArray = allMenuItems.reduce((acc, e) => {
      if (cartItems[e.menuId] > 0) {
        acc.push({ ...e, quantity: cartItems[e.menuId] });
      }
      return acc;
    }, []);
    setCheckoutValues(updatedMenuArray);
  }, [allMenuItems, cartItems]);

  return (
    <div className="cartitems">
      <div className="cartitems-format-main">
        <p>Item</p>
        <p>Name</p>
        <p>Price</p>
        <p>Quantity</p>
        <p>Total</p>
        <p>Remove</p>
      </div>
      <hr />
      {allMenuItems.map((e) => {
        if (cartItems[e.menuId] > 0) {
          return (
            <div key={e.menuId}>
              <div className="cartitems-format cartitems-format-main">
                <img
                  src={e.imagePath}
                  alt=""
                  style={{ height: "60px", width: "60px" }}
                  className="carticon-product-icon"
                />
                <p>{e.itemName}</p>
                <p>
                  <span>&#8377;</span>
                  {e.price}
                </p>
                <button className="cartitems-quantity">
                  {cartItems[e.menuId]}
                </button>
                <p>{e.price * cartItems[e.menuId]}</p>
                <img
                  src={remove_icon}
                  alt="Remove item"
                  onClick={() => {
                    setCartCount((prev) => prev - 1);
                    removeFromCart(e.menuId);
                  }}
                  className="cartitems-remove-icon"
                />
              </div>
            </div>
          );
        }
        return null;
      })}
      <div className="cartitems-down">
        <div className="cartitems-total">
          <h1>Cart Totals</h1>
          <div>
            <div className="cartitems-total-item">
              <p>Subtotal</p>
              <p>&#8377;{getTotalCartAmount()}</p>
            </div>
            <hr />
            <div className="cartitems-total-item">
              <p>Delivery Fee</p>
              <p>Free</p>
            </div>
            <hr />
            <div className="cartitems-total-item">
              <h3>Total</h3>
              <h3>
                <span>&#8377;</span>
                {getTotalCartAmount()}
              </h3>
            </div>
          </div>
          <button
            onClick={() => {
              navigate("/checkout", { state: { checkoutvalues } });
            }}
          >
            PROCEED TO CHECKOUT
          </button>
        </div>
      </div>
    </div>
  );
};

export default CartItem;
