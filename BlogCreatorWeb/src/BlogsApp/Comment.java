package BlogsApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;


public class Comment {

    private int CommentId,UserId,ArticleId;
    private Date RecordStamp;
    private String Content;
    private boolean ApprovedYN;

    public Comment() {
        CommentId=-1;
        ArticleId=-1;
        UserId = -1;
        RecordStamp = new Date();
        Content = "";
        ApprovedYN = false;
    }

    public Comment(int userId,int commentId,int articleId, Date recordStamp, String content, boolean approvedYN) {
        CommentId=commentId;
        ArticleId=articleId;
        UserId = userId;
        RecordStamp = recordStamp;
        Content = content;
        ApprovedYN = approvedYN;
    }

    public Comment(final Comment ob){
        if(this != ob)
        {
            CommentId=-ob.CommentId;
            ArticleId=ob.ArticleId;
            UserId = ob.UserId;
            RecordStamp = ob.RecordStamp;
            Content = ob.Content;
            ApprovedYN = ob.ApprovedYN;
        }
    }

    public void In() throws FileNotFoundException {
        File file=new File("Comment.txt");
        Scanner sc=new Scanner(file);

        Content=sc.nextLine();
        UserId=sc.nextInt();
        ArticleId=sc.nextInt();

    }
    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int commentId) {
        CommentId = commentId;
    }

    public int getArticleId() {
        return ArticleId;
    }

    public void setArticleId(int articleId) {
        ArticleId = articleId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Date getRecordStamp() {
        return RecordStamp;
    }

    public void setRecordStamp(Date recordStamp) {
        RecordStamp = recordStamp;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isApprovedYN() {
        return ApprovedYN;
    }

    public void setApprovedYN(boolean ApprovedYN) {
        ApprovedYN = ApprovedYN;
    }
}
