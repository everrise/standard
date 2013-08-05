package jp.co.everrise.utils;


public class Converter {

    public static String nullToEmpty(String input){
        if(input == null){
            return "";
        } else{
            return input;
        }
    }

    public static String intToString(int input){
        return Integer.toString(input);
    }

    public static String intToString(Integer input){
        return Integer.toString(input);
    }

    public static int stringToInt(String input) throws NumberFormatException{
        return Integer.valueOf(nullToEmpty(input));
    }


}
