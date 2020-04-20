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

@WebServlet(name = "CreateBlogs")
public class CreateBlogs extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session=req.getSession();

        String title = req.getParameter("title");

        String description = req.getParameter("description");

        String url =  req.getParameter("url");

        Blog B = new Blog(((User)session.getAttribute("loggedUser")).getUserId(),title,description,url);

        DataBase db=new DataBase();
        try {
            db.setBlog(B);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("Logat.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
