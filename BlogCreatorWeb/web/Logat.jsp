<%@ page import="BlogsApp.*" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.mysql.cj.xdevapi.SqlDataResult" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BlogsApp</title>
</head>
<body>
<h1>Aplicatie de creat bloguri</h1>
<h2>Welcome:<% User U=(User)session.getAttribute("loggedUser");
           out.println(U.getEmail());%></h2>

<form action="${pageContext.request.contextPath}/CreateBlogs" method="post">

    <table border="0">
        <tbody>
        <tr>

            <td>Title:</td>
            <td><input type="text" name="title" value="" size="30" /></td>

        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="" size="250" /> </td>

        </tr>
        <tr>
            <td>URL:</td>
            <td><input type="text" name="url" value="" size="30" /> </td>
            <td><input type=""</td>

        </tr>
        </tbody>
    </table>

    <input type="submit" value="CreateBlog" name="buton">
</form>

<a href="${pageContext.request.contextPath}/ListaBlog">Lista Blogurilor tale</a>



</body>
</html>
