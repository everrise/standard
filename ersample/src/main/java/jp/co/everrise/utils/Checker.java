package jp.co.everrise.utils;

import java.util.regex.Pattern;


public class Checker {
    public static boolean isValidEmail(String input){
        return Pattern.matches("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}", input);
    }
}