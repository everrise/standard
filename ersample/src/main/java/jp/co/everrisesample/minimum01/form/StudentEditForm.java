package jp.co.everrisesample.minimum01.form;

import java.io.Serializable;

import jp.co.everrisesample.minimum01.entity.Student;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Required;

@Component(instance = InstanceType.SESSION)
public class StudentEditForm implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * Student ID
     */
    public String studentId;
    public long studentIdAsLong(){
        return Long.valueOf(this.studentId);
    }
    @Required(target = "saveEdit", arg0 = @Arg(key = "studentEdit.input.name.label", resource = true))
    public String studentName;

    @Required(target = "saveEdit", arg0 = @Arg(key = "studentEdit.input.address.label", resource = true))
    public String address;

    @Required(target = "saveEdit", arg0 = @Arg(key = "studentEdit.input.email.label", resource = true))
    public String email;

    public void fillParams(Student student){
        this.studentId = Long.toString(student.id);
        this.studentName = student.name;
        this.address = student.address;
        this.email = student.email;
    }
}
