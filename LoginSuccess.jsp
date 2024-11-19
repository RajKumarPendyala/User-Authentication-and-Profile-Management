<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
<style>
    body {
        font-family: 'Verdana', sans-serif;
        background: linear-gradient(135deg, #74ebd5, #acb6e5);
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background-color: white;
        border-radius: 10px;
        padding: 30px;
        width: 350px;
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    .container h2 {
        margin-bottom: 20px;
        color: #333;
        font-weight: 600;
    }

    .container p {
        font-size: 16px;
        color: #333;
        margin-bottom: 20px;
    }

    .container a {
        display: inline-block;
        margin-top: 15px;
        color: #4caf50;
        text-decoration: none;
        font-size: 14px;
    }

    .container a:hover {
        text-decoration: underline;
    }

    .container .link-container {
        margin-top: 20px;
        display: flex;
        justify-content: space-between; /* Positioning the links side by side */
        font-size: 14px;
    }
</style>
</head>
<body>
<div class="container">
    <%
    UserBean ub = (UserBean)application.getAttribute("ubean");
    out.println("<h3>Welcome User: "+ ub.getuName()+"</h3>");
    %>
    <div class="link-container">
        <a href="view">View Profile</a>
        <br>
        <a href="logout">Log Out</a>
    </div>
</div>
</body>
</html>
