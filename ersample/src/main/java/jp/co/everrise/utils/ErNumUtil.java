package jp.co.everrise.utils;


/**
 */
public abstract class ErNumUtil{
    /**
     * Integer数値の比較
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean eq(int a, int b){
        return a == b;
    }
    public static boolean eq(Integer a, int b){
        if(a == null) return false;
        return a == b;
    }
    public static boolean eq(int a, Integer b){
        if(b == null) return false;
        return a == b;
    }
    public static boolean eq(Integer a, Integer b){
        if(a == null || b == null) return false;
        return a.equals(b);
    }
    /**
     * Long数値の比較
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean eq(long a, long b){
        return a == b;
    }
    public static boolean eq(Long a, long b){
        if(a == null) return false;
        return a == b;
    }

    public static boolean eq(long a, Long b){
        if(b == null) return false;
        return a == b;
    }
    public static boolean eq(Long a, Long b){
        if(a == null || b == null) return false;
        return a.equals(b);
    }
}
