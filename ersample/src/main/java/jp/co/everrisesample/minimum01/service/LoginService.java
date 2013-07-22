package jp.co.everrisesample.minimum01.service;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.dao.UserDao;
import jp.co.everrisesample.minimum01.entity.User;

/**
 * 
 *
 */
public class LoginService extends AbstractService{

    @Resource
    protected UserDao userDao;
    /**
     * 
     * @param loginId
     * @param password
     * @return
     */
    public boolean canLogin(String loginId, String password){
        User u = userDao.findByLoginIdAndPassword(loginId, password);
        return u != null;
    }
}
