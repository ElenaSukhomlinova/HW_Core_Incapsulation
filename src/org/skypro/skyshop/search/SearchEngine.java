package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables;
    private int size;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
        this.size = 0;
    }

    public void addItem(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        } else {
            System.out.println("Нельзя добавить null елемент");
        }
    }

    public TreeMap <String, Searchable> search(String request) {
        TreeMap <String, Searchable> results = new TreeMap<>();
        int count = 0;

        for (Searchable searchable : searchables) {

            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(request.toLowerCase())) {
                results.put(searchable.getSearchTerm(), searchable);

            }

        }
        return results;
    }

    public Searchable findMostRelevant(List<Searchable> searchables, String search) throws BestResultNotFound {
        if (searchables == null || searchables.isEmpty() || search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Массив объектов или поисковая строка не могут быть пустыми.");
        }

        Searchable mostRelevant = null;
        int maxCount = 0;

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

