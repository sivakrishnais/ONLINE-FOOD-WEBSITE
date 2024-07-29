import React from "react";
import "./Home.css";

import { useContext } from "react";
import Navbar from "../Navbar/Navbar";
import UserContext from "../Context/UserContext";
import Restaurants from "../Restaurent/Restaurents";
import GreetingToUser from "../Greetings/GreetingToUser";

const categories = [
  {
    label: "biryani",
    imgSrc:
      "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1675667625/PC_Creative%20refresh/Biryani_2.png",
    alt: "restaurants curated for biryani",
  },
  {
    label: "chinese",
    imgSrc:
      "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029848/PC_Creative%20refresh/3D_bau/banners_new/Chinese.png",
    alt: "restaurant curated for chinese",
  },
  {
    label: "pizza",
    imgSrc:
      "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029856/PC_Creative%20refresh/3D_bau/banners_new/Pizza.png",
    alt: "restaurants curated for pizza",
  },
  {
    label: "idly",
    imgSrc:
      "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029846/PC_Creative%20refresh/3D_bau/banners_new/Idli.png",
    alt: "restaurants curated for idly",
  },
  {
    label: "burger",
    imgSrc:
      "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029845/PC_Creative%20refresh/3D_bau/banners_new/Burger.png",
    alt: "restaurants curated for burger",
  },
  {
    label: "north indian",
    imgSrc:
      "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1675667625/PC_Creative%20refresh/North_Indian_4.png",
    alt: "restaurants curated for north indian",
  },
  {
    label: "noodles",
    imgSrc:
      "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029855/PC_Creative%20refresh/3D_bau/banners_new/Noodles.png",
    alt: "restaurant curated for noodles",
  },
];

const Home = (props) => {
  const { user } = useContext(UserContext);
  console.log("home details information" + user);

  return (
    <div>
      <div className="hero-container">
        <div className="hero-header">
          <h2 className="title">
            What's on your mind?
            <span className="username">{user.userName}</span>
          </h2>
        </div>
        <div className="hero-categories">
          <div className="row">
            {categories.map((category, index) => (
              <div className="category" key={index}>
                <a
                  aria-label={`restaurants curated for ${category.label}`}
                  className="category-link"
                >
                  <div className="category-image-wrapper">
                    <img
                      className="category-image"
                      src={category.imgSrc}
                      alt={category.alt}
                    />
                  </div>
                </a>
              </div>
            ))}
          </div>
        </div>
      </div>
      <Restaurants />
    </div>
  );
};

export default Home;
