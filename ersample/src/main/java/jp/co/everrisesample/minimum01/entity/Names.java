package jp.co.everrisesample.minimum01.entity;

import jp.co.everrisesample.minimum01.entity.ChartNames._ChartNames;
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
     * return name class of {@link User}
     *
     */
    public static _UserNames user() {
        return new _UserNames();
    }
}