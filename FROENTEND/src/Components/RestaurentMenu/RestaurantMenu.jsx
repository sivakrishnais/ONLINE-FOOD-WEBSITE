import React, { useEffect, useState, useContext } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import UserContext from "../Context/UserContext";

const RestaurantMenu = () => {
  const { id } = useParams(); // Extract the restaurant ID from the URL parameters
  const [restaurant, setRestaurant] = useState("");
  const [menus, setMenus] = useState([]);
  const navigate = useNavigate();
  const { setAllMenuItems, addToCart, setRestaurentId, setCartCount } =
    useContext(UserContext);

  useEffect(() => {
    const fetchRestaurant = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8082/FOODDELIVERYPROJECT/Restaurent"
        );
        const restaurantData = response.data.find(
          (restaurant) => restaurant.restaurantId === parseInt(id)
        );
        setRestaurant(restaurantData);
        setRestaurentId(id);
      } catch (error) {
        console.error("Error fetching restaurant data:", error);
      }
    };

    const fetchMenu = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8082/FOODDELIVERYPROJECT/Menu"
        );
        setAllMenuItems(response.data);
        const menuData = response.data.filter(
          (menu) => menu.restaurantId === parseInt(id)
        );
        setMenus(menuData);
      } catch (error) {
        console.error("Error fetching menu data:", error);
      }
    };

    fetchRestaurant();
    fetchMenu();
  }, [id]);

  const handleAddToCart = (menuId) => {
    // Handle add to cart functionality
    addToCart(menuId);
  };

  return (
    <div>
      <div className="container mt-5 restaurent-menu-container">
        <div className="row">
          <div className="col-md-6 restaurent-menu-image">
            <img
              src={restaurant.imagePath}
              alt={restaurant.name}
              className="img-fluid rounded"
            />
          </div>
          <div className="col-md-6 d-flex flex-column justify-content-center">
            <h3 className="font-weight-bold restaurent-menu-name">
              {restaurant.name}
            </h3>
            <p className="restaurent-menu-cuisineType">
              {restaurant.cuisineType}
            </p>
            <p className="restaurent-menu-address">{restaurant.address}</p>
            <p className="text-muted">
              <span className="text-warning restaurent-menu-icon">&#9733;</span>{" "}
              Rating: {restaurant.rating} | Delivery Time:{" "}
              {restaurant.deliveryTimel} mins
            </p>
          </div>
        </div>
      </div>
      <div className="container mt-5">
        <div className="menu-header mb-4">
          <h1>Menu Of Above Restaurant</h1>
        </div>
        <div className="row ">
          {menus.map((menu) => (
            <div className="col-md-3 mb-4 " key={menu.menuId}>
              <div className="card h-100">
                <img
                  src={menu.imagePath}
                  className="card-img-top"
                  alt={menu.itemName}
                  style={{
                    objectFit: "cover", // Ensures the image covers the card size
                    height: "200px", // Set a fixed height if needed
                  }}
                />
                <div className="card-body ">
                  <h5 className="card-title">{menu.itemName}</h5>
                  <p className="card-text">{menu.description}</p>
                  <p className="card-text">Price: ₹{menu.price}</p>
                  <button
                    className="btn btn-primary"
                    onClickCapture={() => setCartCount((prev) => prev + 1)}
                    onClick={() => handleAddToCart(menu.menuId)}
                  >
                    Add to Cart
                  </button>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default RestaurantMenu;
