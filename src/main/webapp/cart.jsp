<%@ page import="com.tap.model.cartItem,com.tap.model.Cart,com.tap.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>

<style>

body {
    font-family: 'Segoe UI', Arial;
    background: #f8f8f8;
    margin: 0;
}

/* Header */
.header {
    background: #fc8019;
    color: white;
    padding: 18px;
    font-size: 24px;
    text-align: center;
    font-weight: bold;
}

/* Container */
.cart-container {
    width: 60%;
    margin: 30px auto;
}

/* Cart Item */
.cart-item {
    background: white;
    border-radius: 12px;
    padding: 20px;
    margin-bottom: 15px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.08);
}

/* Layout */
.cart-item-details {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

/* Name */
.cart-item-details h3 {
    margin: 0;
    color: #333;
}

/* Price */
.price-section {
    text-align: right;
}

.price {
    color: #777;
}

.total {
    font-weight: bold;
}

/* Quantity Buttons */
.quantity-box {
    display: flex;
    align-items: center;
    margin-top: 10px;
}

.qty-btn {
    background: #fc8019;
    color: white;
    border: none;
    padding: 5px 12px;
    cursor: pointer;
    font-size: 16px;
    border-radius: 5px;
}

.qty-btn:hover {
    background: #e56f14;
}

.qty {
    margin: 0 10px;
    font-weight: bold;
}

/* Remove Button */
.remove-btn {
    background: red;
    color: white;
    border: none;
    padding: 6px 10px;
    margin-top: 8px;
    cursor: pointer;
    border-radius: 5px;
}

/* Add More Button */
.add-more-items {
    text-align: center;
    margin: 20px 0;
}

.btn-add-more-items-btn {
    display: inline-block;
    padding: 10px 25px;
    border: 2px solid #fc8019;
    color: #fc8019;
    font-weight: bold;
    border-radius: 25px;
    text-decoration: none;
    background: white;
    transition: 0.3s;
}

.btn-add-more-items-btn:hover {
    background: #fc8019;
    color: white;
}

/* Summary */
.summary {
    background: white;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.08);
    margin-top: 20px;
}

.summary h2 {
    margin: 0;
}

.checkout-btn {
    width: 100%;
    background: #fc8019;
    color: white;
    border: none;
    padding: 12px;
    margin-top: 15px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 8px;
}

.checkout-btn:hover {
    background: #e56f14;
}

/* Empty */
.empty-cart {
    text-align: center;
    margin-top: 100px;
    font-size: 20px;
    color: #777;
}

</style>

</head>

<body>

<div class="header">Your Cart</div>

<div class="cart-container">

<%
    Cart cart = (Cart) session.getAttribute("cart");
    double grandTotal = 0;

    if (cart != null && !cart.getItems().isEmpty()) {
        for (cartItem item : cart.getItems().values()) {
            grandTotal += item.getTotalPrice();
%>

    <div class="cart-item">
        <div class="cart-item-details">

            <div>
                <h3><%= item.getItemName() %></h3>

                <div class="quantity-box">

                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("id") %>">
                        <input type="hidden" name="quantity" value="<%=item.getQuantity() -1%>">
                        
                        <button class="qty-btn" <% if (item.getQuantity() == 1) {%> disabled <%} %>>-</button>
                    </form>

                    <span class="qty"><%= item.getQuantity() %></span>

                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("id") %>">
                        <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                        <input type="hidden" name="quantity" value="<%=item.getQuantity() +1%>">
                        <button class="qty-btn">+</button>
                    </form>

                </div>

                <form action="cart" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="restaurantId" value="<%= session.getAttribute("id") %>">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                    <button class="remove-btn">Remove</button>
                </form>

            </div>

            <div class="price-section">
                <p class="price">Rs. <%= item.getPrice() %></p>
                <p class="total">Rs. <%= item.getTotalPrice() %></p>
            </div>

        </div>
    </div>

		<%
        }
		%>

    <!-- Add More Items (when cart has items) -->
    <div class="add-more-items">
        <a href="<%=request.getContextPath()%>/getRestaurantById?id=<%= session.getAttribute("id") %>"
           class="btn-add-more-items-btn">
           + Add More Items
        </a>
    </div>

    <div class="summary">
        <h2>Total:Rs. <%= grandTotal %></h2>

        <form action="checkOut.jsp" method="post">
            <button class="checkout-btn">Proceed to Checkout</button>
        </form>
    </div>

<%
    } else {
%>

    <div class="empty-cart">
        Your cart is empty
    </div>

    <!-- Add More Items (when cart is empty) -->
    <div class="add-more-items">
        <a href="<%=request.getContextPath()%>/getRestaurantById?id=<%= session.getAttribute("id") %>"
           class="btn-add-more-items-btn">
           + Add More Items
        </a>
    </div>

<%
    }
%>

</div>

</body>
</html>