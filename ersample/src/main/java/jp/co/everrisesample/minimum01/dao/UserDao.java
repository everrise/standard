package jp.co.everrisesample.minimum01.dao;

import static jp.co.everrisesample.minimum01.entity.Names.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import jp.co.everrisesample.minimum01.entity.User;

import org.apache.commons.lang3.StringUtils;
import org.seasar.extension.jdbc.OrderByItem;
import org.seasar.framework.util.StringUtil;

/**
 * {@link User}のサービスクラスです。
 * 
 */
public class UserDao extends AbstractDao<User>{
    
    /**
     * 
     * @param id
     * @return
     */
    public User findByIdSimple(Long id){
        return select().id(id).getSingleResult();
    }
    /**
     * 
     * @param userId
     * @return
     */
    public User findById(Long userId){
        return select()
                .where(
                        eq(user().id(), userId),
                        isNull(user().deletedAt())
                ).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<User> findAllOrderById(){
        return select().orderBy(asc(user().id())).getResultList();
    }
    
    /**
     * return certain conditions entity
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginIdAndPassword(String loginId, String rawPassword){
        if(StringUtil.isEmpty(loginId) || StringUtil.isEmpty(rawPassword)){
            return null;
        }
        String scrambledPassword = this.rawPasswordToScrambled(rawPassword);
        return select()
                .where(
                        eq(user().loginId(), loginId),
                        eq(user().password(), scrambledPassword),
                        isNull(user().deletedAt())
                )
                .getSingleResult();
    }
    /**
     * 
     * @param loginId
     * @return
     */
    public List<User> findAllByLoginId(String loginId){
        if(StringUtils.isEmpty(loginId)){
            return new ArrayList<User>();
        }
        return select()
                .where(
                        eq(user().loginId(), loginId),
                        isNull(user().deletedAt())
                )
                .getResultList();
    }
    
    /**
     * ユーザーを名前で検索する
     * 
     * @param name
     * @param orderByItem
     * @param limit
     * @param page
     * @return
     */
    public List<User> findAllByNameAndPageConditions(String name, OrderByItem orderByItem, int limit, int page){
        return select()
                .where(
                        contains(user().name(), name),
                        isNull(user().deletedAt())
                )
                .orderBy(orderByItem, asc(user().id()))
                .limit(limit)
                .offset(limit * (page - 1))
                .getResultList();
    }
    public long getTotalCountByName(String name){
        return select()
                .where(
                        contains(user().name(), name),
                        isNull(user().deletedAt())
                )
                .getCount();
    }
    

    /**
     * Update user data
     * if password is not empty and to update password
     * @param userId
     * @param name
     * @param loginId
     * @param password
     * @return
     */
    public User update(Long userId, String name, String loginId, String password){
        User user = this.findById(userId);
        user.name = name;
        user.loginId = loginId;
        if(!StringUtil.isEmpty(password)){
            user.password = this.rawPasswordToScrambled(password);
        }
        user.setParamsForUpdate();
        this.update(user);
        return this.findById(user.id);
    }
    
    /**
     * new insert
     * @param name
     * @param loginId
     * @param password
     * @return
     */
    public User insert(String name, String loginId, String password){
        User user = new User();
        user.name = name;
        user.loginId = loginId;
        user.password = this.rawPasswordToScrambled(password);
        user.setParamsForNew();
        this.insert(user);
        return this.findById(user.id);
    }
    
    /**
     * Make scramble password from raw password
     * @param rawPassword
     * @return
     */
    public String rawPasswordToScrambled(String rawPassword){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("SHA-1");
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException();
        }
        md.reset();
        md.update((config.PASSWORD_SALT + rawPassword).getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for(byte b : digest){
            sb.append(Integer.toHexString((b >> 4) & 0x0F));
            sb.append(Integer.toHexString(b & 0x0F));
        }
        return sb.toString();
    }
}