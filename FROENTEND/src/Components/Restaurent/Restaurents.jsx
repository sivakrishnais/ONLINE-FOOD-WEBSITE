import React, { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "./Restaurent.css";
import UserContext from "../Context/UserContext";

const Restaurants = () => {
  const [restaurants, setRestaurants] = useState([]);
  const { setAllResstaurents } = useContext(UserContext);
  useEffect(() => {
    fetch("http://localhost:8082/FOODDELIVERYPROJECT/Restaurent")
      .then((response) => response.json())
      .then((data) => {
        setAllResstaurents(data);
        setRestaurants(data);
      })
      .catch((error) => {
        console.error("Error fetching restaurant data:", error);
      });
  }, []);

  // Render restaurant cards
  const renderRestaurantCards = (restaurants) => {
    return restaurants.map((restaurant) => (
      <div className="restaurant-card" key={restaurant.restaurantId}>
        <Link to={`/restaurant/${restaurant.restaurantId}`}>
          <div
            className={`restaurant-image ${
              restaurant.isActive ? "" : "inactive"
            }`}
          >
            <img src={restaurant.imagePath} alt={restaurant.name} />
            {!restaurant.isActive && (
              <div className="inactive-overlay">Not Active</div>
            )}
          </div>
        </Link>
        <div className="restaurant-details">
          <h3>{restaurant.name}</h3>
          <p>{restaurant.cuisineType}</p>
          <p>{restaurant.address}</p>
          <p className="rating-and-delivery">
            <span className="gold-star">&#9733;</span>
            Rating: {restaurant.rating}
            <p> Delivery Time:{restaurant.deliverTimel}mins</p>
          </p>
        </div>
      </div>
    ));
  };

  return (
    <div className="restaurants-page">
      <div className="popular-restaurants">
        <h2>Popular Restaurants in Vijayawada</h2>
        <div className="restaurant-list">
          {restaurants.length > 0 ? (
            renderRestaurantCards(restaurants.slice(0, 4))
          ) : (
            <p>Loading...</p>
          )}
        </div>
      </div>
      <div className="all-restaurants">
        <h2>All Restaurants</h2>
        <div className="restaurant-list">
          {restaurants.length > 0 ? (
            renderRestaurantCards(restaurants.slice(4, 16))
          ) : (
            <p>Loading...</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Restaurants;
