package BlogsApp;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        User u=new User("da","gf","bfdbdf","par","192.0.1.8");
        DataBase db=new DataBase();

        db.setUser(u);


    }
}

