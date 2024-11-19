<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message Page</title>
<style>
    body {
        font-family: 'Verdana', sans-serif;
        background: linear-gradient(135deg, #74ebd5, #acb6e5);
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
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
        color: #333;
        font-weight: 600;
        margin-bottom: 20px;
    }

    .container p {
        font-size: 16px;
        color: #333;
        margin-bottom: 20px;
    }

    .container .msg {
        font-size: 14px;
        color: #ff4500;
        margin-top: 15px;
    }

    .container .links {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
        font-size: 14px;
    }

    .container .links a {
        color: #4caf50;
        text-decoration: none;
    }

    .container .links a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <%
    String msg = (String)request.getAttribute("msg");
    out.println("<p class='msg'>" + msg + "</p>");
    %>
    <div class="links">
        <a href="index.html">Go to Home</a>
    </div>
</div>
</body>
</html>
