package BlogsApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Blog {

    private int BlogId,UserId;
    private String Title,Description,URL;

    public Blog() {
        UserId=-1;
        BlogId = -1;
        Title = "";
        Description = "";
        URL = "";
    }
    public Blog(int userId, String title, String description, String uRL) {
        UserId = userId;
        Title = title;
        Description = description;
        URL = uRL;
    }
    public Blog(final Blog ob) {
        if(this != ob) {
            UserId = ob.UserId;
            BlogId = ob.BlogId;
            Title = ob.Title;
            Description = ob.Description;
            URL = ob.URL;
        }
    }
    public void In() throws FileNotFoundException {

        File file=new File("Blog.txt") ;
        Scanner sc=new Scanner(file);

        Title =sc.nextLine();
        Description=sc.nextLine();
        URL=sc.nextLine();
        UserId=sc.nextInt();
    }

    public int getBlogId() {
        return BlogId;
    }

    public void setBlogId(int blogId) {
        BlogId = blogId;
    }

    public String getTitle() {
        return Title;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }
}
