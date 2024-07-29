import React, { useRef, useState, useContext } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import "./Login.css"; // Import your CSS file
import UserContext from "../Context/UserContext";

const Login = () => {
  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  const [error, setError] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const navigate = useNavigate();
  const { setUser } = useContext(UserContext);

  const handleLogin = async (e) => {
    e.preventDefault();
    const emailValue = emailRef.current.value;
    const passwordValue = passwordRef.current.value;

    // Email validation regex
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    let valid = true;

    if (!emailRegex.test(emailValue)) {
      setEmailError("Please enter a valid email address.");
      valid = false;
    } else {
      setEmailError("");
    }

    if (passwordValue.length < 6) {
      setPasswordError("Password must be at least 6 characters long.");
      valid = false;
    } else {
      setPasswordError("");
    }

    if (!valid) {
      return;
    }

    try {
      const response = await axios.post(
        "http://localhost:8082/FOODDELIVERYPROJECT/sivakrishna",
        {
          email: emailValue,
          password: passwordValue,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );

      if (response.status === 200) {
        const data = response.data;
        console.log(data);
        setUser(data);
        navigate("/home");
      } else {
        setError("Invalid email or password");
      }
    } catch (error) {
      setError("Something went wrong. Please try again.");
    }
  };

  return (
    <div className="login-container">
      <form className="login-form" onClick={handleLogin}>
        <h2>Login</h2>
        <div className="input-group">
          <label>Email:</label>
          <input type="email" ref={emailRef} required />
          {emailError && <p className="error-message">{emailError}</p>}
        </div>
        <div className="input-group">
          <label>Password:</label>
          <input type="password" ref={passwordRef} required />
          {passwordError && <p className="error-message">{passwordError}</p>}
        </div>
        {error && <p className="error-message">{error}</p>}
        <button type="submit" className="login-button">
          Login
        </button>
        <p className="register-link">
          Don't have an account? <Link to="/register">Register here</Link>
        </p>
      </form>
    </div>
  );
};

export default Login;
