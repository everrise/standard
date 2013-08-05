package jp.co.everrisesample.minimum01.service;


import java.util.List;

import javax.annotation.Resource;

import jp.co.everrise.utils.ErNumUtil;
import jp.co.everrisesample.minimum01.dao.UserDao;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.User;

import org.seasar.extension.jdbc.OrderByItem;

public class UserService extends AbstractService{

    @Resource
    protected UserDao userDao;

    /**
     *
     * @param name
     * @param loginId
     * @param password
     * @return
     */
    public User createUser(String name, String loginId, String password){
        return userDao.insert(name, loginId, password);
    }
    /**
     *
     * @param userId
     * @param name
     * @param loginId
     * @param password
     * @return
     */
    public User updateUser(Long userId, String name, String loginId, String password){
        return userDao.update(userId, name, loginId, password);
    }

    /**
     *
     * @param loginId
     * @return
     */
    public boolean isValidLoginIdForCreate(String loginId){
        List<User> userList = userDao.findAllByLoginId(loginId);
        return userList.isEmpty();
    }
    /**
     *
     * @param userId
     * @param loginId
     * @return
     */
    public boolean isValidLoginIdForUpdate(Long userId, String loginId){
        List<User> userList = userDao.findAllByLoginId(loginId);
        if(userList.isEmpty()){
            return true;
        }
        if(userList.size() == 1 && ErNumUtil.eq(userList.get(0).id, userId)){
            return true;
        }
        return false;
    }

    /**
     *
     * @param name
     * @param orderByItem
     * @param limit
     * @param page
     * @return
     */
    public ListForPageDto<User> searchByNameAndPageConditions(String name, OrderByItem orderByItem, int limit, int page){
        ListForPageDto<User> pageData = new ListForPageDto<User>();
        pageData.resultList = userDao.findAllByNameAndPageConditions(name, orderByItem, limit, page);
        pageData.total = userDao.getTotalCountByName(name);
        pageData.page = page;
        pageData.limit = limit;
        return pageData;
    }
}
