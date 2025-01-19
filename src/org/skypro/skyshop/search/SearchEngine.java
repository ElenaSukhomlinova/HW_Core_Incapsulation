package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }

    public void addItem(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size++] = searchable;
        } else {
            System.out.println("Массив переполнен");
        }
    }

    public Searchable[] search(String request) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable searchable : searchables) {

            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(request.toLowerCase())) {
                results[count++] = searchable;
                if (count == 5) break;
            }
            
        }
        return results;
    }
}
