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

@WebServlet(name = "ListaBlog")
public class ListaBlog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        User U = (User) session.getAttribute("loggedUser");
        ArrayList<Blog> blogs = new ArrayList<Blog>();

        try {
            DataBase db=new DataBase();
            blogs = db.selectBlog("select * from Blog where UserId = ?", U.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("listaBloguri", blogs);
        request.getRequestDispatcher("ListaBloguri.jsp").forward(request, response);
        response.sendRedirect("ListaBloguri.jsp");
    }
}
