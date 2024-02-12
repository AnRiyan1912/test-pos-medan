package com.enigma;

import java.util.*;

public class CharacterSort {
    public static String sortCharacters(List<String> words) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (Character.isLetter(c)) {
                    charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
                }
            }
        }
        List<Map.Entry<Character, Integer>> charCounts = new ArrayList<>(charCountMap.entrySet());
        charCounts.sort((a, b) -> {
            int compare = b.getValue().compareTo(a.getValue());
            if (compare == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return compare;
        });

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCounts) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<String> input1 = Arrays.asList("Abc", "bCd");
        System.out.println("Input: " + input1);
        System.out.println("Expected Output: bACcd");
        System.out.println("Output: " + sortCharacters(input1));

        List<String> input2 = Arrays.asList("Oke", "One");
        System.out.println("\nInput: " + input2);
        System.out.println("Expected Output: Oekn");
        System.out.println("Output: " + sortCharacters(input2));

        List<String> input3 = Arrays.asList("Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti");
        System.out.println("\nInput: " + input3);
        System.out.println("Expected Output: aenrktiBDPTUdimu");
        System.out.println("Output: " + sortCharacters(input3));
    }
}
