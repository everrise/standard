package jp.co.everrise.utils;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 文字列関連のユーティリティクラス.
 * 
 */
public abstract class ErStringUtil{
    /** 空文字 */
    public static final String EMPTY_STRING = "";
    private static final Charset UTF8 = Charset.forName("UTF-8");

    /**
     * String to String under null value
     */
    public static String toString(String value, String nullValue){
        return value == null ? nullValue : value;
    }

    /**
     * 文字列長取得(NULL判定付き).
     * 
     * @param value
     * @return
     */
    public static int length(String value){
        return (value == null ? 0 : value.length());
    }

    /**
     * 文字列の連結（デリミタ指定あり）.
     * 
     * @return
     */
    public static String join(String delimiter, String... strings){
        if(strings == null){
            return EMPTY_STRING;
        }
        delimiter = toString(delimiter, "");
        return StringUtils.join(strings, delimiter);
    }
    /**
     * 文字列の連結（デリミタ指定あり）.
     * 
     * @return
     */
    public static String join(List<String> stringList, String delimiter){
        if(stringList == null){
            return EMPTY_STRING;
        }
        delimiter = toString(delimiter, "");
        return StringUtils.join(stringList, delimiter);
    }
    

    /**
     * 文字列の連結.
     */
    public static String concat(String... strings){
        return join("", strings);
    }
    public static String[] splitTrim(String value, String separator){
        String[] strings = StringUtils.split(value, separator);
        String[] result = new String[strings.length];
        for(int i = 0; i < strings.length; i++){
            result[i] = StringUtils.trim(strings[i]);
        }
        return result;
    }
    /**
     * バイト長の取得.
     * 
     * @param str
     * @return バイト長
     */
    public static int byteLength(String str){
        byte bytes[] = str.getBytes(UTF8);
        return bytes.length;
    }
}
