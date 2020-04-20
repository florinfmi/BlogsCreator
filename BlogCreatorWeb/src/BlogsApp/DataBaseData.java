package BlogsApp;

public interface DataBaseData {

    public static final String insertUser = "insert into User (FirstName,LastName,Email,UserPassword,IpAddress) values (?,?,?,?,?)";
    public static final String insertBlog = "insert into Blog (Title,Description,URL,UserId) values (?,?,?,?)";
    public static final String insertArticle = "insert into Article (Votes,ViewCount,BlogId,Description,Tags,Content,PublishedYN,RecordStamp, Title) values (?,?,?,?,?,?,?,?,?)";
    public static final String insertComment = "insert into Comment (UserId,ArticleId,RecordStamp,Content) values (?,?,?,?)";
    public static final String selectU = "select * from User";
    public static final String selectB = "select * from Blog";
    public static final String selectA= "select * from Article";
    public static final String selectC = "select * from Comment";
    public static final String updateUser ="update User set BlogID = ?";
    public static final String updateBlog ="update Blog set Title = ?";
    public static final String updateArticle ="update Article set Description = ?";
    public static final String updateComment = "update Comment set ApprovedYN = ?";
    public static final String deleteU = "delete from User where UserId= ?";
    public static final String deleteB = "delete from Blog where BlogId= ?";
    public static final String deleteA = "delete from Article where ArticleId= ?";
    public static final String deleteC= "delete from Comment where CommentId = ?";

}
