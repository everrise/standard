package jp.co.everrisesample.minimum01.service;

import static org.hamcrest.Matchers.*;
import static org.seasar.framework.unit.S2Assert.*;
import jp.co.everrisesample.minimum01.service.LoginService;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.PreparationType;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

@RunWith(Seasar2.class)
public class LoginServiceTest{
    private LoginService loginService;
    TestContext ctx;
    public void before(){
        ctx.setPreparationType(PreparationType.ALL_REPLACE);
    }

    public void testCanLogin(){
        boolean result = loginService.canLogin("ytaro", "hogehoge");
        assertThat(result , is(true));
        result = loginService.canLogin("ytaro", "hogehogehoge");
        assertThat(result , is(false));
        result = loginService.canLogin(null, null);
        assertThat(result , is(false));
        result = loginService.canLogin("", "");
        assertThat(result , is(false));
        result = loginService.canLogin("aaaa", "bbbb");
        assertThat(result , is(false));
    }
}
