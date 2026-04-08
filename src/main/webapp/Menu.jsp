<%@ page import="com.tap.model.Restaurant,java.util.List,com.tap.model.Menu" %>

<%
Restaurant r = (Restaurant)request.getAttribute("restaurant");
%>

<!DOCTYPE html>
<html>
<head>
<title>Menu</title>

<style>

body{
    margin:0;
    font-family:Arial;
    background:#f5f5f5;
}

/* HEADER */
.header{
    background:#ff5200;
    color:white;
    padding:15px 20px;
    font-size:22px;
    font-weight:bold;
}

/* GRID CONTAINER */
.menu{
    width:90%;
    margin:30px auto;
    display:grid;
    grid-template-columns:repeat(4, 1fr);
    gap:20px;
}

/* CARD */
.item{
    background:white;
    padding:15px;
    border-radius:10px;
    box-shadow:0 2px 8px rgba(0,0,0,0.1);
    text-align:center;
    transition:0.3s;
}

.item:hover{
    transform:scale(1.03);
}

/* IMAGE */
.item img{
    width:100%;
    height:150px;
    object-fit:cover;
    border-radius:10px;
}

/* TEXT */
.item-name{
    font-size:16px;
    font-weight:bold;
    margin:10px 0 5px;
}

.price{
    color:#ff5200;
    font-weight:bold;
}

.desc{
    color:#666;
    font-size:13px;
}

.time{
    color:green;
    font-size:12px;
}

/* BUTTON */
.item input{
    margin-top:10px;
    padding:6px 12px;
    border:1px solid #ff5200;
    background:white;
    color:#ff5200;
    font-weight:bold;
    border-radius:5px;
    cursor:pointer;
}

.item input:hover{
    background:#ff5200;
    color:white;
}

/* RESPONSIVE */
@media (max-width:1000px){
    .menu{
        grid-template-columns:repeat(2, 1fr);
    }
}

@media (max-width:600px){
    .menu{
        grid-template-columns:1fr;
    }
}

</style>

</head>

<body>

<!-- HEADER -->
<div class="header">
    Menu
</div>

<!-- MENU -->
<div class="menu">

<%
List<Menu> menuList=(List<Menu>)request.getAttribute("menuList");

for(Menu m : menuList)
{
%>

<div class="item">

    <img src="<%=request.getContextPath()%>/images/<%=m.getImagePath()%>" alt="food">

    <p class="item-name"><%=m.getItemName()%></p>
    <p class="price">₹ <%=m.getPrice()%></p>
    <p class="desc"><%=m.getDescription()%></p>
    <p class="time"><%=m.isAvailable()%></p>
	
	
	
	<form action="<%=request.getContextPath()%>/cart" method="post">
	<input type="hidden" name="menuId" value="<%=m.getMenuId()%>">
	<input type="hidden" name="quantity" value="<%=1%>">
	<input type="hidden" name="restaurantId" value="<%=m.getRestaurantId()%>">
	<input type="hidden" name="action" value="add">
	 <input type="submit" value="ADD">
	</form>
	
   

</div>

<%
}
%>

</div>

</body>
</html>