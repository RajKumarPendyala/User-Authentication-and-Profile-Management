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

    .container .user-details {
        font-size: 14px;
        color: #666;
        margin-bottom: 20px;
        text-align: left;
    }

    .container .user-details span {
        display: block;
        margin: 5px 0;
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
    <h2>Profile Page</h2>
    <%
    String fName = (String)request.getAttribute("fname");
    UserBean ub = (UserBean)application.getAttribute("ubean");
    out.println("<p>Page belongs to user: "+fName+"</p>");
    out.println("<div class='user-details'>");
    out.println("<span>Full Name: " + ub.getfName() + " " + ub.getlName() + "</span>");
    out.println("<span>City: " + ub.getCity() + "</span>");
    out.println("<span>Email: " + ub.getmId() + "</span>");
    out.println("<span>Phone: " + ub.getPhno() + "</span>");
    out.println("</div>");
    %>
    <div class="link-container">
        <a href="edit">Edit</a>
        <br>
        <a href="logout">Log Out</a>
    </div>
</div>
</body>
</html>
