package BlogsApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;


@WebServlet(name = "/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();




            String email = req.getParameter("email");
            while (email == "") {
                out.println("Completati parola:");
                email = req.getParameter("email");
            }

            String password = req.getParameter("password");
            while (password == "") {
                out.println("Completati parola:");
                password = req.getParameter("password");
            }

            User U=new User();
            U.setEmail(email);
            U.setUserPassword(password);

        try {
            DataBase db=new DataBase();

            U=db.selectUser("select * from User where Email = ? and UserPassword = ?;",U);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(U.getUserId() != -1 )


            HttpSession session =request.getSession();
            session.setAttribute("loggedUser",U);



            resp.sendRedirect("Logat.jsp");

    }
}

