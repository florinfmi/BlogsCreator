<%@ page import="java.util.ArrayList" %>
<%@ page import="BlogsApp.Blog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        ArrayList<Blog> blogs = (ArrayList<Blog>)request.getAttribute("listaBloguri");

        for(Blog blog : blogs)
        {
        localhost8080:/BlogCreator_war_explode/ArticoleBlog?idBlog=
           out.println("<a href=\"ArticoleBlog?idBlog=" + blog.getBlogId() + "\">" + blog.getURL() + "</a>");
           out.println("<br/>");
        }
    %>
</body>
</html>





a
a
a
a
a