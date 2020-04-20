package BlogsApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;

@WebServlet(name = "/Register")

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        InetAddress localhost = InetAddress.getLocalHost();

        if (req.getParameter("buton") != null) {
            String nume = req.getParameter("nume");
            if (nume == "") {
                out.println("Completati numele");
                return;
            }

            String prenume = req.getParameter("prenume");
            if (prenume == "") {
                out.println("Completati prenumele");
                return;
            }

            String email = req.getParameter("email");
            if (email == "") {
                out.println("Completati emailul:");
                return;
            }

            String password = req.getParameter("password");
            if (password == "") {
                out.println("Completati parola:");
                return;
            }

            User u = new User(nume, prenume, email, password, localhost.toString());
            DataBase db = new DataBase();

            try {
                db.setUser(u);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.println("<html><body><br/><br/><br/><br/><br/>");
            out.println("<h1>Inregistrarea a fost efectuata cu succes</h1><br/>");
            out.println("<h3><a href=\"index.jsp\"> Click aici pentru a te intoarce la pagina de logare</a></h3>");
            out.println("</body></html>");
        }
    }
}
