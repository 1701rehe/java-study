package yf513.chy.bean;
/*
    新闻实体类
 */
public class News {
    private Integer id;     //主键id
    private String title;   //新闻标题

    public News() {
    }

    public News(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
