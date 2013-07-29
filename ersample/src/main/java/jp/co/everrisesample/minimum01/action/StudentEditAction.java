package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dao.StudentDao;
import jp.co.everrisesample.minimum01.entity.Student;
import jp.co.everrisesample.minimum01.form.StudentEditForm;
import jp.co.everrisesample.minimum01.service.StudentService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.enums.SaveType;

/**
 * Student edit Page
 *
 */
public class StudentEditAction extends AbstractAction{

    @ActionForm
    @Resource
    public StudentEditForm studentEditForm;

    @Resource
    protected StudentService studentService;

    @Resource
    protected StudentDao studentDao;

    @Auth
    @Execute(validator = false, urlPattern = "{studentId}", removeActionForm = true)
    public String index(){
        long studentId = studentEditForm.studentIdAsLong();
        Student student = studentDao.findById(studentId);
        if(student == null){
            return "noStudent.jsp";
        }
        if(!this.hasErrors()){
            this.studentEditForm.fillParams(student);
        }
        return "index.jsp";
    }

    @Auth
    @Execute(validator = true, validate = "saveEditValidate", input = "{studentId}?redirect=true", removeActionForm = true, saveErrors = SaveType.SESSION)
    public String saveEdit(){
        Student student = studentDao.update(
        		studentEditForm.studentIdAsLong(),
        		studentEditForm.studentName,
        		studentEditForm.address,
        		studentEditForm.email);
        return "/studentDetail/" + student.id.toString() + "?redirect=true";
    }

    public ActionMessages saveEditValidate(){
        ActionMessages errors = new ActionMessages();
        long studentId = studentEditForm.studentIdAsLong();
        Student student = studentDao.findById(studentId);
        if(student == null){
            // Allow anything error. This is marking of no student data.
            // Only marking. The message does'nt show for student.
            errors.add("nostudent", new ActionMessage("", false));
        }
        return errors;
    }
}
