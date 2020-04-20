package BlogsApp;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;


public class DataBase {

    private Connection con;
    private Statement st;
    private ResultSet rset;
    private PreparedStatement pst;

    public DataBase() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/BlogsApp?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "florin", "ceapa");
                st = con.createStatement();
                rset = null;
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | SQLException e) {
                e.printStackTrace();
            }
    }
    public void setUser(User ob) throws SQLException
    {

            this.pst = con.prepareStatement(DataBaseData.insertUser);
            pst.setString(1, ob.getFirstName());
            pst.setString(2, ob.getLastName());
            pst.setString(3, ob.getEmail());
            pst.setString(4, ob.getUserPassword());
            pst.setString(5, ob.getIpAddress());
            pst.executeUpdate();
    }
    public User selectUser(String s,User user) throws SQLException
    {
        String query=s;

        this.pst = con.prepareStatement(s);

        pst.setString(1, user.getEmail());
        pst.setString(2, user.getUserPassword());
        rset=pst.executeQuery();
        User U=new User();
        while(rset.next())
        {
            U.setUserId(rset.getInt("UserId"));
            U.setFirstName(rset.getString("FirstName"));
            U.setLastName(rset.getString("LastName"));
            U.setEmail(rset.getString("Email"));
            U.setUserPassword(rset.getString("UserPassword"));
            U.setIpAddress(rset.getString("IpAddress"));
        }

        return U;

    }
    public void deleteUser(int id) throws SQLException {
        String str=DataBaseData.deleteU;
        pst=con.prepareStatement(str);
        pst.setInt(1,id);
        pst.executeUpdate();
    }

    public void setBlog(Blog ob) throws SQLException {
        pst = con.prepareStatement(DataBaseData.insertBlog);
        pst.setString(1, ob.getTitle());
        pst.setString(2, ob.getDescription());
        pst.setString(3, ob.getURL());
        pst.setInt(4,ob.getUserId());
        pst.executeUpdate();
    }
    public ArrayList<Blog> selectBlog(String query, int userId) throws SQLException
    {
        this.pst = con.prepareStatement(query);
        pst.setInt(1, userId);
        rset=pst.executeQuery();
        ArrayList<Blog> ret = new ArrayList<Blog>();
        while(rset.next())
        {
            Blog tempBlog = new Blog();
            tempBlog.setBlogId(rset.getInt("BlogId"));
            tempBlog.setTitle(rset.getString("Title"));
            tempBlog.setDescription(rset.getString("Description"));
            tempBlog.setURL(rset.getString("URL"));
            tempBlog.setUserId(rset.getInt("UserId"));
            ret.add(tempBlog);
        }

        return ret;
    }
    public void deleteBlog(int id) throws SQLException {
        String str=DataBaseData.deleteB;
        pst=con.prepareStatement(str);
        pst.setInt(1,id);
        pst.executeUpdate();
    }
    public void setArticle(Article ob) throws SQLException {
        pst = con.prepareStatement(DataBaseData.insertArticle);
        pst.setInt(1, 0);
        pst.setInt(2, 0);
        pst.setInt(3,ob.getBlogId());
        pst.setString(4,ob.getDescription());
        pst.setString(5,ob.getTags());
        pst.setString(6,ob.getContent());
        pst.setBoolean(7,ob.isPublishedYN() );
        pst.setDate(8, new Date(ob.getRecordStamp().getTime()));
        pst.setString(9, ob.getTitle());
        pst.executeUpdate();
    }

    public ArrayList<Article> selectArticle(int blogId) throws SQLException {
        String query = "select * from Article where BlogId = ? order by RecordStamp DESC";

        pst = con.prepareStatement(query);
        pst.setInt(1, blogId);
        rset = pst.executeQuery();

        ArrayList<Article> ret = new ArrayList<>();
        while (rset.next()) {
            Article tempArticle = new Article();
            tempArticle.setBlogId(rset.getInt("BlogId"));
            tempArticle.setArticleId(rset.getInt("ArticleId"));
            tempArticle.setVotes(rset.getInt("Votes"));
            tempArticle.setViewCount(rset.getInt("ViewCount"));
            tempArticle.setTitle(rset.getString("Title"));
            tempArticle.setTags(rset.getString("Tags"));
            tempArticle.setDescription(rset.getString("Description"));
            tempArticle.setContent(rset.getString("Content"));
            tempArticle.setPublishedYN(rset.getBoolean("PublishedYN"));
            tempArticle.setRecordStamp(rset.getTimestamp("RecordStamp"));
            ret.add(tempArticle);
        }

        return ret;
    }

  public void deleteArticle(int id) throws SQLException {
      String str=DataBaseData.deleteA;
      pst=con.prepareStatement(str);
      pst.setInt(1,id);
      pst.executeUpdate();
  }

  public void setComment(Comment ob) throws SQLException {
      pst = con.prepareStatement(DataBaseData.insertComment);
      pst.setInt(1,ob.getUserId());
      pst.setInt(2,ob.getArticleId());
      pst.setDate(3, new Date(ob.getRecordStamp().getTime()));
      pst.setString(4,ob.getContent());
      pst.executeUpdate();
  }
    public void deleteComment(int id) throws SQLException {
        String str=DataBaseData.deleteC;
        pst=con.prepareStatement(str);
        pst.setInt(1,id);
        pst.executeUpdate();
    }
}
