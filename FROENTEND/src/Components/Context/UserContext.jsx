import React, { createContext, useState, useEffect } from "react";

const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState({});
  const [allResaturents, setAllResstaurents] = useState([]);
  const [allMenuItems, setAllMenuItems] = useState([]);
  const [cartItems, setCartItems] = useState({});
  const [restaurentId, setRestaurentId] = useState("");
  const [cartCount, setCartCount] = useState(0);
  useEffect(() => {
    const getDefaultCart = () => {
      let cart = {};
      allMenuItems.forEach((item) => {
        cart[item.menuId] = 0;
      });
      return cart;
    };

    setCartItems(getDefaultCart());
  }, [allMenuItems]);

  const addToCart = (itemId) => {
    setCartItems((prev) => ({
      ...prev,
      [itemId]: (prev[itemId] || 0) + 1,
    }));
  };
  const removeFromCart = (itemId) => {
    setCartItems((prev) => ({
      ...prev,
      [itemId]: prev[itemId] - 1,
    }));
  };
  const getTotalCartAmount = () => {
    let totalAmount = 0;
    for (let item in cartItems) {
      if (cartItems[item] > 0) {
        let itemInfo = allMenuItems.find(
          (product) => product.menuId === Number(item)
        );
        if (itemInfo) {
          totalAmount += itemInfo.price * cartItems[item];
        }
      }
    }
    return totalAmount;
  };
  useEffect(() => {
    console.log(cartItems); // Logs the updated cartItems state
  }, [cartItems]);

  return (
    <UserContext.Provider
      value={{
        user,
        setUser,
        allMenuItems,
        setAllMenuItems,
        cartItems,
        addToCart,
        removeFromCart,
        getTotalCartAmount,
        restaurentId,
        setRestaurentId,
        cartCount,
        setCartCount,
        allResaturents,
        setAllResstaurents,
      }}
    >
      {children}
    </UserContext.Provider>
  );
};

export default UserContext;
