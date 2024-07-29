import React, { useContext, useEffect, useState } from "react";
import UserContext from "../Context/UserContext";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";

const OrderHistory = () => {
  const { user } = useContext(UserContext);
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const resp = await axios.get(
          "http://localhost:8082/FOODDELIVERYPROJECT/history"
        );
        setData(resp.data);
      } catch (error) {
        console.error("Error fetching order history:", error);
      }
    };

    fetchData();
  }, []);

  const filteredData = data.filter((item) => item.userId === user.userId);

  return (
    <div className="container">
      {filteredData.length === 0 ? (
        <h3 className="text-center">
          {" "}
          {user.userName} You have not ordered anything yet.
        </h3>
      ) : (
        <table className="table table-bordered table-dark text-center text-bold">
          <thead>
            <tr>
              <th>Restaurant</th>
              <th>Total Amount</th>
              <th>Order Date</th>
            </tr>
          </thead>
          <tbody>
            {filteredData.map((object, index) => {
              const { restaruentImage, totalAmount, OrderDate } = object;
              return (
                <tr key={index}>
                  <td>
                    <img
                      src={restaruentImage}
                      alt="Restaurant"
                      style={{ height: "50px", width: "50px" }}
                    />
                  </td>
                  <td>{totalAmount}</td>
                  <td>{OrderDate}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default OrderHistory;
