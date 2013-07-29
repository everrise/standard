package jp.co.everrisesample.minimum01.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Required;

@Component(instance = InstanceType.SESSION)
public class StudentAddForm implements Serializable{
    private static final long serialVersionUID = 1L;

    @Required(target = "saveStudentAdd", arg0 = @Arg(key = "studentAdd.input.name.label", resource = true))
    public String studentName;

    @Required(target = "saveStudentAdd", arg0 = @Arg(key = "studentAdd.input.address.label", resource = true))
    public String address;

    @Required(target = "saveStudentAdd", arg0 = @Arg(key = "studentAdd.input.email.label", resource = true))
    public String email;
}
