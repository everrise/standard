package jp.co.everrisesample.minimum01.entity;

import jp.co.everrisesample.minimum01.entity.ChartNames._ChartNames;
import jp.co.everrisesample.minimum01.entity.ManufacturerNames._ManufacturerNames;
import jp.co.everrisesample.minimum01.entity.ProductNames._ProductNames;
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
     * return name class of {@link Manufacturer}
     *
     */
    public static _ManufacturerNames manufacturer() {
        return new _ManufacturerNames();
    }

    /**
     * return name class of {@link Product}
     *
     */
    public static _ProductNames product() {
        return new _ProductNames();
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