package BlogsApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Article {

    private int ArticleId,Votes,ViewCount,BlogId;
    private String Description,Tags,Content,Title;
    private boolean PublishedYN;
    private Date RecordStamp;


    public Article() {
        Title="";
        BlogId=-1;
        ArticleId = -1;
        Votes = 0;
        ViewCount = 0;
        Description = "";
        Tags = "";
        Content = "";
        PublishedYN = false;
        RecordStamp=new Date();
    }

    public Article(int blogId, int votes, int viewCount, String title, String description, String tags, String content, boolean publishedYN, Date recordStamp) {
        BlogId=blogId;
        Votes = votes;
        ViewCount = viewCount;
        Title = title;
        Description = description;
        Tags = tags;
        Content = content;
        PublishedYN = publishedYN;
        RecordStamp = recordStamp;
    }
    public Article(final Article ob) {
        if(this != ob) {
            BlogId = ob.BlogId;
            ArticleId = ob.ArticleId;
            Votes = ob.Votes;
            ViewCount = ob.ViewCount;
            Description = ob.Description;
            Tags = ob.Tags;
            Content = ob.Content;
            PublishedYN = ob.PublishedYN;
            RecordStamp = ob.RecordStamp;
        }
    }
    public void In() throws FileNotFoundException {

        File file=new File("Article.txt");
        Scanner sc=new Scanner(file);

        Description=sc.nextLine();
        Tags=sc.nextLine();
        Content=sc.nextLine();
        PublishedYN=sc.nextBoolean();
        Votes=sc.nextInt();
        ViewCount=sc.nextInt();
        BlogId=sc.nextInt();

    }

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void setViewCount(int viewCount) {
        ViewCount = viewCount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isPublishedYN() {
        return PublishedYN;
    }

    public void setPublishedYN(boolean publishedYN) {
        PublishedYN= publishedYN;
    }

    public Date getRecordStamp() {
        return RecordStamp;
    }

    public void setRecordStamp(Date recordStamp) {
        RecordStamp = recordStamp;
    }

    public int getArticleId() {
        return ArticleId;
    }

    public void setArticleId(int articleId) {
        ArticleId = articleId;
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

    public void setTitle(String title) {
        Title = title;
    }
}
