package org.skypro.skyshop.search;

public final class Article implements Searchable {
    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String toString() {
        return articleName + "\n" + articleText;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getSearchContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return articleName;
    }
}


