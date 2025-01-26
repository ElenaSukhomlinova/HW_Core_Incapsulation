package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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

    public Searchable findMostRelevant(Searchable[] searchables, String search) throws BestResultNotFound {
        if (searchables == null || searchables.length == 0 || search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Массив объектов или поисковая строка не могут быть пустыми.");
        }

        Searchable mostRelevant = null;
        int maxCount = -1;

        for (Searchable searchable : searchables) {
            String term = searchable.getSearchTerm();
            int count = countOccurrences(term, search);


            if (count > maxCount) {
                maxCount = count;
                mostRelevant = searchable;
            }
        }

        if (mostRelevant == null) {
            throw new BestResultNotFound("Не найден подходящий объект для поискового запроса: " + search);
        }

        return mostRelevant;
    }


    private int countOccurrences(String text, String search) {
        if (text == null || search == null || search.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;


        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }
}

