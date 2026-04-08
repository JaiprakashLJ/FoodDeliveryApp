<%@ page import="com.tap.model.user" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>

/* 🔥 GLOBAL */
body {
    font-family: 'Segoe UI', Arial;
    background: #f1f1f1;
    margin: 0;
}

/* HEADER */
.header {
    background: white;
    padding: 15px 30px;
    font-size: 22px;
    font-weight: bold;
    border-bottom: 1px solid #ddd;
}

/* MAIN CONTAINER */
.container {
    width: 40%;
    margin: 40px auto;
}

/* CARD */
.checkout-card {
    background: white;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.08);
}

/* TITLE */
.checkout-card h2 {
    margin-top: 0;
    margin-bottom: 20px;
}

/* LABEL */
label {
    display: block;
    margin-top: 15px;
    font-weight: bold;
    color: #333;
}

/* TEXTAREA */
textarea {
    width: 100%;
    height: 80px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    margin-top: 5px;
    font-size: 14px;
}

/* SELECT */
select {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border-radius: 6px;
    border: 1px solid #ccc;
}

/* BUTTON */
.place-order-btn {
    width: 100%;
    background: #fc8019;
    color: white;
    border: none;
    padding: 12px;
    margin-top: 20px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 6px;
}

.place-order-btn:hover {
    background: #e56f14;
}

/* USER INFO */
.user-info {
    background: #fafafa;
    padding: 10px;
    border-radius: 6px;
    margin-bottom: 15px;
    font-size: 14px;
}

</style>

</head>

<body>

<div class="header">Checkout</div>

<div class="container">

<%
    user user = (user) session.getAttribute("user");
%>

<div class="checkout-card">

    <h2>Delivery Details</h2>

    
    <%
    
    	if(user != null)
    	{
    		%>
    		<form action="checkout" method="post" id = "checkoutform">

            <!-- ADDRESS -->
            <label for="address">Delivery Address</label>
            <textarea id="address" name="address" required></textarea>

            <!-- PAYMENT -->
            <label for="paymentMethod">Payment Method</label>
            <select name="paymentMethod" id="paymentMethod" required>
                <option value="">Select Payment</option>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Cash on Delivery">Cash on Delivery</option>
            </select>

            <!-- BUTTON -->
            
            <button type="submit" class="place-order-btn" onclick="document.getElementById('checkoutform').submit()">
                Place Order
            </button>

        </form>
		<% 
    	} else{
    		response.sendRedirect("login.html");
    	}
    
    %>

    
</div>

</div>

</body>
</html>