package com.enigma;

import java.util.HashMap;
import java.util.Map;

public class CountChar {
    public static String countChar(String sentence) {

        sentence = sentence.toLowerCase();
        sentence = sentence.replaceAll("\\s+", "");
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            result.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
        }

        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "We Always Mekar";
        System.out.println("Output: \"" + countChar(input1) + "\"");

        String input2 = "coding is fun";
        System.out.println("Output: \"" + countChar(input2) + "\"");
    }
}
