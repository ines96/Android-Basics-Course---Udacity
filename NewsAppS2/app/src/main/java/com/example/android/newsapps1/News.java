package com.example.android.newsapps1;

public class News {

    /** Title of the article */
    private String mTitle;

    /** Section of the article*/
    private String mSection;

    /** Publish date */
    private String mPublishDate;

    /** Website URL of the article */
    private String mUrl;

    private String mAuthor;


    /**
     * Constructs a new {@link News} object.
     *
     * @param title is the title of the article
     * @param section is the section which the article belongs to
     * @param publishDate is the date in which the article was published
     * @param url is the website URL to find the whole article.
     */
    public News(String title, String section, String publishDate, String url, String mAuthor) {
        this.mTitle = title;
        this.mSection = section;
        this.mPublishDate = publishDate;
        this.mUrl = url;
        this.mAuthor = mAuthor;
    }

    /**
     * Returns the title of the article.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the section where the article belongs.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the date of the publishment.
     */
    public String getPublishDate() {
        return mPublishDate;
    }

    /**
     * Returns the website URL to find the complete article.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the author of the article.
     */
    public String getmAuthor() {
        return mAuthor;
    }
}
