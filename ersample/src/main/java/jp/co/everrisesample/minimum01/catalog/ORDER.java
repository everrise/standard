package jp.co.everrisesample.minimum01.catalog;

import java.util.HashMap;
import java.util.Map;

import org.seasar.extension.jdbc.OrderByItem.OrderingSpec;

public enum ORDER {
    ASC("1", OrderingSpec.ASC), DESC("2", OrderingSpec.DESC);
    public String v;
    public OrderingSpec os;

    private ORDER(String v, OrderingSpec os) {
        this.v = v;
        this.os = os;
    }

    private static Map<String, ORDER> veMap = new HashMap<String, ORDER>();
    static {
        for (ORDER e : ORDER.values()) {
            veMap.put(e.v, e);
        }
    }

    public static ORDER vToE(String value) {
        return veMap.get(value);
    }

    public String getV() {
        return this.v;
    }

    public OrderingSpec getOs() {
        return this.os;
    }
}
