package jp.co.everrisesample.minimum01.dto;

import java.io.Serializable;

import jp.co.everrisesample.minimum01.entity.User;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * ログイン情報を保持しておくためのDTO
 * セッションスコープなのでユーザーがアクセスしているならオブジェクトは常に同一
 *
 */
@Component(instance=InstanceType.SESSION)
public class LoginUserDto implements Serializable{
    private static final long serialVersionUID = 1L;
    public Long userId = null;
    public String userName = null;
    public boolean loggedin = false;
    /**
     * 
     * @return
     */
    public Long getUserId(){
        return userId;
    }
    /**
     * 
     * @return
     */
    public String getUserName(){
        return userName;
    }
    /**
     * 
     * @return
     */
    public boolean isLogin(){
        return loggedin;
    }
    public void login(User u){
        this.userId = u.id;
        this.userName = u.name;
        this.loggedin = true;
    }
    public void logout(){
        this.userId = null;
        this.userName = null;
        this.loggedin = false;
    }
    
}
