<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #ff7e5f, #feb47b);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
  }
  .form-container {
    max-width: 400px;
    padding: 20px;
    border: 1px solid #ccc;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    border-radius: 8px;
    animation: fadeIn 1s ease-in-out;
  }
  @keyframes fadeIn {
    from { opacity: 0; }
    to { opacity: 1; }
  }
  .form-container h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
  }
  .form-group {
    margin-bottom: 15px;
  }
  .form-group label {
    display: block;
    margin-bottom: 5px;
    color: #555;
  }
  .form-group input {
    width: calc(100% - 16px);
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  .form-group .error-message {
    color: red;
    font-size: 14px;
    margin-top: 5px;
  }
  .submit-btn {
    background-color: #4CAF50;
    color: white;
    padding: 12px 0;
    width: 100%;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }
  .submit-btn:hover {
    background-color: #45a049;
  }
  .register-link {
    text-align: center;
    margin-top: 20px;
    font-size: 14px;
  }
  .register-link a {
    color: #4CAF50;
    text-decoration: none;
  }
  .register-link a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>
  <div class="form-container">
    <h2>Login</h2>
    <form id="loginForm" action="login" method="post" onsubmit="return validateForm()">
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <div id="emailError" class="error-message"></div>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <div id="passwordError" class="error-message"></div>
      </div>
      <div class="form-group">
        <button type="submit" class="submit-btn">Login</button>
      </div>
      <div class="form-group">
        <div id="loginResult" class="error-message">
          <% String error = request.getParameter("error"); 
             if (error != null && error.equals("invalid")) { %>
             Invalid email or password. Please try again.
             <div class="register-link">
               Don't have an account? <a href="register.jsp">Register here</a>.
             </div>
          <% } %>
        </div>
      </div>
    </form>
  </div>
<script>
  function validateForm(event) {
      var email = document.getElementById("email").value;
      var password = document.getElementById("password").value;
      var emailError = document.getElementById("emailError");
      var passwordError = document.getElementById("passwordError");

      emailError.innerHTML = "";
      passwordError.innerHTML = "";

      var isValid = true;

      if (!email.match(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/)) {
        emailError.innerHTML = "Invalid email format";
        isValid = false;
      }

      if (password.length < 6) {
        passwordError.innerHTML = "Password must be at least 6 characters";
        isValid = false;
      }

      if (!isValid) {
        event.preventDefault(); // Prevent form submission
      }

      return isValid;
    }
  </script>
</body>
</html>
