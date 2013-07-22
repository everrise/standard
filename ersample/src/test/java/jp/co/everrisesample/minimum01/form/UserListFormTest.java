package jp.co.everrisesample.minimum01.form;

import static org.hamcrest.Matchers.*;
import static org.seasar.framework.unit.S2Assert.*;

import org.junit.runner.RunWith;
import org.seasar.extension.jdbc.OrderByItem;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class UserListFormTest{

    public void testOrderColumnAsOrderByItem(){
        UserListForm ulf  = new UserListForm();
        ulf.oc = "1_1";
        OrderByItem result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("id asc"));
        
        ulf.oc = "1_2";
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("id desc"));
        
        ulf.oc = "2_1";
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("name asc"));
        
        ulf.oc = "2_2";
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("name desc"));
        
        ulf.oc = "2_";
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("name asc"));

        ulf.oc = "";
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("name asc"));
        
        ulf.oc = null;
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("name asc"));

        ulf.oc = "hogehoge";
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("name asc"));

        ulf.oc = "1_2_3_4_5";
        result = ulf.orderColumnAsOrderByItem();
        System.out.println(result.getCriteria());
        assertThat(result.getCriteria(), is("name asc"));

    }
    
    public void testPageAsInt(){
    }

}
