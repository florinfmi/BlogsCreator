package BlogsApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {

        private int UserId;
        private String FirstName,LastName,Email,UserPassword,IpAddress;

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                ", IpAddress='" + IpAddress + '\'' +
                '}';
    }

    public User(){
        UserId = -1;
        FirstName = "";
        LastName = "";
        Email = "";
        UserPassword = "";
        IpAddress = "";
    }

    public User(String firstName, String lastName, String email, String userPassword, String ipAddress) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        UserPassword = userPassword;
        IpAddress=ipAddress;
    }
    public User(final User ob){
        if(this != ob) {
            UserId = ob.UserId;
            FirstName = ob.FirstName;
            LastName = ob.LastName;
            Email = ob.Email;
            UserPassword = ob.UserPassword;
            IpAddress = ob.IpAddress;
        }
    }
    public void In() throws FileNotFoundException
    {
        File file =new File("User.txt");
        Scanner sc=new Scanner(file);

        FirstName=sc.nextLine();
        LastName=sc.nextLine();
        Email=sc.nextLine();
        UserPassword=sc.nextLine();
        IpAddress=sc.nextLine();
        System.out.println("UserId:"+UserId+" FirstName:"+FirstName+" LastName:"+LastName+" "+Email+" ,parola:"+UserPassword+" "+IpAddress);
    }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int userId) {
            UserId = userId;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getUserPassword() {
            return UserPassword;
        }

        public void setUserPassword(String userPassword) {
            UserPassword = userPassword;
        }

        public String getIpAddress() {
            return IpAddress;
        }

        public void setIpAddress(String ipAddress) {
            IpAddress = ipAddress;
        }



    }
