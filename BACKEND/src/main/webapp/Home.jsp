<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIVA FOODS</title>
    <link rel="stylesheet" href="Navbar.css">
</head>

<body>
    <div class="container">
        <div class="navbar">
            <div class="nav-logo">
                <img src="https://static.vecteezy.com/system/resources/previews/003/514/343/original/fast-food-hamburger-burger-cheeseburger-cartoon-illustration-free-vector.jpg" alt="Logo" />
                <p>SIVA FOODS</p>
            </div>
            <ul class="nav-menu">
                <li><a href="${pageContext.request.contextPath}/Home.jsp" class="${menu == 'home' ? 'active' : ''}">Home</a></li>
            
                <li><a href="${pageContext.request.contextPath}/OrderHistory.jsp" class="${menu == 'order-history' ? 'active' : ''}">Order History</a></li>
                <li><a href="${pageContext.request.contextPath}/AboutUs.jsp" class="${menu == 'about-us' ? 'active' : ''}">About Us</a></li>
            </ul>
            <div class="nav-login-cart">
                <a href="login.jsp">
                    <button>LogOut</button>
                </a>
                <a href="${pageContext.request.contextPath}/Cart.jsp">
                    <img src="https://shop.sage.co.za/wp-content/uploads/2017/09/green-shopping-cart-icon-5-1.png" alt="Cart Icon" />
                </a>
                <div class="nav-cart-count">0</div>
            </div>
        </div>
    </div>
</body>
</html>
