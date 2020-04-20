
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
    <h1>BLOGSAPP</h1>
<form action="${pageContext.request.contextPath}/Login" method="post">

    <table border="0">
        <tbody>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="" size="50" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="" size="30" /></td>
        </tr>

        </tbody>
    </table>
    <input type="submit" value="Log in" name="logare">
</form>
    <a href="Register.jsp">Nu ai cont?Apasa aici pentru inregistrare.</a>

</center>
</body>
</html>
