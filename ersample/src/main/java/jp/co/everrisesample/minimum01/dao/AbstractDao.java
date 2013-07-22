package jp.co.everrisesample.minimum01.dao;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.Config;

import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * Base class of DAO
 * 
 */
public abstract class AbstractDao<ENTITY> extends S2AbstractService<ENTITY>{
    @Resource
    protected Config config;
}