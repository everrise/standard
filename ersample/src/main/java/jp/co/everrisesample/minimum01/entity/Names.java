package jp.co.everrisesample.minimum01.entity;

import javax.annotation.Generated;
import jp.co.everrisesample.minimum01.entity.ArticleNames._ArticleNames;
import jp.co.everrisesample.minimum01.entity.CategoryNames._CategoryNames;
import jp.co.everrisesample.minimum01.entity.ChartNames._ChartNames;
import jp.co.everrisesample.minimum01.entity.UserNames._UserNames;

/**
 * Summary of names class
 * 
 */
public class Names {

    /**
     * return name class of {@link Article}
     * 
     */
    public static _ArticleNames article() {
        return new _ArticleNames();
    }

    /**
     * return name class of {@link Category}
     * 
     */
    public static _CategoryNames category() {
        return new _CategoryNames();
    }

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