package jp.co.everrisesample.minimum01.service;

import javax.annotation.Resource;
import jp.co.everrisesample.minimum01.Config;

/**
 * actionの基底クラス
 * 共通処理を書くというよりも共通インスタンスを注入してもらうものを記述
 *
 */
public abstract class AbstractService{
    //@Resource
    //protected LoginUserDto loginUserDto;

    @Resource
    protected Config config;
}
