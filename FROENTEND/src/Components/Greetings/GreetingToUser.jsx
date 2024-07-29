import React, { useContext } from "react";
import UserContext from "../Context/UserContext";
import "./GreetingToUser.css"; // Import the CSS file

const GreetingToUser = () => {
  const { user } = useContext(UserContext);

  return (
    <div className="greeting">
      <h2>Hello, {user.userName}!</h2>

      <div className="order-confirmation">
        <h3>Thank you for your order!</h3>
        <p>
          Your order has been successfully placed. We are preparing your meal
          and it will be delivered to you shortly.
        </p>
        <p>
          If you have any questions or need further assistance, please don't
          hesitate to contact our support team.
        </p>
      </div>
    </div>
  );
};

export default GreetingToUser;
