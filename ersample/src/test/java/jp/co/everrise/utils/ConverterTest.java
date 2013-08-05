package jp.co.everrise.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class ConverterTest {

    public void testNullToEmpty() {
        assertThat(Converter.nullToEmpty(null), is(""));
        assertThat(Converter.nullToEmpty("1"), is("1"));
    }

    public void testIntToStringInt() {
    }

    public void testIntToStringInteger() {
    }

    public void testStringToInt() {
        assertThat(Converter.stringToInt("1231231"), is(1231231));
    }

    @Test(expected=NumberFormatException.class)
    public void testStringToInt2() {
        Converter.stringToInt("23432423423423424234233423423432");// throw exception
        fail(); // not reach
    }

    @Test(expected=NumberFormatException.class)
    public void testStringToInt3() {
        assertThat(Converter.stringToInt("4.432"), is(4));
    }

    @Test(expected=NumberFormatException.class)
    public void testStringToInt4() {
        assertThat(Converter.stringToInt("    "), is(0));
    }

    @Test(expected=NumberFormatException.class)
    public void testStringToInt5() {
        assertThat(Converter.stringToInt(null), is(0));
    }


}
