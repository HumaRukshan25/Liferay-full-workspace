<%@ page import="javax.portlet.PortletURL" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Email Not Found</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            padding: 40px;
            background-color: #fff;
            box-shadow: 0 0 10px #ccc;
            border-radius: 8px;
        }
        h2 {
            color: #d9534f; /* Red color for error */
        }
        p {
            margin: 20px 0;
        }
        a.button {
            text-decoration: none;
            background-color: #0275d8;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
        }
        a.button:hover {
            background-color: #025aa5;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Email Not Found</h2>
        <p>The email address you entered is either invalid or not registered.</p>
        <portlet:renderURL var="signupURL" />
        <a href="<%= signupURL.toString() %>" class="button">Back to Signup</a>
    </div>
</body>
</html>
