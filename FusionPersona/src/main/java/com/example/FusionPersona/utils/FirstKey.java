package com.example.FusionPersona.utils;

public class FirstKey {
    public static String UpperCase(String value) {
        String[] splitValue = value.split(" ");
        String result = "";
        for (String word:splitValue) {
            result += word.toUpperCase().charAt(0) + word.substring(1, word.length()).toLowerCase().concat(" ");
        }
        return result.trim();
    }
}
