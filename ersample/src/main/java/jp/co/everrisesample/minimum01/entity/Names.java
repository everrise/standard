package jp.co.everrisesample.minimum01.entity;

import javax.annotation.Generated;
import jp.co.everrisesample.minimum01.entity.ChartNames._ChartNames;
import jp.co.everrisesample.minimum01.entity.StudentNames._StudentNames;
import jp.co.everrisesample.minimum01.entity.UserNames._UserNames;

/**
 * Summary of names class
 * 
 */
public class Names {

    /**
     * return name class of {@link Chart}
     * 
     */
    public static _ChartNames chart() {
        return new _ChartNames();
    }

    /**
     * return name class of {@link Student}
     * 
     */
    public static _StudentNames student() {
        return new _StudentNames();
    }

    /**
     * return name class of {@link User}
     * 
     */
    public static _UserNames user() {
        return new _UserNames();
    }
}