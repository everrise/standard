package jp.co.everrisesample.minimum01.catalog;

import java.util.HashMap;
import java.util.Map;

public enum COOKIE_KEY{
    LOGIN_PASS("lp"),
    HOGE_PIYO("hp");
    public String v;
    private COOKIE_KEY(String v){
        this.v = v;
    }
    private static Map<String, COOKIE_KEY> veMap = new HashMap<String, COOKIE_KEY>();
    static{
        for(COOKIE_KEY e : COOKIE_KEY.values()){
            veMap.put(e.v, e);
        }
    }
    public static COOKIE_KEY vToE(String value){
        return veMap.get(value);
    }
    public String getV(){ return this.v; }
}
