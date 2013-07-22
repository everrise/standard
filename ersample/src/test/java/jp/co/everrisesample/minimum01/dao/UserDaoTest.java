package jp.co.everrisesample.minimum01.dao;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.seasar.extension.jdbc.operation.Operations.*;
import static org.seasar.framework.unit.S2Assert.*;
import static jp.co.everrisesample.minimum01.entity.Names.*;


import jp.co.everrisesample.minimum01.entity.User;


import org.junit.runner.RunWith;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.unit.PreparationType;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

/**
 * {@link UserService}のテストクラスです。
 * 
 */
@RunWith(Seasar2.class)
public class UserDaoTest{
    private UserDao userDao;
    private JdbcManager jdbcManager;
    TestContext ctx;
    public void before(){
        ctx.setPreparationType(PreparationType.ALL_REPLACE);
    }
    
    /**
     * {@link #userDao}が利用可能であることをテストします。
     * 
     * @throws Exception
     */
    public void testAvailable() throws Exception{
        assertNotNull(userDao);
    }
    
    public void testFindAllByNameAndPageConditions(){
        List<User> resultList = userDao.findAllByNameAndPageConditions("田", asc(user().id()), 10, 1);
        assertThat(resultList.size(), is(3));
        assertThat(resultList.get(0).id, is(123L));
        assertThat(resultList.get(1).id, is(124L));
        assertThat(resultList.get(2).id, is(132L));
        
        resultList = userDao.findAllByNameAndPageConditions("田", desc(user().id()), 10, 1);
        assertThat(resultList.size(), is(3));
        assertThat(resultList.get(0).id, is(132L));
        assertThat(resultList.get(1).id, is(124L));
        assertThat(resultList.get(2).id, is(123L));
        
        resultList = userDao.findAllByNameAndPageConditions(null, desc(user().id()), 10, 1);
        assertThat(resultList.size(), is(10));
        assertThat(resultList.get(0).id, is(137L));
        assertThat(resultList.get(1).id, is(136L));
        assertThat(resultList.get(2).id, is(135L));
        assertThat(resultList.get(3).id, is(134L));
        assertThat(resultList.get(4).id, is(133L));
        assertThat(resultList.get(5).id, is(132L));
        assertThat(resultList.get(6).id, is(131L));
        assertThat(resultList.get(7).id, is(130L));
        assertThat(resultList.get(8).id, is(129L));
        assertThat(resultList.get(9).id, is(128L));
        
        resultList = userDao.findAllByNameAndPageConditions(null, desc(user().id()), 10, 2);
        assertThat(resultList.size(), is(5));
        assertThat(resultList.get(0).id, is(127L));
        assertThat(resultList.get(1).id, is(126L));
        assertThat(resultList.get(2).id, is(125L));
        assertThat(resultList.get(3).id, is(124L));
        assertThat(resultList.get(4).id, is(123L));
    }
    public void testGetTotalCountByName(){
        long result = userDao.getTotalCountByName("田");
        assertThat(result, is(3L));
        result = userDao.getTotalCountByName(null);
        assertThat(result, is(15L));
    }
    
    public void testFindByLoginIdAndPassword(){
        userDao.config.PASSWORD_SALT = "ASDFXCFHYKF8289AFVSMMNV221SQTT";
        User result = userDao.findByLoginIdAndPassword("ytaro", "hogehoge");
        assertThat(result.id, is(123L));
    }
    public void testFindAllByLoginId(){
        userDao.config.PASSWORD_SALT = "ASDFXCFHYKF8289AFVSMMNV221SQTT";
        List<User> resultList = userDao.findAllByLoginId("inosato");
        assertThat(resultList.get(0).id, is(137L));
    }
    public void testUpdate(){
        userDao.config.PASSWORD_SALT = "ASDFXCFHYKF8289AFVSMMNV221SQTT";
        User result = userDao.update(123L, "すちーぶじょぶ", "ijob", "piyopiyo");
        assertThat(result.id, is(123L));
        assertThat(result.name, is("すちーぶじょぶ"));
        assertThat(result.loginId, is("ijob"));
        assertThat(result.password, is("efbd42861c548ed5a8210d8c817bc8c311691a7c"));
        result = userDao.update(123L, "すちーぶじょぶ", "ijob", null);
        assertThat(result.id, is(123L));
        assertThat(result.name, is("すちーぶじょぶ"));
        assertThat(result.loginId, is("ijob"));
        assertThat(result.password, is("efbd42861c548ed5a8210d8c817bc8c311691a7c"));
        result = userDao.update(123L, "すちーぶじょぶ", "ijob", "");
        assertThat(result.id, is(123L));
        assertThat(result.name, is("すちーぶじょぶ"));
        assertThat(result.loginId, is("ijob"));
        assertThat(result.password, is("efbd42861c548ed5a8210d8c817bc8c311691a7c"));
        result = jdbcManager.from(User.class).id(123L).getSingleResult();
        assertThat(result.id, is(123L));
        assertThat(result.name, is("すちーぶじょぶ"));
        assertThat(result.loginId, is("ijob"));
        assertThat(result.password, is("efbd42861c548ed5a8210d8c817bc8c311691a7c"));
        
        
        
    }
    
    public void testRawPasswordToScrambled(){
        userDao.config.PASSWORD_SALT = "ASDFXCFHYKF8289AFVSMMNV221SQTT";
        String result = userDao.rawPasswordToScrambled("hogehoge");
        assertThat(result, is("30df36bca9ee50b4954b067863ea2bc2ad8f1543"));
        System.out.println(result);
        result = userDao.rawPasswordToScrambled("piyopiyo");
        assertThat(result, is("efbd42861c548ed5a8210d8c817bc8c311691a7c"));
        System.out.println(result);
        
    }

}