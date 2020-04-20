<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>BlogsApp</title>
</head>
<html>
<body>
<br/> <br/> <br/>
<center>
<form action="${pageContext.request.contextPath}/Register" method="post">

        <table border="0">
            <tbody>
            <tr>

                <td>First Name:</td>

                <td><input type="text" name="nume" value="" size="30" /></td>
            </tr>
            <tr>

                <td>Last name:</td>
                <td><input type="text" name="prenume" value="" size="30" /></td>
            </tr>

            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" value="" size="50" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="" size="30" /></td>
            </tr>
            <br/>
            </tbody>
        </table>

        <input type="submit" value="Inregistrare" name="buton">
</form>
</center>
</body>
</html>