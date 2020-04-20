<%@ page import="BlogsApp.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ArticoleBlog" method="post">

    <table border="0">
        <tbody>
        <tr>

            <td>Title:</td>
            <td><input type="text" name="title" value="" size="30" /></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><textarea name="description" rows="4" cols="50"></textarea></td>
        </tr>
        <tr>
            <td>Tags:</td>
            <td><input type="text" name="tags" value="" size="30" /> </td>
        </tr>
        <tr>
            <td>Content:</td>
            <td><textarea name="content" rows="8" cols="100"></textarea></td>
        </tr>
        </tbody>
    </table>
    <% int idBlog = (int)request.getAttribute("idBlog");%>
    <input type="hidden" name="blogId" value="${idBlog}">
    <input type="submit" value="Add article" name="buton">
</form>

<%
    ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");

    for(Article article : articles)
    {
        out.println("<h1>" + article.getTitle() + "</h1>");
        out.println("<br/>");
    }
%>


</body>
</html>
