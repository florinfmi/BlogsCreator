package BlogsApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "/ArticoleBlog")
public class ArticoleBlog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        ArrayList<Article> articles = new ArrayList<>();

        String title = request.getParameter("title");
        while (title == "") {
            out.println("Completati titlul:");
            title = request.getParameter("title");
        }


        String description = request.getParameter("description");
        while (description == "") {
            out.println("Completati titlul:");
            description = request.getParameter("description");
        }

        String tags = request.getParameter("tags");
        while (tags == "") {
            out.println("Completati tagurile:");
            tags = request.getParameter("tags");
        }

        String content = request.getParameter("content");
        while (content == "") {
            out.println("Completati campul:");
            content = request.getParameter("content");
        }
        int blogId = Integer.parseInt(request.getParameter("blogId"));
        try {
            DataBase db = new DataBase();
            Article article = new Article(blogId , 0, 0, title, description, tags, content, false, new Date());
            db.setArticle(article);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("idBlog", blogId);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        int blogId;

        if (request.getParameter("idBlog") == null)
            blogId = (int) (request.getAttribute("idBlog"));
        else
            blogId = Integer.parseInt(request.getParameter("idBlog"));
        ArrayList<Article> articles = new ArrayList<>();

        try {
            DataBase db = new DataBase();
            articles = db.selectArticle(blogId);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("articles", articles);
        request.setAttribute("idBlog", blogId);
        request.getRequestDispatcher("ArticoleBlog.jsp").forward(request, response);
        response.sendRedirect("ArticoleBlog.jsp");
    }
}
