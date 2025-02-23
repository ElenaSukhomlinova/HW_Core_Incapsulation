package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables;
    private int size;

    public SearchEngine() {
        this.searchables = new HashSet<>();
        this.size = 0;
    }

    public void addItem(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        } else {
            System.out.println("Нельзя добавить null елемент");
        }
    }

    public TreeSet <Searchable> search(String request) {
        Comparator<Searchable> comparator = (s1, s2) -> {
            int lengthCompare = Integer.compare(s2.getSearchTerm().length(),s1.getSearchTerm().length());
            if(lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getSearchTerm().compareTo(s2.getSearchTerm());
        };

        TreeSet<Searchable> results = new TreeSet<>(comparator);


        for (Searchable searchable : searchables) {

            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(request.toLowerCase())) {
                results.add(searchable);

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

