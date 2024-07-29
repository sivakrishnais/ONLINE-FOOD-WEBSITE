import React, { useContext, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import UserContext from "../Context/UserContext";
import "./CheckOut.css"; // Assuming you create a CSS file for styling
import axios from "axios";

const Checkout = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { getTotalCartAmount, restaurentId, user } = useContext(UserContext);

  console.log("user Detail: ", user);
  const { checkoutvalues } = location.state || [];

  const [userDetails, setUserDetails] = useState({
    address: "",
    paymentMethod: "UPI",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserDetails((prevDetails) => ({
      ...prevDetails,
      [name]: value,
    }));
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    const checkoutDetails = {
      userId: user.userId,
      restaurantId: Number(restaurentId),
      address: userDetails.address,
      paymentMethod: userDetails.paymentMethod,
      totalAmount: getTotalCartAmount(),
      menuArray: checkoutvalues,
    };

    console.log("Checkout Details:", checkoutDetails);

    // Make a POST request to the servlet
    axios
      .post(
        "http://localhost:8082/FOODDELIVERYPROJECT/Checkout", // Corrected URL
        checkoutDetails,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((response) => {
        // Handle success
        console.log(response.data);
        navigate("/greetings"); // Navigate to an order confirmation page
      })
      .catch((error) => {
        // Handle error
        console.error("There was an error!", error);
      });
  };

  return (
    <div className="checkout-container">
      <h1>Checkout</h1>
      <form onSubmit={handleSubmit} className="checkout-form">
        <div className="form-group">
          <label htmlFor="address">Address</label>
          <input
            type="text"
            id="address"
            name="address"
            value={userDetails.address}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="paymentMethod">Payment Method</label>
          <select
            id="paymentMethod"
            name="paymentMethod"
            value={userDetails.paymentMethod}
            onChange={handleChange}
            required
          >
            <option value="UPI">UPI</option>
            <option value="COD">Cash on Delivery (COD)</option>
            <option value="debit card">Debit Card</option>
            <option value="credit card">Credit Card</option>
          </select>
        </div>
        <div className="form-group">
          <p>Total Amount: &#8377;{getTotalCartAmount()}</p>
        </div>
        <button type="submit" className="checkout-button">
          Place Order
        </button>
      </form>
    </div>
  );
};

export default Checkout;
