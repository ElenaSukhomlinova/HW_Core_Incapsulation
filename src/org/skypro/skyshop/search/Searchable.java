package org.skypro.skyshop.search;


public interface Searchable {
    String getSearchTerm();

    String getSearchContent();

    String getName();

    default String getStringPresentation() {
        return getName() + " - " + getSearchContent();
    }
}
