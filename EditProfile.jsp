<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
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

    .container form {
        text-align: left;
        font-size: 14px;
    }

    .container form label {
        display: block;
        margin-bottom: 5px;
        font-size: 14px;
        color: #999; /* Lighter color for labels */
        text-align: left;
    }

    .container form input[type="text"] {
        width: 93%;
        padding: 12px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
    }

    .container form input[type="submit"] {
        background-color: #4caf50;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .container form input[type="submit"]:hover {
        background-color: #45a049;
    }

    .container .link-container {
        margin-top: 20px;
        display: flex;
        justify-content: space-between; /* Positioning the links side by side */
        font-size: 14px;
    }

    .container .link-container a {
        color: #4caf50;
        text-decoration: none;
    }

    .container .link-container a:hover {
        text-decoration: underline;
    }

</style>
</head>
<body>
<div class="container">
    <h2>Edit Profile</h2>
    <%
    String fName = (String)request.getAttribute("fName");
    UserBean ub = (UserBean)application.getAttribute("ubean");
    out.println("<p>Page belongs to User: " + fName + "</p>");
    %>
    <form action="update" method="post">
        <label for="city">City</label>
        <input type="text" id="city" name="city" value="<%= ub.getCity() %>" required><br>

        <label for="mid">Mail ID</label>
        <input type="text" id="mid" name="mid" value="<%= ub.getmId() %>" required><br>

        <label for="phno">Phone No</label>
        <input type="text" id="phno" name="phno" value="<%= ub.getPhno() %>" required><br>

        <input type="submit" value="Update Profile">
    </form>
    <div class="link-container">
        <a href="view">View Profile</a>
        <a href="logout">Log Out</a>
    </div>
</div>
</body>
</html>
