package domain.news;

import java.time.LocalDate;

public class News {
    private Long id;
    private String title;
    private String content;
    private Long languageId;
    private LocalDate postDate;

    public News() {
    }

    public News(Long id, String title, String content, Long languageId, LocalDate postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.languageId = languageId;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }
}
