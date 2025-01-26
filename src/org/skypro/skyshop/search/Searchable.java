package org.skypro.skyshop.search;


public interface Searchable {
    String getSearchTerm();

    String getSearchContent();



    default String getStringPresentation() {
        return getSearchTerm() + " - " + getSearchContent();
    }
}
