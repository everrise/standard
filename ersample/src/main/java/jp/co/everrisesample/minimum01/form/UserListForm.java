package jp.co.everrisesample.minimum01.form;

import static jp.co.everrisesample.minimum01.entity.Names.*;

import java.util.HashMap;
import java.util.Map;
import jp.co.everrisesample.minimum01.catalog.ORDER;
import org.apache.commons.lang3.math.NumberUtils;
import org.seasar.extension.jdbc.OrderByItem;
import org.seasar.framework.util.StringUtil;

public class UserListForm extends AbstractListForm{

    /**
     * 検索条件文字列
     */
    public String sw;
    public String getSearchWordForUrl(){
        return "sw=" + ((this.sw == null) ? "" : this.sw);
    }

    /**
     * ソート列と順序を合わせたパラメータ "_"を境に、前方がソート列を表す数字、後方が順序
     * 
     */
    public String oc;
    public String getOrderColumn(){
        if(StringUtil.isEmpty(this.oc)){
            return COLUMN.NAME.v + "_" + ORDER.ASC.v;
        }
        String[] ocArray = this.oc.split("_");
        if(ocArray.length != 2){
            return COLUMN.NAME.v + "_" + ORDER.ASC.v;
        }
        COLUMN c = COLUMN.vToE(ocArray[0]);
        if(c == null){
            return COLUMN.NAME.v + "_" + ORDER.ASC.v;
        }
        ORDER o = ORDER.vToE(ocArray[1]);
        if(o == null){
            return COLUMN.NAME.v + "_" + ORDER.ASC.v;
        }
        return c.v  + "_" + o.v;
    }
    public String getOrderColumnForUrl(){
        return "oc=" + this.getOrderColumn();
    }
    /**
     * 検索条件から順序オブジェクトを作成する
     * 
     * @return
     */
    public OrderByItem orderColumnAsOrderByItem(){
        String oc = this.getOrderColumn();
        String[] ocArray = oc.split("_");
        COLUMN c = COLUMN.vToE(ocArray[0]);
        ORDER o = ORDER.vToE(ocArray[1]);
        return new OrderByItem(c.n, o.os);
    }
    
    /**
     * 表示対象ページ
     */
    public String pg;
    public String getPage(){
        if(StringUtil.isEmpty(this.pg)){
            return "1";
        }
        if(!NumberUtils.isDigits(this.pg)){
            return "1";
        }
        return this.pg;
        
    }
    /**
     * 表示中のページをint型で返す
     * 
     * @return
     */
    public int pageAsInt(){
        return Integer.valueOf(this.getPage());
    }
    public String getPageForUrl(){
        return "pg=" + Integer.toString(this.pageAsInt());
    }
    
    /**
     * 
     */
    public enum COLUMN{
        ID("1", user().id().toString()),
        NAME("2", user().name().toString());
        public String v; String n;
        private COLUMN(String v, String n){
            this.v = v; this.n = n;
        }
        private static Map<String, COLUMN> veMap = new HashMap<String, COLUMN>();
        static{
            for(COLUMN e : COLUMN.values()){
                veMap.put(e.v, e);
            }
        }
        public static COLUMN vToE(String value){
            return veMap.get(value);
        }
        public String getV(){ return this.v; }
        public String getN(){ return this.n; }
    }
}
