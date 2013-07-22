package jp.co.everrisesample.minimum01.form;

public class UserDetailForm extends AbstractListForm{

    /**
     * ユーザーID
     */
    public String userId;
    public long userIdAsLong(){
        return Long.valueOf(this.userId);
    }
}
