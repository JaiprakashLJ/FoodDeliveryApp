<%@ page import="java.util.List,com.tap.model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
<title>Food Delivery</title>

<style>

body{
    font-family: Arial;
    margin:0;
    background:#121212;
    color:white;
}

header{
    background:#000;
    color:white;
    padding:15px;
    text-align:center;
    border-bottom:1px solid #333;
}

.container{
    display:grid;
    grid-template-columns:repeat(auto-fill,minmax(250px,1fr));
    gap:20px;
    padding:20px;
}

a{
    text-decoration:none;
    color:inherit;
}

.card{
    background:#1e1e1e;
    border-radius:10px;
    overflow:hidden;
    box-shadow:0 3px 10px rgba(0,0,0,0.5);
    transition:0.3s;
}

.card:hover{
    transform:scale(1.05);
}

.card img{
    width:100%;
    height:160px;
    object-fit:cover;
}

.card h3{
    margin:10px;
}

.card p{
    margin:5px 10px;
    color:#bbb;
}

.rating{
    color:#00e676;
    font-weight:bold;
}

.time{
    font-size:14px;
    color:#888;
}

</style>

</head>

<body>

<header>
    <h1>FOODAPP</h1>
</header>

<div class="container">

<%
List<Restaurant> restaurants = (List<Restaurant>)request.getAttribute("Restaurant");

for(Restaurant r : restaurants)
{
%>

<a href="getRestaurantById?id=<%=r.getRestaurantId()%>">

    <div class="card">
        <img src="<%=request.getContextPath()%>/images/<%=r.getImagePath()%>" alt="Restaurant image">
        
        <h3><%=r.getName() %></h3>
        
        <p class="rating">⭐ <%=r.getRating() %></p>
        
        <p><%=r.getCuisineType() %></p>
        
        <p class="time">⏱ <%=r.getDeliveryTime() %> mins</p>
    </div>

</a>

<%
}
%>

</div>

</body>
</html>