package jp.co.everrise.utils;

import static org.hamcrest.Matchers.*;
import static org.seasar.framework.unit.S2Assert.*;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class ErNumUtilTest{

    public void testEqIntInt(){
        assertThat(ErNumUtil.eq(1, 1), is(true));
        assertThat(ErNumUtil.eq(1, 2), is(false));
        assertThat(ErNumUtil.eq(100, 22002), is(false));
        assertThat(ErNumUtil.eq(123456, 123456), is(true));
    }
    public void testEqIntegerInt(){
        Integer i = 5000;
        assertThat(ErNumUtil.eq(i, 5000), is(true));
        assertThat(ErNumUtil.eq(i, 2), is(false));
        assertThat(ErNumUtil.eq(i, 22002), is(false));
        i = 123456;
        assertThat(ErNumUtil.eq(i, 123456), is(true));
        i = null;
        assertThat(ErNumUtil.eq(i, 123456), is(false));
        
    }
    public void testEqIntInteger(){
        Integer i = 5000;
        assertThat(ErNumUtil.eq(5000, i), is(true));
        assertThat(ErNumUtil.eq(2, i), is(false));
        assertThat(ErNumUtil.eq(22002, i), is(false));
        i = 123456;
        assertThat(ErNumUtil.eq(123456, i), is(true));
        i = null;
        assertThat(ErNumUtil.eq(22002, i), is(false));
    }

    public void testEqIntegerInteger(){
        Integer i = 5000;
        Integer ii = 5000;
        assertThat(ErNumUtil.eq(i, ii), is(true));
        ii = 5001;
        assertThat(ErNumUtil.eq(i, ii), is(false));
        ii = null;
        assertThat(ErNumUtil.eq(i, ii), is(false));
        i = null;
        ii = 45555;
        assertThat(ErNumUtil.eq(i, ii), is(false));
        i = null;
        ii = null;
        assertThat(ErNumUtil.eq(i, ii), is(false));
    }

    public void testEqLongLong(){
        assertThat(ErNumUtil.eq(1L, 1L), is(true));
        assertThat(ErNumUtil.eq(1L, 2L), is(false));
        assertThat(ErNumUtil.eq(100L, 22002L), is(false));
        assertThat(ErNumUtil.eq(123456L, 123456L), is(true));
    }

    public void testEqLongLong1(){
        Long i = 5000L;
        assertThat(ErNumUtil.eq(i, 5000), is(true));
        assertThat(ErNumUtil.eq(i, 2), is(false));
        assertThat(ErNumUtil.eq(i, 22002), is(false));
        i = 123456L;
        assertThat(ErNumUtil.eq(i, 123456), is(true));
        i = null;
        assertThat(ErNumUtil.eq(i, 123456), is(false));
    }

    public void testEqLongLong2(){
        Long i = 5000L;
        assertThat(ErNumUtil.eq(5000, i), is(true));
        assertThat(ErNumUtil.eq(2, i), is(false));
        assertThat(ErNumUtil.eq(22002, i), is(false));
        i = 123456L;
        assertThat(ErNumUtil.eq(123456, i), is(true));
        i = null;
        assertThat(ErNumUtil.eq(22002, i), is(false));
    }

    public void testEqLongLong3(){
        Long i = 5000L;
        Long ii = 5000L;
        assertThat(ErNumUtil.eq(i, ii), is(true));
        ii = 5001L;
        assertThat(ErNumUtil.eq(i, ii), is(false));
        ii = null;
        assertThat(ErNumUtil.eq(i, ii), is(false));
        i = null;
        ii = 45555L;
        assertThat(ErNumUtil.eq(i, ii), is(false));
        i = null;
        ii = null;
        assertThat(ErNumUtil.eq(i, ii), is(false));
    }
}
